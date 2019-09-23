
package hi.car.pojo;
import java.io.Serializable;

public class Message implements Serializable {

    private Long id;//消息编号
    private String content;//消息内容
    private String type;//发送消息者
    private String title;//消息标题
    private Integer isSchedule;//已发送(0表示没有发送,1表示已发送)
    private String scheduleTime;//增加消息时间
    private String sendTime;//发送时间

    public Message() {
    }

    public Message(Long id, String content, String type, String title, Integer isSchedule, String scheduleTime, String sendTime) {
        this.id = id;
        this.content = content;
        this.type = type;
        this.title = title;
        this.isSchedule = isSchedule;
        this.scheduleTime = scheduleTime;
        this.sendTime = sendTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getIsSchedule() {
        return isSchedule;
    }

    public void setIsSchedule(Integer isSchedule) {
        this.isSchedule = isSchedule;
    }

    public String getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(String scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", isSchedule=" + isSchedule +
                ", scheduleTime='" + scheduleTime + '\'' +
                ", sendTime='" + sendTime + '\'' +
                '}';
    }
}
