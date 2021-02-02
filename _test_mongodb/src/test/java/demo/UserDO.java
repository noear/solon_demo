package demo;

import java.io.Serializable;

/**
 * @author noear 2021/2/1 created
 */

public class UserDO implements Serializable {
    private long id;
    private String name;
    private String nickname;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
