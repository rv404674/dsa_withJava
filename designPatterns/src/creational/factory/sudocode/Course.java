package creational.factory.sudocode;

import java.util.ArrayList;
import java.util.List;

public abstract class Course {
    String courseName;
    String creatorName;
    COURSETYPE coursetype;

    // NOTE: This is where the magic happens
    // createCourse() will be implemented by concrecte child classes.
    public abstract void createCourse();
}

enum COURSETYPE {
    HLD,
    LLD;
}
