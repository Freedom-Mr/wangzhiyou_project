package casia.isiteam.stack;

import java.util.Stack;

/**
 * @ClassName: StackTest
 * @Description: 堆，队列测试
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/3/8
 * Email: zhiyou_wang@foxmail.com
 */
public class StackTest {
    //堆，队列测试
    public static void main(String[] args) {
        Stack<Integer> stacks = new Stack<>();
        //是否为空
        System.out.println(stacks.isEmpty());
        //压入
        stacks.push(2);
        stacks.push(1);
        //获取顶部
        System.out.println(stacks.peek());
        //获取并移除顶部
        System.out.println(stacks.pop());
    }
}
