package mySpring.bean;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Student {

    private static final Logger LOGGER = LogManager.getLogger(Student.class);

    private int id;
    private String name;
    private int age;

    public Student(){
        LOGGER.debug("This is Student constructor!");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
