package webapp.model;

import lombok.Getter;
import lombok.Setter;
import org.noear.weed.annotation.Table;

@Getter
@Setter
public class AppxModel {
    private int agroup_id;
    private String note;
    private String app_key;
    private int app_id;
    private int ar_is_examine;
}
