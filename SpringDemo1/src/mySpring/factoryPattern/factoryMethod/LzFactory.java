package mySpring.factoryPattern.factoryMethod;

import mySpring.factoryPattern.bean.INoodles;
import mySpring.factoryPattern.bean.LzNoodles;

public class LzFactory implements INoodlesFactory {
    @Override
    public INoodles create() {
        return new LzNoodles();
    }
}
