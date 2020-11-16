package demo.model;

import io.protostuff.Tag;
import lombok.Data;

@Data
public class App {
    /** 必填！应用ID, 在Mobile SSP（以下简称MSSP）完成注册, 并上传应用通过审核后, 平台会提供应用ID **/
    @Tag(1)
    private String  id;

    @Tag(2)
    private String channel_id;

    /** 必填！应用版本, 将影响优选策略 **/
    @Tag(3)
    private int version;

    /** 必填！应用包名, 需要跟应用提交时一一对应, 中文需要UTF-8编码 **/
    @Tag(4)
    private String  packageName;
}
