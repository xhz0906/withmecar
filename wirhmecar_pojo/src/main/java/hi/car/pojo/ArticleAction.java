package hi.car.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ArticleAction implements Serializable {
//    "id
//    article_id
//            operator_uid
//    operator_username
//            create_time
//    id"	bigint
    private int id;
//    article_id	bigint
    private int articleId;
//    operator_uid	int
    private int operator;
//    operator_username	varchar(50)
    private String operatorUsername;
//    create_time	int(11)
    private int createTime;
//    content	varchar(2000)
    private String content;
//    operate_type	tinyint
    private int operateType;

}
