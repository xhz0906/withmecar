package hi.car.pojo;

import lombok.Data;

import java.io.Serializable;
@Data
public class Activity implements Serializable {
    private int id;
    private String title;
    private int categoryId;
    private String url;
    private int state;
    private String summary;
    private String description;
    private String link;
    private int beginTime;
    private int endTime;
    private int channelTop;
    private int homeTop;
    private int pvCount;
    private int uvCount;
    private int upCount;
    private int favCount;
    private int publishState;
    private int createUid;
    private int createTime;
    private String author;
    private String unpublishUname;
    private String unpublishTime;
    private String seoKeywords;
    private String sdkPath;
    private int likeCount;
    private int shareCount;
    private int viewCount;
    private String seoDescription;
    private String tags;
    private String coverPic;
    private String cars;
    private int sdkId;
    private String sdkTitle;
    private String dealer;
}
