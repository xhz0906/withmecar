package hi.car.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class SdkInterface implements Serializable {
        private Integer id;

        private Integer typeId;

        private String name;

        private String des;

        private String url;

        private String success;

        private String error;

        private String requestType;
}
