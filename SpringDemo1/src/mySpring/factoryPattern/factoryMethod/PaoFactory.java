package mySpring.factoryPattern.factoryMethod;

import mySpring.factoryPattern.bean.INoodles;
import mySpring.factoryPattern.bean.PaoNoodles;

public class PaoFactory implements INoodlesFactory {
    @Override
    public INoodles create() {
        return new PaoNoodles();
    }
}
