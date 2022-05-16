package casia.isiteam.sort;

import java.util.Arrays;

/**
 * @ClassName: QuickSort
 * @Description: 快速排序 不稳定
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/3/18
 * Email: zhiyou_wang@foxmail.com
 */
public class QuickSort {
    //快速排序  不稳定
    public static void main(String[] args) {
        int[] array = {1,5,3,7,9,8,5,10,2,4,6};

        //打印
        for (int i : array) {
            System.out.print(i+"，");
        }
        System.out.println("");

        //快排
        quickSort(array);

        //打印
        for (int i : array) {
            System.out.print(i+"，");
        }
    }

    public static void quickSort(int[] array) {
        int len;
        if(array == null || (len = array.length) == 0 || len == 1) {
            return ;
        }
        sort1(array, 0, len - 1);
    }
    /**
     * 快排核心算法，递归实现
     * @param array
     * @param left
     * @param right
     */
    public static void sort(int[] array, int left, int right) {
        if(left > right) {
            return;
        }
        // base中存放基准数
        int base = array[left];
        int i = left, j = right;
        while(i != j) {
            // 顺序很重要，先从右边开始往左找，直到找到比base值小的数
            while(array[j] >= base && i < j) {
                j--;
            }

            // 再从左往右边找，直到找到比base值大的数
            while(array[i] <= base && i < j) {
                i++;
            }
//            System.out.println(i+"("+array[i]+")\t"+j+"("+array[j]+")");
            // 上面的循环结束表示找到了位置或者(i>=j)了，交换两个数在数组中的位置
            if(i < j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }

        for (int c : array) {
            System.out.print(c+"，");
        }
        System.out.print("->");

        // 将基准数放到中间的位置（基准数归位）
        array[left] = array[i];
        array[i] = base;

        for (int c : array) {
            System.out.print(c+"，");
        }
        System.out.println("");

        // 递归，继续向基准的左右两边执行和上面同样的操作
        // i的索引处为上面已确定好的基准值的位置，无需再处理
        sort(array, left, i - 1);
        sort(array, i + 1, right);
    }


    //算法分析
    //最佳情况：T(n) = O(n log n)   最差情况：T(n) = O(n2)   平均情况：T(n) = O(n log n)　

    public static void sort1(int[] arry,int left,int right){
        if(left>right){
            return;
        }
        int i = left;
        int j = right;
        while (i!=j){
            while ( arry[j] >= arry[left] && i<j ){
                j--;
            }

            while ( arry[i] <= arry[left] && i<j ){
                i++;
            }
            if(i<j){
                int tmp = arry[i];
                arry[i] = arry[j];
                arry[j] = tmp;
            }
        }
        if( i>left ){
            int tmp = arry[i];
            arry[i] = arry[left];
            arry[left] = tmp;
        }
        sort(arry,left,i-1);
        sort(arry,i+1,right);
    }
}
