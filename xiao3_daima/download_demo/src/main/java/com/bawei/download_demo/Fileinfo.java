package com.bawei.download_demo;

import java.io.Serializable;

/*
 *@auther:邓先超
 *@Date: 2020/3/18
 *@Time:9:43
       文件信息
 *@Description:
 **/
public class Fileinfo implements Serializable {
    int id;
    String url;
    String fliename;
    int length;
    int finish;

    public Fileinfo(int id, String url, String fliename, int length, int finish) {
        this.id = id;
        this.url = url;
        this.fliename = fliename;
        this.length = length;
        this.finish = finish;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFliename() {
        return fliename;
    }

    public void setFliename(String fliename) {
        this.fliename = fliename;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getFinish() {
        return finish;
    }

    public void setFinish(int finish) {
        this.finish = finish;
    }
}
