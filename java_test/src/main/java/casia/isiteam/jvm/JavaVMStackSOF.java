package casia.isiteam.jvm;

/**
 * @ClassName: JavaVMStackSOF
 * @Description: 虚拟机栈 和 本地方法栈 溢出
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/3/12
 * Email: zhiyou_wang@foxmail.com
 */
public class JavaVMStackSOF {
    private int stackLength = 1;
    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable{
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        }catch (Throwable e){
            System.out.println("stack length:"+oom.stackLength);
            throw e;
        }

    }
}
