package webapp.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.beetl.sql.annotation.entity.AssignID;
import org.beetl.sql.annotation.entity.Table;

@Table(name = "appx")
@Data
@Accessors(chain = true)
public class AppxModel {
    private int agroup_id;
    private String note;
    private String app_key;
    @AssignID
    private int app_id;
    private int ar_is_examine;
}
