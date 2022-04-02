package casia.isiteam.sort;

/**
 * @ClassName: InsertionSort
 * @Description: 插入排序
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/3/11
 * Email: zhiyou_wang@foxmail.com
 */
public class InsertionSort {
    /**
     * 插入排序
     * @param args
     */
    public static void main(String[] args) {
        int[] array = {1,5,3,7,9,8,5,10,2,4,6};
        int preIndex=0,current=0;
        for(int i=1;i<array.length;i++){
            preIndex = i - 1;
            current = array[i];
            while (preIndex >= 0 && array[preIndex] > current) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }

        //打印
        for (int i : array) {
            System.out.print(i+"，");
        }
    }

    /**
     * --算法描述
     * 一般来说，插入排序都采用in-place在数组上实现。具体算法描述如下：
     *
     * 从第一个元素开始，该元素可以认为已经被排序；
     * 取出下一个元素，在已经排序的元素序列中从后向前扫描；
     * 如果该元素（已排序）大于新元素，将该元素移到下一位置；
     * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
     * 将新元素插入到该位置后；
     * 重复步骤2~5。
     *
     * --算法分析
     * 插入排序在实现上，通常采用in-place排序（即只需用到O(1)的额外空间的排序），因而在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。
     */

}
