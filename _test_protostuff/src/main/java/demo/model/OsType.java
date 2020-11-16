package demo.model;

import io.protostuff.Tag;

public enum OsType {
    /** Android **/
    @Tag(1)
    ANDROID,

    /** iOS **/
    @Tag(2)
    IOS;
}
