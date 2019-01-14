package mySpring.factoryPattern.abstractFactory;

public class ColaDrinks implements IDrinks {
    @Override
    public void prices() {
        System.out.println("可乐三块五");
    }
}
