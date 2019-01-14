package mySpring.factoryPattern.bean;

public class GankouNoodles implements INoodles {
    @Override
    public void desc() {
        System.out.println("还是家里的干扣面好吃 6块一碗");
    }
}
