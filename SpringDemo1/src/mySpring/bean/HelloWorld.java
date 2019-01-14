package mySpring.bean;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HelloWorld {

    private static final Logger LOGGER = LogManager.getLogger(HelloWorld.class);

    private String name;

    public HelloWorld(){
        LOGGER.debug("This is HelloWorld constructor!");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        //LOGGER.debug("This is HelloWorld setName!");
        this.name = name;
    }
}
