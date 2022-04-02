package casia.isiteam.springTest;

import casia.isiteam.springTest.pojo.HelloIndia;
import casia.isiteam.springTest.pojo.HelloWorld;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName: Extends
 * @Description: spring bean 定义继承
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/3/21
 * Email: zhiyou_wang@foxmail.com
 */
public class Extends {
    /**
     * bean 定义可以包含很多的配置信息，包括构造函数的参数，属性值，容器的具体信息例如初始化方法，静态工厂方法名，等等。
     * 子 bean 的定义继承父定义的配置数据。子定义可以根据需要重写一些值，或者添加其他值。
     * Spring Bean 定义的继承与 Java 类的继承无关，但是继承的概念是一样的。你可以定义一个父 bean 的定义作为模板和其他子 bean 就可以从父 bean 中继承所需的配置。
     * @param args
     */
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        HelloWorld objA = (HelloWorld) context.getBean("helloWorld");

        objA.getMessage();

        HelloIndia objB = (HelloIndia) context.getBean("helloIndia");
        objB.getMessage();
        objB.getMessage2();
        objB.getMessage3();
    }
}
