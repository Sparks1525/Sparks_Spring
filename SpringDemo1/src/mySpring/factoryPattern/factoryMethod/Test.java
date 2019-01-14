package mySpring.factoryPattern.factoryMethod;

import mySpring.factoryPattern.bean.INoodles;

public class Test {



    public static void main(String[] args){
        /**
         * 普通工厂方法：
         */
        System.out.println("===========================普通工厂方法==============================" +
                "\n 这种要多写一个类，不过更面向对象吧 = = ，实际中我更倾向于使用【模仿Executor类】的方式");
        INoodlesFactory factory1 = new GankouFactory();
        INoodles gk3 = factory1.create();
        gk3.desc();
    }
}
