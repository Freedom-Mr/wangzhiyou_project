package casia.isiteam.springTest;

import casia.isiteam.springTest.pojo.TextEditor;
import casia.isiteam.springTest.pojo.TextEditor2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName: MainApp2
 * @Description: Spring 基于构造、设值函数的依赖注入
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/3/21
 * Email: zhiyou_wang@foxmail.com
 */
public class MainApp2 {

    public static void main(String[] args) {
        buildMain();
        setValueMain();
    }
    /**
     * 构造函数依赖注入
     * 当容器调用带有一组参数的类构造函数时，基于构造函数的 DI 就完成了，其中每个参数代表一个对其他类的依赖。
     * 接下来，我们将通过示例来理解 Spring 基于构造函数的依赖注入。
     */
    public static void buildMain() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("Beans.xml");
        TextEditor te = (TextEditor) context.getBean("textEditor");
        te.spellCheck();
    }
    /**
     * 设置函数依赖注入

     */
    public static void setValueMain() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("Beans.xml");
        TextEditor2 te = (TextEditor2) context.getBean("textEditor2");
        te.spellCheck();
    }
}
