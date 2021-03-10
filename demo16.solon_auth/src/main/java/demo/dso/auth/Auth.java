package demo.dso.auth;


import org.noear.solon.annotation.Note;

import java.lang.annotation.*;

/**
 * @author noear 2021/3/10 created
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Auth {
    @Note("roles")
    AuthRole[] value() default {AuthRole.ANYONE};

    String message() default "";
}
