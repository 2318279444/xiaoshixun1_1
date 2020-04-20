package com.bw.download3;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

/*
 *@auther:邓先超
 *@Date: 2020/3/18
 *@Time:19:36
 *@Description:
 **/
public class DownLoadFile {

    private static final String SP_NAME = "download_file";
    private static final String CURR_LENGTH = "curr_length";
    private DownListener mDownListener;
    private String downPath;
    //文件保存本地的路径
    private String mFilePath;

    //规定开启的线程数
    private final int mThreadCount = 3;
    //使用volatile防止多线程不安全
    private volatile int runningThreadCount;//正在运行的线程数
    //已经下载的长度
    private volatile int mCurrentLength;
    //定义下载的状态
    private final String DOWN_INIT = "1";
    private final String DOWN_START = "2";
    private final String DOWN_PAUSE = "3";
    private String stateDownload = DOWN_INIT;//当前线程状态

    //文件的总长度
    private int mFileLength;

    //定义要开启线程的个数 放在数组中
    private Thread[] mThread;
    private Context mContext;
    //参数1：本地文件对路径 参数2：要下载对那个url
    public DownLoadFile(String path, String url, Context context) {
        this.mFilePath = path;
        this.downPath = url;
        this.mContext = context;
        runningThreadCount = 0;

    }

    public void setmDownListener(DownListener mDownListener) {
        this.mDownListener = mDownListener;
    }

    public interface DownListener {
        void onProgress(int progress);

        void onSuccess(String success);

        void onError(String error);
    }

    protected void cancel() {
        if (mThread != null) {
            //若线程处于等待状态，则while循环处于阻塞状态，无法跳出循环，必须先唤醒线程，才能执行取消任务
            if (stateDownload.equals(DOWN_PAUSE))
                start();
            for (Thread dt : mThread) {
                ((DownThread) dt).cancle();
            }
        }
    }

    //开始下载初始化操作  这里面是耗时操作所以需要放在自线程
    public void downLoad() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (mThread == null) {
                    mThread = new Thread[mThreadCount];
                }
                try {
                    //根据文件大小，先创建一个空文件
                    //“r“——以只读方式打开。调用结果对象的任何 write 方法都将导致抛出 IOException。
                    //“rw“——打开以便读取和写入。如果该文件尚不存在，则尝试创建该文件。
                    //“rws“—— 打开以便读取和写入，对于 “rw”，还要求对文件的内容或元数据的每个更新都同步写入到底层存储设备。
                    //“rwd“——打开以便读取和写入，对于 “rw”，还要求对文件内容的每个更新都同步写入到底层存储设备。
                    RandomAccessFile randomAccessFile = new RandomAccessFile(mFilePath, "rwd");
                    URL url = new URL(downPath);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    if (connection.getResponseCode() == 200) {
                        //获取下载文件对总大小
                        mFileLength = connection.getContentLength();
                        randomAccessFile.setLength(mFileLength);
                        randomAccessFile.close();
                        int threadIndex = mFileLength / mThreadCount;
                        SharedPreferences sp = mContext.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
                        //存储下载文件总大小
                        sp.edit().putInt("fileLength",mFileLength).apply();
                        //这个参数没有其他功能知识用来记录进度条的进度
                        mCurrentLength = sp.getInt(CURR_LENGTH, 0);
                        int progress = (int) ((float) mCurrentLength / (float) mFileLength * 100);
                        handler.sendEmptyMessage(progress);
                        Log.d("呵呵",progress+","+mCurrentLength);
                        for (int i = 0; i < mThread.length; i++) {
                            //每个线程开始下载的标记
                            int start = sp.getInt(SP_NAME + (i + 1), i * threadIndex);
                            //每个线程结束下载的标记
                            int end = (i + 1) * threadIndex - 1;
                            //将最后一个线程结束位置扩大，防止文件下载不完全，大了不影响，小了文件失效
                            if (i + 1 == mThreadCount) {
                                end = end * 2;
                            }
                            mThread[i] = new DownThread(start, end, i + 1,sp);
                            Log.d("线程池",start+","+end+",");
                            mThread[i].start();
                        }
                    } else {
                        handler.sendEmptyMessage(FAILURE);
                        return;
                    }

                } catch (Exception e) {
                    e.printStackTrace();

                }


            }
        }).start();

    }


    class DownThread extends Thread {
        //判断是否下载
        private boolean isGoOn = true;
        private int endIndex;//结束节点
        public int currentIndex;//已经下载到的节点
        private int startIndex;//开始节点
        private int threadId;//线程ID
        private SharedPreferences sp;

        public DownThread(int startIndex, int endIndex, int threadId,SharedPreferences sp) {
            this.endIndex = endIndex;
            this.currentIndex = startIndex;//已经下载到的节点
            this.startIndex = startIndex;
            this.threadId = threadId;
            this.sp = sp;
            runningThreadCount++;
        }

        //取消下载
        public void cancle() {
            isGoOn = false;
        }

        @Override
        public void run() {
            try {
                //这行代码不考虑

                RandomAccessFile randomAccessFile = new RandomAccessFile(mFilePath, "rwd");
                URL url = new URL(downPath);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestProperty("Range", "bytes=" + startIndex + "-" + endIndex);
                if (connection.getResponseCode() == 206) {
                    randomAccessFile.seek(startIndex);
                    int leng = 0;
                    byte[] bytes = new byte[1024];
                    //startIndex=0 endIndex=32
                    //  这是第一个线程对象要下载的东西 
                    // 我请求服务器就请求到这就完事了
                    while ((leng = connection.getInputStream().read(bytes)) != -1) {
                        if (!isGoOn){
                            break;
                        }
                        if (mDownListener != null) {
                            //这个变量是大的变量用来统计三个线程下载多少的总和
                            int progress = (int) ((float) mCurrentLength / (float) mFileLength * 100);
                            mCurrentLength += leng;
                            handler.sendEmptyMessage(progress);
                        }
                        //这个变量是每个线程的局部变量
                        randomAccessFile.write(bytes, 0, leng);
                        //记载指针指到最后那个位置
                        currentIndex += leng;
                        synchronized (DOWN_PAUSE) {
                            if (stateDownload.equals(DOWN_PAUSE)) {
                                DOWN_PAUSE.wait();
                            }
                        }
                    }
                    randomAccessFile.close();
                    runningThreadCount--;
                    if (!isGoOn) {
                        Log.d("呵呵", "run: ");
                        if (currentIndex < endIndex) {
                            sp.edit().putInt(SP_NAME + threadId, currentIndex).apply();
                            sp.edit().putInt(CURR_LENGTH, mCurrentLength).apply();
                            //Log.d("呵呵", mCurrentLength+",threadid:"+threadId+""+currentIndex);
                            Log.d("呵呵", sp.getInt(CURR_LENGTH,0)+"，"+SP_NAME+threadId);
                        }
                        return;
                    }

                    if (runningThreadCount == 0) {
                        Log.e("----", "成功");
                        sp.edit().clear().apply();
                        handler.sendEmptyMessage(SUCCESS);
                        handler.sendEmptyMessage(100);
                        mThread = null;
                    }


                } else {//如果不是206下发失败
                    sp.edit().clear().apply();
                    handler.sendEmptyMessage(FAILURE);
                }


            } catch (Exception e) {
                e.printStackTrace();
                handler.sendEmptyMessage(FAILURE);
            }


        }
    }

    private final int SUCCESS = 0x00000101;
    private final int FAILURE = 0x00000102;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (mDownListener != null) {
                if (msg.what == SUCCESS) {
                    mDownListener.onSuccess("下载成功");
                } else if (msg.what == FAILURE) {
                    mDownListener.onError("下载失败");
                } else {
                    mDownListener.onProgress(msg.what);
                }
            }
        }
    };

    //暂停   为什么这样就能暂停这个任务
    public void pause() {
        if (mThread != null) {//如果不等于null 说明线程在跑 run方法在执行
            stateDownload = DOWN_PAUSE;
            cancel();
        }
    }

    /**
     * 继续下载
     */
    protected void start() {
        if (mThread != null) {
            synchronized (DOWN_PAUSE) {
                stateDownload = DOWN_START;
                DOWN_PAUSE.notifyAll();
            }
        }
    }

    //这个activity退出要销毁吊线程
    protected void onDestroy() {
        if (mThread != null) {
            pause();
            mThread = null;
        }
    }
}
