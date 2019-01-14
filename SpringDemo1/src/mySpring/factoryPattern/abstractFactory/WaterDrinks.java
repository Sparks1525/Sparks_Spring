package mySpring.factoryPattern.abstractFactory;

public class WaterDrinks implements IDrinks {
    @Override
    public void prices() {
        System.out.println("和我一样的穷鬼都喝水，不要钱~！");
    }
}
