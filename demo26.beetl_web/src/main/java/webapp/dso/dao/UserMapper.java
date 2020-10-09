package webapp.dso.dao;

import org.beetl.sql.mapper.annotation.SqlResource;
import webapp.model.SysUserModel;

@SqlResource("user")
public interface UserMapper {
    SysUserModel userSelect();
}
