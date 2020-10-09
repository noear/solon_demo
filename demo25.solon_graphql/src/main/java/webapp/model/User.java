package webapp.model;

import lombok.Data;

@Data
public class User {
    private int age;
    private long id;
    private String name;
    private Card card;

    public User(int age, long id, String name, Card card) {
        this.age = age;
        this.id = id;
        this.name = name;
        this.card = card;
    }

    public User(int age, long id, String name) {
        this.age = age;
        this.id = id;
        this.name = name;
    }

}
