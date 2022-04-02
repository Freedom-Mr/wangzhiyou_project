package casia.isiteam.monitor;

/**
 * @ClassName: JHSDB_TestCase
 * @Description: JHSDB 是一款基于服务性代理实现的进程外调试工具
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/3/14
 * Email: zhiyou_wang@foxmail.com
 */
public class JHSDB_TestCase {
    static class Test {
        static ObjectHolder staticObc = new ObjectHolder();//放在方法区
        ObjectHolder instanceObj = new ObjectHolder();//伴随Test对象放在堆中

        void foo() {
            ObjectHolder localHolder = new ObjectHolder();//存放在foo()方法栈帧的局部变量中
            System.out.println("done");
        }
    }

    private static class ObjectHolder{

    }
    //设置jvm启动参数，使用SerialGC垃圾回收方案：   -Xmx10m -XX:+UseSerialGC -XX:-UseCompressedOops
    //staticObc 放在方法区; instanceObj 伴随Test对象放在堆中; localHolder 存放在foo()方法栈帧的局部变量中
    //打断点在System输出上
    //命令窗口执行：jsp
    //打印出运行进程如下：
    //76944 Jps
    //51940 JHSDB_TestCase
    //14280
    //16588 RemoteMavenServer
    //49308 Launcher
    //jdk>=9版本时，执行: jhsdb hsdb --pid  51940   即可调出JHSDB的界面
    //jdk7、8版本时，找到java安装路径的lib文件夹下，执行： java -cp .\sa-jdi.jar sun.jvm.hotspot.HSDB  在窗口file一项输入要监控的pid值
    public static void main(String[] args) {
        Test test = new JHSDB_TestCase.Test();
        test.foo();
    }
}
