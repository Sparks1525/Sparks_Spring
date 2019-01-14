package mySpring.factoryPattern.simpleFactory;

import mySpring.factoryPattern.bean.GankouNoodles;
import mySpring.factoryPattern.bean.INoodles;
import mySpring.factoryPattern.bean.LzNoodles;
import mySpring.factoryPattern.bean.PaoNoodles;

public class SimpleNoodlesFactory {
    public static final int TYPE_LZ = 1;//兰州拉面
    public static final int TYPE_PM = 2;//泡面
    public static final int TYPE_GK = 3;//干扣面

    public static INoodles createNoodles(int type) {
        switch (type) {
            case TYPE_LZ:
                return new LzNoodles();
            case TYPE_PM:
                return new PaoNoodles();
            case TYPE_GK:
            default:
                return new GankouNoodles();
        }
    }



    public static void main(String[] args){
        /**
         * 简单工厂模式
         */
        INoodles noodles = SimpleNoodlesFactory.createNoodles(SimpleNoodlesFactory.TYPE_GK);
        noodles.desc();
    }

}
