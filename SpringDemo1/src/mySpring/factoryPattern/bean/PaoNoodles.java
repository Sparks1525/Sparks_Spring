package mySpring.factoryPattern.bean;

public class PaoNoodles implements INoodles {
    @Override
    public void desc() {
        System.out.println("泡面好吃 可不要贪杯");
    }
}
