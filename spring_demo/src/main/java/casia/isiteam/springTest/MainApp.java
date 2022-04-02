package casia.isiteam.springTest;

import casia.isiteam.springTest.pojo.HelloWorld;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @ClassName: MainApp
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/3/21
 * Email: zhiyou_wang@foxmail.com
 */
public class MainApp {

    public static void main(String[] args) {
        beanFactory();
        applicationContext();
    }
    /**
     * Spring BeanFactory 容器
     */
    //第一步是我们使用框架 API ClassPathXmlApplicationContext() 来创建应用程序的上下文。
    // 这个 API 加载 beans 的配置文件并最终基于所提供的 API，它处理创建并初始化所有的对象，即在配置文件中提到的 beans。
    //
    //第二步是使用已创建的上下文的 getBean() 方法来获得所需的 bean。
    // 这个方法使用 bean 的 ID 返回一个最终可以转换为实际对象的通用对象。一旦有了对象，你就可以使用这个对象调用任何类的方法。
    //
    //你需要创建一个 Bean 的配置文件，该文件是一个 XML 文件，并且作为粘合 bean 的粘合剂即类。这个文件需要在 src 目录下创建，
    public static void beanFactory() {
        XmlBeanFactory factory = new XmlBeanFactory
                (new ClassPathResource("Beans.xml"));
        HelloWorld obj = (HelloWorld) factory.getBean("helloWorld");
        obj.getMessage();
    }
    /**
     * Spring ApplicationContext 容器
     * 这是一个最简单的容器，它主要的功能是为依赖注入 （DI） 提供支持
     * Aplication Context 是 BeanFactory 的子接口,Application Context 是 spring 中较高级的容器。和 BeanFactory 类似，它可以加载配置文件中定义的 bean，将所有的 bean 集中在一起，当有请求的时候分配 bean
     */
    public static void applicationContext(){
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
//        ApplicationContext context = new FileSystemXmlApplicationContext("Beans.xml");

        HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
        obj.getMessage();
    }

}
