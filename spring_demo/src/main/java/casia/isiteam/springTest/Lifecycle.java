package casia.isiteam.springTest;

import casia.isiteam.springTest.pojo.HelloWorld;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName: Lifecycle
 * @Description: bean生命周期测试
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/3/21
 * Email: zhiyou_wang@foxmail.com
 */
public class Lifecycle {
    /**
     * 生命周期：Bean的定义——Bean的初始化——Bean的使用——Bean的销毁
     * 你需要注册一个在 AbstractApplicationContext 类中声明的关闭 hook 的 registerShutdownHook() 方法。它将确保正常关闭，并且调用相关的 destroy 方法。
     * @param args
     */
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
        obj.getMessage();
        context.registerShutdownHook();
    }
}
