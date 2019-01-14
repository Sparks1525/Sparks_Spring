package mySpring.factoryPattern.abstractFactory;

import mySpring.factoryPattern.bean.INoodles;
import mySpring.factoryPattern.bean.PaoNoodles;

public class KFCFoodFactory extends AbstractFoodFactory {
    @Override
    public INoodles createNoodles() {
        return new PaoNoodles();//KFC居然卖泡面
    }

    @Override
    public IDrinks createDrinks() {
        return new ColaDrinks();//卖可乐
    }
}
