package webapp.model;

import lombok.Data;
import org.noear.solon.annotation.Param;

import java.util.Date;

@Data
public class UserModel {
    public long id;
    public String name;
    public int sex;
    public String label;

    public transient String _type;

    @Param(format = "yyyy-MM-dd")
    public Date date = new Date();

    public long[] aaa;
}
