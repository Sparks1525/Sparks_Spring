package mySpring.factoryPattern.abstractFactory;

import mySpring.factoryPattern.bean.INoodles;
import mySpring.factoryPattern.bean.LzNoodles;

public class LzlmFoodFactory extends AbstractFoodFactory {
    @Override
    public INoodles createNoodles() {
        return new LzNoodles();//卖兰州拉面
    }

    @Override
    public IDrinks createDrinks() {
        return new WaterDrinks();//卖水
    }
}