package hi.car.pojo;

import lombok.Data;

import java.io.Serializable;
@Data
public class Article implements Serializable {
//    id	bigint
    private int id;
//    title	varchar(500)
    private String title;
//    category_id	int
    private int category;
//    source	varchar(500)
    private String source;
//    author	varchar(500)
    private String author;
//    summary	varchar(1000)
    private String summary;
//    cover_pic	varchar(500)
    private String coverPic;
//    thumb_pic	varchar(500)
    private String thumbPic;
//    tags	varchar(1000)
    private String tags;
//    content	longtext
    private String content;
//    preview_url	varchar(500)
    private String preview;
//    qrcode_url	varchar(500)
    private String qrcodeUrl;
//    pv_count	int
    private int pvCount;
//    uv_count	int
    private int uvCount;
//    comment_count	int
    private int commentCount;
//    like_count	int
    private int likeCount;
//    fav_count	int
    private int favCount;
//    share_count	int
    private int shareCount;
//    channel_top	tinyint
    private int channelTop;
//    home_top	tinyint
    private int homeTop;
//    create_uid	int
    private int createUid;
//    create_uname	varchar(500)
    private String createUname;
//    create_time	int(11)
    private int createTime;
//    submit_uid	int
    private int submitUid;
//    submit_time	int(11)
    private String submitTime;
//    state	int
    private int state;
//    state_order	int
    private int stateOrder;
//    last_audit_uid	int
    private int lastAuditUid;
//    last_audit_username	varchar(20)
    private String lastAuditUsername;
//    last_audit_time	int(11)
    private int lastAuditTime;

//    last_reject_reason	varchar(200)
    private String lastRejectReason;
//    publish_state	tinyint
    private int publishState;
//    publish_uid	int
    private int publishUid;
//    publish_uname	varchar(200)
    private String publishUname;
//    publish_time	int(11)
    private int publishTime;
//    unpublish_uid	int
    private int unpublishUid;
//    unpublish_uname	varchar(200)
    private String unpublishUname;
//    unpublish_time	int(11)
    private int unpublishTime;
//    unpublish_reason	varchar(500)
    private String unpublishReason;
//    last_update_uid	int
    private int lastUpdateUid;
//    last_update_uname	varchar(20)
    private String lastUpdateUname;
//    last_update_time	int(11)
    private String lashUpdateTime;
//    seo_keywords	varchar(200)
    private String seoKeywords;
//    seo_description	varchar(200)
    private String seoDescription;
//    allow_up	tinyint
    private int allow;
//    allow_fav	tinyint


}
