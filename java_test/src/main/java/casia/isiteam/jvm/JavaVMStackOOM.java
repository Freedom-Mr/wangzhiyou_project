package casia.isiteam.jvm;

/**
 * @ClassName: JavaVMStackOOM
 * @Description: 给每个线程的栈分配的内存越大，反而越容易产生内存溢出异常。
 *                  因为为每个线程分配到的内存越大，可以建立的线程数量自然就越少，建立线程时就越容易把剩下的内存耗尽。
 *                  VM Args： -X搜索M （这时候不妨设大些，请在32位系统运行）
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/3/12
 * Email: zhiyou_wang@foxmail.com
 */
public class JavaVMStackOOM {
    private void dontStop(){
        while (true){}
    }
    public void stackLeakByThread(){
        while (true){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }
    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}
