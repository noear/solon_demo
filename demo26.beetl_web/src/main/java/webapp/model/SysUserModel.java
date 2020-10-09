package webapp.model;

import lombok.Data;
import org.beetl.sql.annotation.entity.AssignID;
import org.beetl.sql.annotation.entity.Table;

import java.util.Date;

@Table(name = "sys_user")
@Data
public class SysUserModel {
    @AssignID
    private Long id;
    private String name;
    private Integer departmentId;
    private Date createTime;
}
