package casia.isiteam.sort;

/**
 * @ClassName: SelectionSort  选择排序
 * @Description: 选择排序
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/3/11
 * Email: zhiyou_wang@foxmail.com
 */
public class SelectionSort {
    /**
     * 选择排序 不稳定
     * @param args
     */
//    选择排序(Selection-sort)是一种简单直观的排序算法。
//    它的工作原理：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
//    然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
    public static void main(String[] args) {
        int[] array = {1,5,3,7,9,8,5,10,2,4,6};

        for(int i=0;i<array.length-1;i++){
            for( int j=i;j<array.length-1;j++ ){
                boolean rs = array[i] > array[j+1];
                array[i] = rs ? (array[i]+array[j+1]) - (array[j+1] = array[i]) : array[i];
            }
        }

        //打印
        for (int i : array) {
            System.out.print(i+"，");
        }
    }

    /**
     * -- 算法描述
     * n个记录的直接选择排序可经过n-1趟直接选择排序得到有序结果。具体算法描述如下：
     *
     * 初始状态：无序区为R[1..n]，有序区为空；
     * 第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n）。该趟排序从当前无序区中-选出关键字最小的记录 R[k]，将它与无序区的第1个记录R交换，使R[1..i]和R[i+1..n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
     * n-1趟结束，数组有序化了。
     *
     * -- 算法分析
     * 表现最稳定的排序算法之一，因为无论什么数据进去都是O(n2)的时间复杂度，所以用到它的时候，数据规模越小越好。唯一的好处可能就是不占用额外的内存空间了吧。理论上讲，选择排序可能也是平时排序一般人想到的最多的排序方法了吧。
     */
}
