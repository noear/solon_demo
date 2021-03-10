package demo.dso.auth;

/**
 * @author noear 2021/3/10 created
 */
public enum AuthRole {

    /**
     * 系统
     */
    SYSTEM(100),
    /**
     * 单位管理员
     */
    ORG_ADMIN(50),
    /**
     * 单位用户
     */
    ORG_USER(10),
    /**
     * 默认
     */
    ANYONE(0),
    ;

    public final int weight;

    AuthRole(int weight) {
        this.weight = weight;
    }
}
