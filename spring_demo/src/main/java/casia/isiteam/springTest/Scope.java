package casia.isiteam.springTest;

import casia.isiteam.springTest.pojo.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName: Scope
 * @Description: Bean作用域 示范
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/3/21
 * Email: zhiyou_wang@foxmail.com
 */
public class Scope {
    /**
     * Spring ApplicationContext 容器
     */
    //     * Spring 框架支持以下五个作用域，分别为 singleton、prototype、request、session 和 global session
    //     * singleton    在spring IoC容器仅存在一个Bean实例，Bean以单例方式存在，默认值
    //     * prototype	每次从容器中调用Bean时，都返回一个新的实例，即每次调用getBean()时，相当于执行newXxxBean()
    //     * request	每次HTTP请求都会创建一个新的Bean，该作用域仅适用于WebApplicationContext环境
    //     * session	同一个HTTP Session共享一个Bean，不同Session使用不同的Bean，仅适用于WebApplicationContext环境
    //     * global-session	一般用于Portlet应用环境，该作用域仅适用于WebApplicationContext环境
    public static void main(String[] args) {
        //singleton作用域
        singletonApplicationContext();
        //prototype 作用域
        prototypeApplicationContext();
    }

    /**
     * singleton    在spring IoC容器仅存在一个Bean实例，Bean以单例方式存在，默认值
     */
    public static void singletonApplicationContext(){
        System.out.println("singleton 作用域结果：");
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        HelloWorld objA = (HelloWorld) context.getBean("singleton_helloWorld");
        objA.setMessage("I'm object A");
        objA.getMessage();

        HelloWorld objB = (HelloWorld) context.getBean("singleton_helloWorld");
        objB.getMessage();
    }

    /**
     * prototype   每次从容器中调用Bean时，都返回一个新的实例，即每次调用getBean()时，相当于执行newXxxBean()
     */
    public static void prototypeApplicationContext(){
        System.out.println("prototype 作用域结果：");
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        HelloWorld objA = (HelloWorld) context.getBean("prototype_helloWorld");
        objA.setMessage("I'm object A");
        objA.getMessage();

        HelloWorld objB = (HelloWorld) context.getBean("prototype_helloWorld");
        objB.getMessage();
    }
}
