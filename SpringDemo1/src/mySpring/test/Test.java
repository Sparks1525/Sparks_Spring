package mySpring.test;


import mySpring.bean.HelloWorld;
import mySpring.bean.Student;
import mySpring.factoryPattern.bean.GankouNoodles;
import mySpring.factoryPattern.bean.PaoNoodles;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * 添加@RunWith标签;
 * 1,告诉JUnit,在测试开始的时候,先启动spring容器,在测试完成之后记得关闭spring容器;
 * 2,自动的把当前这个测试类也加入到了spring容器中管理
 */
@RunWith(SpringJUnit4ClassRunner.class)

/**
 * 添加@ContextConfiguration标签;
 * 告诉spring从什么地方加载配置文件,默认情况下使用相对路径查询;也可以使用classpath前缀
 * 如果在ContextConfiguration标签中不写配置文件地址,spring可以通过一个约定的地方找到配置文件;
 * 1,和测试类一个包里;
 * 2,这个配置文件的名字叫做 测试类-context.xml
 */
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class Test {

    private static final Logger LOGGER = LogManager.getLogger(Test.class);

    /**
     * 使用@Autowired标签,就自动的把spring创建好的容器的引用,设置给了这个字段;
     */
    @Autowired
    private BeanFactory beanFactory;

    //private Student studentCXT;

    /**
     * 其实,在使用spring测试的时候,启动的容器都是ApplicationContext;
     * 因为启动的容器都是ApplicationContext继承了BeanFactory,所以我们可以直接在这里注入BeanFactory
     */
    @Autowired
    private ApplicationContext cxt;


    /*
     * Spring中提供的容器
     *
     * 1,BeanFactory:BeanFactory是Spring中提供的最简单,最基本的容器;这个容器只提供了IoC/DI的功能;
     * 2,BeanFactory的重要方法:getBean();
     * 3,我们一般使用的是Spring提供的功能更加全面的ApplicationContext;
     * ApplicationContext:是一个功能更加全面的容器,一般我们直接使用这个容器;
     * 1,ApplicationContext接口继承了BeanFactory接口,所以,ApplicationCOntext实现了getBean方法;
     * 2,提供了额外的功能:
     *      1,环境感知;
     *      2,容器的继承体系;
     *      3,国际化相关;
     *      4,事件发布/响应机制;
     *      5,统一的资源管理;
     *      6,AOP的功能;
     * 3,ApplicationContext使用:
     * 手动启动ApplicationCOntext:
     */


    /*
     * bean的实例化时机(容器在什么时候实例化bean)
     *  1,对于beanfactory来说,在容器启动的时候,不会去实例化bean,必须要等到使用bean的时候,才会去初始化(延迟实例化);
     *  2,对于ApplicationContext来说,在容器启动的时候,就已经把所有的管理的bean实例化了;
     *  3,对于ApplicationContext:
     *      1,可以在bean元素配置lazy-init=true来让bean延迟实例化;
     *      2,可以在beans元素配置default-lazy-init=true来让这个beans里面所有的bean延迟实例化;
     *
     * 对比:
     *  1,延迟实例化,在系统启动的时候快,系统启动的时候占用的资源少;并且,如果在使用的时候再去加载对象,第一次使用的时候性能较低;因为不会在加载的时候去实例化对象,所以延迟实例化不能对实例化出来的对象做更多的功能;
     *  2,非延迟实例化,在系统启动的时候,所有对象被实例化,启动速度慢,使用速度快,启动的时候占用较多系统资源;
     *
     * 选择:
     *  1,对于系统资源较少的应用可以使用延迟实例化(移动应用);
     *  2,对于web应用来说,一般选择迫切实例化;
     *  3,在web应用里面,我们一般把比较耗时的事情放在系统启动的时候完成;
     *
     */


    @org.junit.Test
    public void test1() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");
        HelloWorld helloWorld = beanFactory.getBean("HelloWorld", HelloWorld.class);
        LOGGER.debug(helloWorld.getName());
    }

    @org.junit.Test
    public void test2() {
        HelloWorld helloWord = new HelloWorld();
        helloWord.setName("Hello Word");
        LOGGER.debug(helloWord.getName());
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        HelloWorld helloWorld = context.getBean("HelloWorld", HelloWorld.class);
        LOGGER.debug(helloWorld.getName());
    }

    @org.junit.Test
    public void test3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        String[] srt = context.getAliases("student1");
        if (srt != null) {
            for (String temp : srt) {
                LOGGER.debug(temp);
            }
        }
        Student student1 = context.getBean("student1", Student.class);
        LOGGER.debug(student1.getName());
    }

    @org.junit.Test
    public void test4() {
        Student student1 = beanFactory.getBean("student1", Student.class);
        LOGGER.debug(student1.getName());
    }

    @org.junit.Test
    public void test5() {
        Student student1 = cxt.getBean("student1", Student.class);
        LOGGER.debug(student1.getName());
    }

    //静态工厂
    @org.junit.Test
    public void test6() {
        PaoNoodles paoNoodles = (PaoNoodles) cxt.getBean("PaoNoodles");
        paoNoodles.desc();
    }

    //工厂方法
    @org.junit.Test
    public void test7() {
        GankouNoodles gankouNoodles = (GankouNoodles) cxt.getBean("gnfactory");
        gankouNoodles.desc();
    }


    //工厂方法
    @org.junit.Test
    public void test8() {
        GankouNoodles gankouNoodles = (GankouNoodles) cxt.getBean("factoryMethod");
        gankouNoodles.desc();
    }


}
