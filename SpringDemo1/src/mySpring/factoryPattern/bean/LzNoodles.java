package mySpring.factoryPattern.bean;

public class LzNoodles implements INoodles {

    @Override
    public void desc() {
        System.out.println("兰州拉面 上海的好贵 家里才5 6块钱一碗");
    }
}
