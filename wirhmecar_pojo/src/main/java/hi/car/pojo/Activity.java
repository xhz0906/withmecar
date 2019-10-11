package hi.car.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Activity implements Serializable {
    //跟新上去
    private int id;
    private String title;
    private ActivityCategory activityCategory;
    private String url;
    private int state;
    private String summary;
    private String description;
    private String link;
    private Date beginTime;
    private Date endTime;
    private int channelTop;
    private int homeTop;
    private int pvCount;
    private int uvCount;
    private int upCount;
    private int favCount;
    private int publishState;
    private AdminUser adminUser;
    private Date createTime;
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
