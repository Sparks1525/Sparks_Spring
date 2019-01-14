package mySpring.factoryPattern.abstractFactory;

public class Test {

    public static void main(String[] args) {
        /**
         * 抽象工厂方法：
         */
        System.out.println("==============================抽象方法==============================" +
                "\n 老实说，以我这一年的水平我体会不到抽象工厂有何巨大优势，所以在我这里我没有想到很好的使用场景。希望以后在慢慢体会吧。");
        AbstractFoodFactory abstractFoodFactory1 = new KFCFoodFactory();
        abstractFoodFactory1.createDrinks().prices();
        abstractFoodFactory1.createNoodles().desc();

        abstractFoodFactory1 = new LzlmFoodFactory();
        abstractFoodFactory1.createDrinks().prices();
        abstractFoodFactory1.createNoodles().desc();
    }

}
