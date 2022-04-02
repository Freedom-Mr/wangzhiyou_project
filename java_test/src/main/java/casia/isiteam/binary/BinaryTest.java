package casia.isiteam.binary;

/**
 * @ClassName: BinaryTest
 * @Description: 二进制 位运算
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/3/24
 * Email: zhiyou_wang@foxmail.com
 */
public class BinaryTest {
    //二进制 位运算

    public static void main(String[] args) {

        int o = 1;
        int p = 2;

        //打印二进制  前补位为0不显示
        System.out.println(Integer.toBinaryString(o));
        System.out.println(Integer.toBinaryString(p));

        //位运算 & 与。 只有两个位都为1时，结果才为1
        int v1 = o & p;// o的二进制为0001 ，p的二进制为0010， 与位运算后为0000
        System.out.println("与二进制："+Integer.toBinaryString(v1));
        System.out.println("与结果："+v1);

        //位运算 | 或。 只有两个位都为0时，结果才为0
        int v2 = o | p;// o的二进制为0001 ，p的二进制为0010， 或位运算后为0011
        System.out.println("或二进制："+Integer.toBinaryString(v2));
        System.out.println("或结果："+v2);

        //位运算 ^ 异或。 两个位相同为0，相异为1
        int v3 = o ^ p;// o的二进制为0001 ，p的二进制为0010， 异或位运算后为0011
        System.out.println("异或二进制："+Integer.toBinaryString(v3));
        System.out.println("异或结果："+v3);

        //位运算 ~ 取反。 0变1，1变0
        int v4 = ~o ;// o的二进制为0001 ，取反位运算后为1111 1111 1111 1111 1111 1111 1111 1110
        System.out.println("取反二进制："+Integer.toBinaryString(v4));
        System.out.println("取反结果："+v4);

        //位运算 << 左移. 各二进位全部左移若干位，高位丢弃，低位补0
        int v5 = p << 1 ;// p的二进制为0010 ，左移一位为 0100
        System.out.println("左移1位二进制："+Integer.toBinaryString(v5));
        System.out.println("左移结果："+v5);

        //位运算 >> 右移. 各二进位全部向右移若干位，低位丢弃，高位补0
        int v6 = p >> 1 ;// p的二进制为0010 ，右移一位为 0001
        System.out.println("右移1位二进制："+Integer.toBinaryString(v6));
        System.out.println("右移结果："+v6);

    }
}
