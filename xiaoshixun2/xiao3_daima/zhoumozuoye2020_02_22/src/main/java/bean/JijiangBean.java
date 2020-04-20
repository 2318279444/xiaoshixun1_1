package bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/*
 *@auther:邓先超
 *@Date: 2020/2/22
 *@Time:15:46
 *@Description:
 **/
public class JijiangBean {

    /**
     * count : 20
     * start : 0
     * total : 81
     * subjects : [{"rating":{"max":10,"average":0,"details":{"1":0,"2":0,"3":0,"4":0,"5":0},"stars":"00","min":0},"genres":["动画","奇幻","冒险"],"title":"冰雪女王4：魔镜世界","casts":[],"durations":["86分钟"],"collect_count":131,"mainland_pubdate":"2019-08-02","has_video":false,"original_title":"The Snow Queen: Mirrorlands","subtype":"movie","directors":[{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1563162534.14.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1563162534.14.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1563162534.14.webp"},"name_en":"Robert Lence","name":"罗伯特·伦塞","alt":"https://movie.douban.com/celebrity/1332331/","id":"1332331"},{"avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1563162946.18.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1563162946.18.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1563162946.18.webp"},"name_en":"Aleksey Tsitsilin","name":"阿列克谢·特斯蒂斯林","alt":"https://movie.douban.com/celebrity/1362482/","id":"1362482"},{"avatars":null,"name_en":"","name":"刘凌峰","alt":null,"id":null}],"pubdates":["2018-12-20(俄罗斯)","2019-08-02(中国大陆)"],"year":"2018","images":{"small":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2562090757.webp","large":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2562090757.webp","medium":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2562090757.webp"},"alt":"https://movie.douban.com/subject/30206294/","id":"30206294"},{"rating":{"max":10,"average":0,"details":{"1":0,"2":0,"3":0,"4":0,"5":0},"stars":"00","min":0},"genres":["喜剧"],"title":"鼠胆英雄","casts":[{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p40756.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p40756.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p40756.webp"},"name_en":"Yunpeng Yue","name":"岳云鹏","alt":"https://movie.douban.com/celebrity/1317663/","id":"1317663"},{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1367210981.95.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1367210981.95.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1367210981.95.webp"},"name_en":"Liya Tong","name":"佟丽娅","alt":"https://movie.douban.com/celebrity/1275756/","id":"1275756"},{"avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1515482404.17.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1515482404.17.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1515482404.17.webp"},"name_en":"Yu Tian","name":"田雨","alt":"https://movie.douban.com/celebrity/1316331/","id":"1316331"}],"durations":["106分钟"],"collect_count":685,"mainland_pubdate":"2019-08-02","has_video":false,"original_title":"鼠胆英雄","subtype":"movie","directors":[{"avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1355745195.9.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1355745195.9.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1355745195.9.webp"},"name_en":"Huan Shu","name":"束焕","alt":"https://movie.douban.com/celebrity/1325104/","id":"1325104"},{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1385916185.21.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1385916185.21.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1385916185.21.webp"},"name_en":"Dan Shao","name":"邵丹","alt":"https://movie.douban.com/celebrity/1305573/","id":"1305573"}],"pubdates":["2019-06-16(上海电影节)","2019-08-02(中国大陆)"],"year":"2019","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2564174626.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2564174626.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2564174626.webp"},"alt":"https://movie.douban.com/subject/27073057/","id":"27073057"},{"rating":{"max":10,"average":0,"details":{"1":0,"2":0,"3":0,"4":0,"5":0},"stars":"00","min":0},"genres":["剧情","爱情"],"title":"最美的地方遇见你","casts":[{"avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/pgjdf5ih6XAAcel_avatar_uploaded1440332518.38.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/pgjdf5ih6XAAcel_avatar_uploaded1440332518.38.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/pgjdf5ih6XAAcel_avatar_uploaded1440332518.38.webp"},"name_en":"Dong Wang","name":"王东","alt":"https://movie.douban.com/celebrity/1351439/","id":"1351439"},{"avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1561397987.09.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1561397987.09.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1561397987.09.webp"},"name_en":"Mi Gong","name":"贡米","alt":"https://movie.douban.com/celebrity/1275005/","id":"1275005"},{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p21871.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p21871.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p21871.webp"},"name_en":"Han Xiao","name":"肖涵","alt":"https://movie.douban.com/celebrity/1314126/","id":"1314126"}],"durations":["98分钟"],"collect_count":15,"mainland_pubdate":"2019-08-02","has_video":false,"original_title":"最美的地方遇见你","subtype":"movie","directors":[{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p51732.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p51732.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p51732.webp"},"name_en":"Laizhi Zheng","name":"郑来志","alt":"https://movie.douban.com/celebrity/1321907/","id":"1321907"}],"pubdates":["2019-08-02(中国大陆)"],"year":"2019","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2564179635.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2564179635.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2564179635.webp"},"alt":"https://movie.douban.com/subject/27192596/","id":"27192596"},{"rating":{"max":10,"average":0,"details":{"1":0,"2":0,"3":0,"4":0,"5":0},"stars":"00","min":0},"genres":["儿童","喜剧","运动"],"title":"梦想之战：踢球吧阿妹","casts":[{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1530783851.24.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1530783851.24.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1530783851.24.webp"},"name_en":"Lin Zhang","name":"张琳","alt":"https://movie.douban.com/celebrity/1396715/","id":"1396715"},{"avatars":{"small":"https://img1.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"https://img3.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"https://img1.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name_en":"Lianzheng Li","name":"李连正","alt":"https://movie.douban.com/celebrity/1374942/","id":"1374942"},{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1480920311.96.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1480920311.96.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1480920311.96.webp"},"name_en":"Lin Chen","name":"陈淋","alt":"https://movie.douban.com/celebrity/1365415/","id":"1365415"}],"durations":["90分钟"],"collect_count":279,"mainland_pubdate":"2019-08-02","has_video":false,"original_title":"梦想之战：踢球吧阿妹","subtype":"movie","directors":[{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/pyBwDCcQFS_kcel_avatar_uploaded1563332536.81.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/pyBwDCcQFS_kcel_avatar_uploaded1563332536.81.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/pyBwDCcQFS_kcel_avatar_uploaded1563332536.81.webp"},"name_en":"Wen Zhang","name":"章文","alt":"https://movie.douban.com/celebrity/1420258/","id":"1420258"}],"pubdates":["2019-08-02(中国大陆)"],"year":"2019","images":{"small":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2562184389.webp","large":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2562184389.webp","medium":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2562184389.webp"},"alt":"https://movie.douban.com/subject/34464348/","id":"34464348"},{"rating":{"max":10,"average":0,"details":{"1":0,"2":0,"3":0,"4":0,"5":0},"stars":"00","min":0},"genres":["剧情","爱情"],"title":"歌唱动荡的青春","casts":[{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1558575889.72.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1558575889.72.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1558575889.72.webp"},"name_en":"","name":"谭小雅","alt":"https://movie.douban.com/celebrity/1416498/","id":"1416498"},{"avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1557996013.77.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1557996013.77.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1557996013.77.webp"},"name_en":"","name":"张晨","alt":"https://movie.douban.com/celebrity/1416502/","id":"1416502"},{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1557996038.51.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1557996038.51.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1557996038.51.webp"},"name_en":"","name":"张漪妮","alt":"https://movie.douban.com/celebrity/1416499/","id":"1416499"}],"durations":["94分钟"],"collect_count":20,"mainland_pubdate":"2019-08-02","has_video":false,"original_title":"歌唱动荡的青春","subtype":"movie","directors":[{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1558073371.54.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1558073371.54.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1558073371.54.webp"},"name_en":"Jianhua Yang","name":"杨涧华","alt":"https://movie.douban.com/celebrity/1413368/","id":"1413368"}],"pubdates":["2019-08-02(中国大陆)"],"year":"2019","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2556687994.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2556687994.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2556687994.webp"},"alt":"https://movie.douban.com/subject/33428718/","id":"33428718"},{"rating":{"max":10,"average":0,"details":{"1":0,"2":0,"3":0,"4":0,"5":0},"stars":"00","min":0},"genres":["儿童","动画","奇幻"],"title":"赛尔号大电影7：疯狂机器城","casts":[],"durations":[],"collect_count":63,"mainland_pubdate":"2019-08-02","has_video":false,"original_title":"赛尔号大电影7：疯狂机器城","subtype":"movie","directors":[{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1500536247.43.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1500536247.43.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1500536247.43.webp"},"name_en":"Zhangjun Wang","name":"王章俊","alt":"https://movie.douban.com/celebrity/1330788/","id":"1330788"}],"pubdates":["2019-08-02(中国大陆)"],"year":"2019","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2562826611.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2562826611.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2562826611.webp"},"alt":"https://movie.douban.com/subject/30449240/","id":"30449240"},{"rating":{"max":10,"average":0,"details":{"1":0,"2":0,"3":0,"4":0,"5":0},"stars":"00","min":0},"genres":["喜剧","奇幻"],"title":"灶神来了","casts":[{"avatars":null,"name_en":"","name":"陈曦","alt":null,"id":null},{"avatars":null,"name_en":"","name":"刘帅良","alt":null,"id":null},{"avatars":null,"name_en":"","name":"黄一飞","alt":null,"id":null}],"durations":["95分钟"],"collect_count":6,"mainland_pubdate":"2019-08-02","has_video":false,"original_title":"灶神来了","subtype":"movie","directors":[{"avatars":null,"name_en":"","name":"张帆","alt":null,"id":null}],"pubdates":["2019-08-02(中国大陆)"],"year":"2019","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2562170670.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2562170670.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2562170670.webp"},"alt":"https://movie.douban.com/subject/34464058/","id":"34464058"},{"rating":{"max":10,"average":7,"details":{"1":0,"2":7,"3":26,"4":18,"5":10},"stars":"35","min":0},"genres":["剧情","爱情"],"title":"红花绿叶","casts":[{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1557311373.16.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1557311373.16.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1557311373.16.webp"},"name_en":"Siqi Ma","name":"马思琪","alt":"https://movie.douban.com/celebrity/1414159/","id":"1414159"},{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1557311355.65.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1557311355.65.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1557311355.65.webp"},"name_en":"Kewang Luo","name":"罗克旺","alt":"https://movie.douban.com/celebrity/1414155/","id":"1414155"},{"avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1557311413.87.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1557311413.87.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1557311413.87.webp"},"name_en":"Ling Zhang","name":"张玲","alt":"https://movie.douban.com/celebrity/1414156/","id":"1414156"}],"durations":["96分钟"],"collect_count":405,"mainland_pubdate":"2019-08-05","has_video":false,"original_title":"红花绿叶","subtype":"movie","directors":[{"avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1557311306.88.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1557311306.88.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1557311306.88.webp"},"name_en":"Miaomiao Liu","name":"刘苗苗","alt":"https://movie.douban.com/celebrity/1291966/","id":"1291966"},{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1557311335.26.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1557311335.26.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1557311335.26.webp"},"name_en":"Weijie Hu","name":"胡维捷","alt":"https://movie.douban.com/celebrity/1414153/","id":"1414153"}],"pubdates":["2018-10-17(平遥国际电影展)","2019-08-05(中国大陆)"],"year":"2018","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2563535973.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2563535973.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2563535973.webp"},"alt":"https://movie.douban.com/subject/30174535/","id":"30174535"},{"rating":{"max":10,"average":0,"details":{"1":0,"2":0,"3":0,"4":0,"5":0},"stars":"00","min":0},"genres":["剧情","动作","犯罪"],"title":"使徒行者2：谍影行动","casts":[{"avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1382184082.17.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1382184082.17.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1382184082.17.webp"},"name_en":"Nick Cheung","name":"张家辉","alt":"https://movie.douban.com/celebrity/1037273/","id":"1037273"},{"avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1421047436.79.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1421047436.79.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1421047436.79.webp"},"name_en":"Louis Koo","name":"古天乐","alt":"https://movie.douban.com/celebrity/1027577/","id":"1027577"},{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1515744596.63.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1515744596.63.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1515744596.63.webp"},"name_en":"Francis Ng","name":"吴镇宇","alt":"https://movie.douban.com/celebrity/1037098/","id":"1037098"}],"durations":[],"collect_count":206,"mainland_pubdate":"2019-08-07","has_video":false,"original_title":"使徒行者2：谍影行动","subtype":"movie","directors":[{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1436277330.84.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1436277330.84.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1436277330.84.webp"},"name_en":"Jazz Boon","name":"文伟鸿","alt":"https://movie.douban.com/celebrity/1320763/","id":"1320763"}],"pubdates":["2019-08-07(中国大陆)"],"year":"2019","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2563751491.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2563751491.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2563751491.webp"},"alt":"https://movie.douban.com/subject/30423193/","id":"30423193"},{"rating":{"max":10,"average":7.1,"details":{"1":4,"2":39,"3":211,"4":191,"5":73},"stars":"35","min":0},"genres":["爱情","动画","奇幻"],"title":"若能与你共乘海浪之上","casts":[{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1526185905.42.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1526185905.42.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1526185905.42.webp"},"name_en":"Katayose Ryota","name":"片寄凉太","alt":"https://movie.douban.com/celebrity/1367999/","id":"1367999"},{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1459225712.32.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1459225712.32.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1459225712.32.webp"},"name_en":"Rina Kawaei","name":"川荣李奈","alt":"https://movie.douban.com/celebrity/1322083/","id":"1322083"},{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1532510544.41.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1532510544.41.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1532510544.41.webp"},"name_en":"Honoka Matsumoto","name":"松本穗香","alt":"https://movie.douban.com/celebrity/1350187/","id":"1350187"}],"durations":["96分钟"],"collect_count":1430,"mainland_pubdate":"2019-08-07","has_video":false,"original_title":"きみと、波にのれたら","subtype":"movie","directors":[{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p3601.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p3601.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p3601.webp"},"name_en":"Masaaki Yuasa","name":"汤浅政明","alt":"https://movie.douban.com/celebrity/1274339/","id":"1274339"}],"pubdates":["2019-06-21(日本)","2019-08-07(中国大陆)"],"year":"2019","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2563770371.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2563770371.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2563770371.webp"},"alt":"https://movie.douban.com/subject/30345226/","id":"30345226"},{"rating":{"max":10,"average":5,"details":{"1":14,"2":48,"3":54,"4":10,"5":2},"stars":"25","min":0},"genres":["爱情"],"title":"某日某月","casts":[{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1499422989.65.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1499422989.65.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1499422989.65.webp"},"name_en":"Kathy Tong","name":"汤怡","alt":"https://movie.douban.com/celebrity/1314475/","id":"1314475"},{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1484796354.2.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1484796354.2.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1484796354.2.webp"},"name_en":"Daichi Harashima","name":"原岛大地","alt":"https://movie.douban.com/celebrity/1307245/","id":"1307245"},{"avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p36578.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p36578.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p36578.webp"},"name_en":"Aimee Chan","name":"陈茵媺","alt":"https://movie.douban.com/celebrity/1275701/","id":"1275701"}],"durations":["96分钟"],"collect_count":495,"mainland_pubdate":"2019-08-07","has_video":false,"original_title":"某日某月","subtype":"movie","directors":[{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1455555264.0.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1455555264.0.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1455555264.0.webp"},"name_en":"Wai-Hang Lau","name":"刘伟恒","alt":"https://movie.douban.com/celebrity/1354380/","id":"1354380"}],"pubdates":["2018-04-16(北京电影节)","2018-05-31(香港)","2019-08-07(中国大陆)"],"year":"2018","images":{"small":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2562901379.webp","large":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2562901379.webp","medium":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2562901379.webp"},"alt":"https://movie.douban.com/subject/27107718/","id":"27107718"},{"rating":{"max":10,"average":0,"details":{"1":0,"2":0,"3":0,"4":0,"5":0},"stars":"00","min":0},"genres":["剧情","儿童","冒险"],"title":"丛林历险记","casts":[{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p4311.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p4311.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p4311.webp"},"name_en":"Fenqiang Ouyang","name":"欧阳奋强","alt":"https://movie.douban.com/celebrity/1252926/","id":"1252926"},{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1495868997.44.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1495868997.44.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1495868997.44.webp"},"name_en":"Wenze Gu","name":"谷文泽","alt":"https://movie.douban.com/celebrity/1374611/","id":"1374611"},{"avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1497093951.19.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1497093951.19.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1497093951.19.webp"},"name_en":"YiFan Zhon","name":"钟熠璠","alt":"https://movie.douban.com/celebrity/1372548/","id":"1372548"}],"durations":["93分钟"],"collect_count":31,"mainland_pubdate":"2019-08-08","has_video":false,"original_title":"丛林历险记","subtype":"movie","directors":[{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1388398122.81.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1388398122.81.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1388398122.81.webp"},"name_en":"Ruoyi Zhang","name":"张若以","alt":"https://movie.douban.com/celebrity/1337085/","id":"1337085"}],"pubdates":["2019-08-08(中国大陆)"],"year":"2019","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2503190785.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2503190785.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2503190785.webp"},"alt":"https://movie.douban.com/subject/27180880/","id":"27180880"},{"rating":{"max":10,"average":0,"details":{"1":0,"2":0,"3":0,"4":0,"5":0},"stars":"00","min":0},"genres":["历史","战争"],"title":"红星照耀中国","casts":[{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p58401.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p58401.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p58401.webp"},"name_en":"Pengkai Wang","name":"王鹏凯","alt":"https://movie.douban.com/celebrity/1323915/","id":"1323915"},{"avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1365831724.28.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1365831724.28.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1365831724.28.webp"},"name_en":"Xuejian Li","name":"李雪健","alt":"https://movie.douban.com/celebrity/1274233/","id":"1274233"},{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1386694608.16.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1386694608.16.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1386694608.16.webp"},"name_en":"Wenli Jiang","name":"蒋雯丽","alt":"https://movie.douban.com/celebrity/1020487/","id":"1020487"}],"durations":["109分钟"],"collect_count":20,"mainland_pubdate":"2019-08-08","has_video":false,"original_title":"红星照耀中国","subtype":"movie","directors":[{"avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p42807.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p42807.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p42807.webp"},"name_en":"Jixing Wang","name":"王冀邢","alt":"https://movie.douban.com/celebrity/1315705/","id":"1315705"}],"pubdates":["2019-08-08(中国大陆)"],"year":"2019","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2563448281.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2563448281.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2563448281.webp"},"alt":"https://movie.douban.com/subject/30468769/","id":"30468769"},{"rating":{"max":10,"average":0,"details":{"1":0,"2":0,"3":0,"4":0,"5":0},"stars":"00","min":0},"genres":["爱情","战争","科幻"],"title":"上海堡垒","casts":[{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1451933721.86.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1451933721.86.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1451933721.86.webp"},"name_en":"Han Lu","name":"鹿晗","alt":"https://movie.douban.com/celebrity/1337001/","id":"1337001"},{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17512.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17512.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17512.webp"},"name_en":"Qi Shu","name":"舒淇","alt":"https://movie.douban.com/celebrity/1138320/","id":"1138320"},{"avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p37599.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p37599.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p37599.webp"},"name_en":"Liang Shi","name":"石凉","alt":"https://movie.douban.com/celebrity/1313009/","id":"1313009"}],"durations":["107分钟"],"collect_count":1766,"mainland_pubdate":"2019-08-09","has_video":false,"original_title":"上海堡垒","subtype":"movie","directors":[{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p36106.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p36106.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p36106.webp"},"name_en":"Hua-Tao Teng","name":"滕华涛","alt":"https://movie.douban.com/celebrity/1314569/","id":"1314569"}],"pubdates":["2019-08-09(中国大陆)"],"year":"2019","images":{"small":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2564169307.webp","large":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2564169307.webp","medium":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2564169307.webp"},"alt":"https://movie.douban.com/subject/26581837/","id":"26581837"},{"rating":{"max":10,"average":0,"details":{"1":0,"2":0,"3":0,"4":0,"5":0},"stars":"00","min":0},"genres":["悬疑","惊悚"],"title":"童童的风铃密室","casts":[{"avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1019.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1019.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1019.webp"},"name_en":"Monica Chan","name":"陈法蓉","alt":"https://movie.douban.com/celebrity/1042518/","id":"1042518"},{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1696.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1696.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1696.webp"},"name_en":"Pei-pei Cheng","name":"郑佩佩","alt":"https://movie.douban.com/celebrity/1037023/","id":"1037023"},{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p50590.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p50590.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p50590.webp"},"name_en":"Zehao An","name":"安泽豪","alt":"https://movie.douban.com/celebrity/1318040/","id":"1318040"}],"durations":["85分钟"],"collect_count":178,"mainland_pubdate":"2019-08-09","has_video":false,"original_title":"童童的风铃密室","subtype":"movie","directors":[{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1402560947.06.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1402560947.06.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1402560947.06.webp"},"name_en":"Ning Liu","name":"刘宁","alt":"https://movie.douban.com/celebrity/1340072/","id":"1340072"}],"pubdates":["2019-08-09(中国大陆)"],"year":"2019","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2562929401.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2562929401.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2562929401.webp"},"alt":"https://movie.douban.com/subject/34605265/","id":"34605265"},{"rating":{"max":10,"average":5,"details":{"1":9,"2":27,"3":24,"4":4,"5":4},"stars":"25","min":0},"genres":["喜剧","动画","奇幻"],"title":"丑娃娃","casts":[{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p36683.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p36683.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p36683.webp"},"name_en":"Emma Roberts","name":"艾玛·罗伯茨","alt":"https://movie.douban.com/celebrity/1035675/","id":"1035675"},{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1487018074.04.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1487018074.04.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1487018074.04.webp"},"name_en":"Janelle Monáe","name":"加奈儿·梦奈","alt":"https://movie.douban.com/celebrity/1363386/","id":"1363386"},{"avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1454619636.87.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1454619636.87.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1454619636.87.webp"},"name_en":"Nick Jonas","name":"尼克·乔纳斯","alt":"https://movie.douban.com/celebrity/1049552/","id":"1049552"}],"durations":["87分钟"],"collect_count":277,"mainland_pubdate":"2019-08-09","has_video":false,"original_title":"UglyDolls","subtype":"movie","directors":[{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1359185145.13.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1359185145.13.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1359185145.13.webp"},"name_en":"Kelly Asbury","name":"凯利·阿斯博瑞","alt":"https://movie.douban.com/celebrity/1014327/","id":"1014327"}],"pubdates":["2019-05-03(美国)","2019-08-09(中国大陆)"],"year":"2019","images":{"small":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2559224598.webp","large":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2559224598.webp","medium":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2559224598.webp"},"alt":"https://movie.douban.com/subject/23774847/","id":"23774847"},{"rating":{"max":10,"average":0,"details":{"1":0,"2":0,"3":0,"4":0,"5":0},"stars":"00","min":0},"genres":["悬疑","惊悚","恐怖"],"title":"凌晨两点半2","casts":[{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1564275288.22.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1564275288.22.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1564275288.22.webp"},"name_en":"Jianxiong Peng","name":"彭剑雄","alt":"https://movie.douban.com/celebrity/1402475/","id":"1402475"},{"avatars":{"small":"https://img1.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"https://img3.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"https://img1.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name_en":"Luwen Zhang","name":"张露文","alt":"https://movie.douban.com/celebrity/1406889/","id":"1406889"},{"avatars":{"small":"https://img1.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"https://img3.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"https://img1.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name_en":"Zun Wang","name":"王尊","alt":"https://movie.douban.com/celebrity/1406890/","id":"1406890"}],"durations":["90分钟"],"collect_count":76,"mainland_pubdate":"2019-08-09","has_video":false,"original_title":"凌晨两点半2","subtype":"movie","directors":[{"avatars":{"small":"https://img1.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"https://img3.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"https://img1.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name_en":"","name":"王赛","alt":"https://movie.douban.com/celebrity/1406888/","id":"1406888"}],"pubdates":["2019-08-09(中国大陆)"],"year":"2019","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2542978731.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2542978731.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2542978731.webp"},"alt":"https://movie.douban.com/subject/30338444/","id":"30338444"},{"rating":{"max":10,"average":0,"details":{"1":0,"2":0,"3":0,"4":0,"5":0},"stars":"00","min":0},"genres":["剧情","战争"],"title":"极度危机","casts":[{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1389772487.11.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1389772487.11.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1389772487.11.webp"},"name_en":"Xiumeng Li","name":"李修蒙","alt":"https://movie.douban.com/celebrity/1337023/","id":"1337023"},{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1455444530.31.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1455444530.31.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1455444530.31.webp"},"name_en":"Wanting Zhang","name":"张宛庭","alt":"https://movie.douban.com/celebrity/1354519/","id":"1354519"},{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1481632829.32.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1481632829.32.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1481632829.32.webp"},"name_en":"Kun Bao","name":"鲍鲲","alt":"https://movie.douban.com/celebrity/1343971/","id":"1343971"}],"durations":["108分钟"],"collect_count":9,"mainland_pubdate":"2019-08-09","has_video":false,"original_title":"极度危机","subtype":"movie","directors":[{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1462714970.01.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1462714970.01.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1462714970.01.webp"},"name_en":"Qiansen Ouyang","name":"欧阳黔森","alt":"https://movie.douban.com/celebrity/1351795/","id":"1351795"},{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p51464.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p51464.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p51464.webp"},"name_en":"Junkai Zhao","name":"赵浚凯","alt":"https://movie.douban.com/celebrity/1318213/","id":"1318213"},{"avatars":{"small":"https://img1.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"https://img3.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"https://img1.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name_en":"","name":"张超英","alt":"https://movie.douban.com/celebrity/1420237/","id":"1420237"}],"pubdates":["2019-08-09(中国大陆)"],"year":"2019","images":{"small":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2560754247.webp","large":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2560754247.webp","medium":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2560754247.webp"},"alt":"https://movie.douban.com/subject/33476557/","id":"33476557"},{"rating":{"max":10,"average":0,"details":{"1":0,"2":0,"3":0,"4":0,"5":0},"stars":"00","min":0},"genres":["喜剧","动画","奇幻"],"title":"萤火奇兵2：小虫不好惹","casts":[{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1549624104.01.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1549624104.01.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1549624104.01.webp"},"name_en":"Yeqiao Yan","name":"闫夜桥","alt":"https://movie.douban.com/celebrity/1410444/","id":"1410444"},{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1473681522.86.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1473681522.86.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1473681522.86.webp"},"name_en":"Sheng Guo","name":"郭盛","alt":"https://movie.douban.com/celebrity/1340805/","id":"1340805"},{"avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1469694029.68.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1469694029.68.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1469694029.68.webp"},"name_en":"Weifeng Deng","name":"邓伟锋","alt":"https://movie.douban.com/celebrity/1356518/","id":"1356518"}],"durations":["82分钟"],"collect_count":7,"mainland_pubdate":"2019-08-09","has_video":false,"original_title":"萤火奇兵2：小虫不好惹","subtype":"movie","directors":[{"avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1469694029.68.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1469694029.68.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1469694029.68.webp"},"name_en":"Weifeng Deng","name":"邓伟锋","alt":"https://movie.douban.com/celebrity/1356518/","id":"1356518"}],"pubdates":["2019-08-09(中国大陆)"],"year":"2019","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2548555314.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2548555314.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2548555314.webp"},"alt":"https://movie.douban.com/subject/30463531/","id":"30463531"},{"rating":{"max":10,"average":0,"details":{"1":0,"2":0,"3":0,"4":0,"5":0},"stars":"00","min":0},"genres":["剧情"],"title":"寻找兰小草","casts":[{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1351858392.72.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1351858392.72.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1351858392.72.webp"},"name_en":"Weizhi Wang ","name":"王韦智","alt":"https://movie.douban.com/celebrity/1323818/","id":"1323818"},{"avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1502434946.88.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1502434946.88.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1502434946.88.webp"},"name_en":"Xi Wen","name":"文熙","alt":"https://movie.douban.com/celebrity/1369613/","id":"1369613"},{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1515321986.5.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1515321986.5.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1515321986.5.webp"},"name_en":"Jiawei Li","name":"李佳蔚","alt":"https://movie.douban.com/celebrity/1335538/","id":"1335538"}],"durations":["90分钟"],"collect_count":4,"mainland_pubdate":"2019-08-09","has_video":false,"original_title":"寻找兰小草","subtype":"movie","directors":[{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1562040259.3.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1562040259.3.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1562040259.3.webp"},"name_en":"Xiaojun Qiu","name":"邱晓军","alt":"https://movie.douban.com/celebrity/1360605/","id":"1360605"}],"pubdates":["2019-08-09(中国大陆)"],"year":"2019","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2557952832.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2557952832.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2557952832.webp"},"alt":"https://movie.douban.com/subject/33457451/","id":"33457451"}]
     * title : 即将上映的电影
     */

    private int count;
    private int start;
    private int total;
    private String title;
    private List<SubjectsBean> subjects;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<SubjectsBean> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectsBean> subjects) {
        this.subjects = subjects;
    }

    public static class SubjectsBean {
        /**
         * rating : {"max":10,"average":0,"details":{"1":0,"2":0,"3":0,"4":0,"5":0},"stars":"00","min":0}
         * genres : ["动画","奇幻","冒险"]
         * title : 冰雪女王4：魔镜世界
         * casts : []
         * durations : ["86分钟"]
         * collect_count : 131
         * mainland_pubdate : 2019-08-02
         * has_video : false
         * original_title : The Snow Queen: Mirrorlands
         * subtype : movie
         * directors : [{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1563162534.14.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1563162534.14.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1563162534.14.webp"},"name_en":"Robert Lence","name":"罗伯特·伦塞","alt":"https://movie.douban.com/celebrity/1332331/","id":"1332331"},{"avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1563162946.18.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1563162946.18.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1563162946.18.webp"},"name_en":"Aleksey Tsitsilin","name":"阿列克谢·特斯蒂斯林","alt":"https://movie.douban.com/celebrity/1362482/","id":"1362482"},{"avatars":null,"name_en":"","name":"刘凌峰","alt":null,"id":null}]
         * pubdates : ["2018-12-20(俄罗斯)","2019-08-02(中国大陆)"]
         * year : 2018
         * images : {"small":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2562090757.webp","large":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2562090757.webp","medium":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2562090757.webp"}
         * alt : https://movie.douban.com/subject/30206294/
         * id : 30206294
         */

        private RatingBean rating;
        private String title;
        private int collect_count;
        private String mainland_pubdate;
        private boolean has_video;
        private String original_title;
        private String subtype;
        private String year;
        private ImagesBean images;
        private String alt;
        private String id;
        private List<String> genres;
        private List<?> casts;
        private List<String> durations;
        private List<DirectorsBean> directors;
        private List<String> pubdates;

        public RatingBean getRating() {
            return rating;
        }

        public void setRating(RatingBean rating) {
            this.rating = rating;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getCollect_count() {
            return collect_count;
        }

        public void setCollect_count(int collect_count) {
            this.collect_count = collect_count;
        }

        public String getMainland_pubdate() {
            return mainland_pubdate;
        }

        public void setMainland_pubdate(String mainland_pubdate) {
            this.mainland_pubdate = mainland_pubdate;
        }

        public boolean isHas_video() {
            return has_video;
        }

        public void setHas_video(boolean has_video) {
            this.has_video = has_video;
        }

        public String getOriginal_title() {
            return original_title;
        }

        public void setOriginal_title(String original_title) {
            this.original_title = original_title;
        }

        public String getSubtype() {
            return subtype;
        }

        public void setSubtype(String subtype) {
            this.subtype = subtype;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public ImagesBean getImages() {
            return images;
        }

        public void setImages(ImagesBean images) {
            this.images = images;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<String> getGenres() {
            return genres;
        }

        public void setGenres(List<String> genres) {
            this.genres = genres;
        }

        public List<?> getCasts() {
            return casts;
        }

        public void setCasts(List<?> casts) {
            this.casts = casts;
        }

        public List<String> getDurations() {
            return durations;
        }

        public void setDurations(List<String> durations) {
            this.durations = durations;
        }

        public List<DirectorsBean> getDirectors() {
            return directors;
        }

        public void setDirectors(List<DirectorsBean> directors) {
            this.directors = directors;
        }

        public List<String> getPubdates() {
            return pubdates;
        }

        public void setPubdates(List<String> pubdates) {
            this.pubdates = pubdates;
        }

        public static class RatingBean {
            /**
             * max : 10
             * average : 0
             * details : {"1":0,"2":0,"3":0,"4":0,"5":0}
             * stars : 00
             * min : 0
             */

            private int max;
            private int average;
            private DetailsBean details;
            private String stars;
            private int min;

            public int getMax() {
                return max;
            }

            public void setMax(int max) {
                this.max = max;
            }

            public int getAverage() {
                return average;
            }

            public void setAverage(int average) {
                this.average = average;
            }

            public DetailsBean getDetails() {
                return details;
            }

            public void setDetails(DetailsBean details) {
                this.details = details;
            }

            public String getStars() {
                return stars;
            }

            public void setStars(String stars) {
                this.stars = stars;
            }

            public int getMin() {
                return min;
            }

            public void setMin(int min) {
                this.min = min;
            }

            public static class DetailsBean {
                /**
                 * 1 : 0
                 * 2 : 0
                 * 3 : 0
                 * 4 : 0
                 * 5 : 0
                 */

                @SerializedName("1")
                private int _$1;
                @SerializedName("2")
                private int _$2;
                @SerializedName("3")
                private int _$3;
                @SerializedName("4")
                private int _$4;
                @SerializedName("5")
                private int _$5;

                public int get_$1() {
                    return _$1;
                }

                public void set_$1(int _$1) {
                    this._$1 = _$1;
                }

                public int get_$2() {
                    return _$2;
                }

                public void set_$2(int _$2) {
                    this._$2 = _$2;
                }

                public int get_$3() {
                    return _$3;
                }

                public void set_$3(int _$3) {
                    this._$3 = _$3;
                }

                public int get_$4() {
                    return _$4;
                }

                public void set_$4(int _$4) {
                    this._$4 = _$4;
                }

                public int get_$5() {
                    return _$5;
                }

                public void set_$5(int _$5) {
                    this._$5 = _$5;
                }
            }
        }

        public static class ImagesBean {
            /**
             * small : https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2562090757.webp
             * large : https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2562090757.webp
             * medium : https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2562090757.webp
             */

            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }

        public static class DirectorsBean {
            /**
             * avatars : {"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1563162534.14.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1563162534.14.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1563162534.14.webp"}
             * name_en : Robert Lence
             * name : 罗伯特·伦塞
             * alt : https://movie.douban.com/celebrity/1332331/
             * id : 1332331
             */

            private AvatarsBean avatars;
            private String name_en;
            private String name;
            private String alt;
            private String id;

            public AvatarsBean getAvatars() {
                return avatars;
            }

            public void setAvatars(AvatarsBean avatars) {
                this.avatars = avatars;
            }

            public String getName_en() {
                return name_en;
            }

            public void setName_en(String name_en) {
                this.name_en = name_en;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public static class AvatarsBean {
                /**
                 * small : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1563162534.14.webp
                 * large : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1563162534.14.webp
                 * medium : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1563162534.14.webp
                 */

                private String small;
                private String large;
                private String medium;

                public String getSmall() {
                    return small;
                }

                public void setSmall(String small) {
                    this.small = small;
                }

                public String getLarge() {
                    return large;
                }

                public void setLarge(String large) {
                    this.large = large;
                }

                public String getMedium() {
                    return medium;
                }

                public void setMedium(String medium) {
                    this.medium = medium;
                }
            }
        }
    }
}
