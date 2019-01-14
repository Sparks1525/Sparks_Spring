package mySpring.factoryPattern.factoryMethod;


import mySpring.factoryPattern.bean.GankouNoodles;
import mySpring.factoryPattern.bean.INoodles;

public class GankouFactory implements INoodlesFactory {
    @Override
    public INoodles create() {
        return new GankouNoodles();
    }
}
