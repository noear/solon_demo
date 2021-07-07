package webapp.controller.more;

import lombok.Data;
import org.noear.solon.validation.annotation.*;

import java.util.List;


/**
 * @author noear 2021/5/11 created
 */
@Data
public class ValidModel2 {
    @Date
    private String field1;
    @Date("yyyy-MM-dd")
    private String field2;
    @DecimalMax(10.0)
    private Double field3;
    @DecimalMin(10.0)
    private double field4;
    @Email
    private String field5;
    @Email("\\w+\\@live.cn")
    private String field6;
    @Max(10)
    private Integer field7;
    @Min(10)
    private int field8;
    @NotBlank
    private String field9;
    @NotEmpty
    private String field10;
    @NotNull
    private String field11;
    @NotNull
    private Integer field12;
    @Null
    private String field13;
    @Null
    private Double field14;
    @Pattern("\\d{3}-\\d+")
    private String field15;
    @NotZero
    private Integer field16;
    @Length(min = 3)
    private String field17;
    @Size(min = 1)
    private List<String> field18;
}
