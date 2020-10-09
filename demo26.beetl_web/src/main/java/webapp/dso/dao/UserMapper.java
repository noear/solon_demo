package webapp.dso.dao;

import org.beetl.sql.mapper.annotation.Sql;
import org.beetl.sql.mapper.annotation.SqlResource;
import org.beetl.sql.mapper.annotation.Template;
import webapp.model.SysUserModel;

@SqlResource("user")
public interface UserMapper {
    @Sql("select * from sys_user where id = ?")
    SysUserModel selectById(Integer id);

    @Template("select * from sys_user where id = #{id}")
    SysUserModel selectTemplateById(Integer id);

    SysUserModel userSelect();
}
