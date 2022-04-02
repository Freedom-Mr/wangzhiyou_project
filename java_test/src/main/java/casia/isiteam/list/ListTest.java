package casia.isiteam.list;

import casia.isiteam.list.vo.ListNode;

/**
 * @ClassName: ListTest
 * @Description: 链表操作测试
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/3/15
 * Email: zhiyou_wang@foxmail.com
 */
public class ListTest {
    /**
     * 初始化数据
     * @return
     */
    private ListNode initData(){
        ListNode listNode = new ListNode(1,new ListNode(3,new ListNode(2,new ListNode(7,new ListNode(7,new ListNode(4,new ListNode(5,new ListNode(6))))))));
        System.out.println("初始化链表：{1,3,2,7,7,4,5,6}");
        return listNode;
    }
    public static void main(String[] args) {
        ListTest test = new ListTest();
        //初始化数据
        ListNode listNode = test.initData();

        //反转链表
        test.ReverseList( listNode);
    }

    /**
     * 反转链表  例如输入：{1,2,3} ，输出：{3,2,1}
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        //新链表
        ListNode newHead = null;
        while (head != null) {
            //先保存访问的节点的下一个节点，保存起来
            //留着下一步访问的
            ListNode temp = head.next;
            //每次访问的原链表节点都会成为新链表的头结点，
            //其实就是把新链表挂到访问的原链表节点的
            //后面就行了
            head.next = newHead;
            //更新新链表
            newHead = head;
            //重新赋值，继续访问
            head = temp;
        }

        //打印
        System.out.print("反转链表：");
        ListNode rs = newHead;
        while ( rs != null ){
            System.out.print(rs.val+",");
            rs = rs.next;
        }

        //返回新链表
        return newHead;
    }
}
