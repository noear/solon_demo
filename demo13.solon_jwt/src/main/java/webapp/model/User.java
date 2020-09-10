package webapp.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {
    private Integer id;
    private String openid;
    private String name;
    private String headImg;
    private String phone;
    private String sign;
    private Integer sex;
    private String city;
    private Date createTime;
}
