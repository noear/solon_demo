package webapp.model;

import lombok.Data;
import lombok.Getter;

@Data
public class UserModel {
    private long id;
    private String name;
    private int sex;
    private String label;
}
