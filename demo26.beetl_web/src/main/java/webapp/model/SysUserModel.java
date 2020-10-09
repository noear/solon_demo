package webapp.model;

import lombok.Data;

import java.util.Date;

@Data
public class SysUserModel {
    private long id;
    private String name;
    private int departmentId;
    private Date createTime;
}
