package casia.isiteam.sort;

import java.util.Arrays;

/**
 * @ClassName: MergeSort
 * @Description: 归并排序
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/3/17
 * Email: zhiyou_wang@foxmail.com
 */
public class MergeSort {
    //归并排序
    //和选择排序一样，归并排序的性能不受输入数据的影响，但表现比选择排序好的多，因为始终都是O(n log n）的时间复杂度。代价是需要额外的内存空间。
    //算法描述:
    //把长度为n的输入序列分成两个长度为n/2的子序列；
    //对这两个子序列分别采用归并排序；
    //将两个排序好的子序列合并成一个最终的排序序列
    public static void main(String[] args) {
        int[] array = {1,5,3,7,9,8,5,10,2,4,6};

        array = mergeSort(array);
        //打印
        for (int i : array) {
            System.out.print(i+"，");
        }
    }
    /**
     * 归并排序
     *
     * @param array
     * @return
     */
    public static int[] mergeSort(int[] array) {
        if (array.length < 2) return array;
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(mergeSort(left), mergeSort(right));
    }
    /**
     * 归并排序——将两段排序好的数组结合成一个排序数组
     *
     * @param left
     * @param right
     * @return
     */
    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length)
                result[index] = right[j++];
            else if (j >= right.length)
                result[index] = left[i++];
            else if (left[i] > right[j])
                result[index] = right[j++];
            else
                result[index] = left[i++];
        }
        return result;
    }

    // 算法分析
    //最佳情况：T(n) = O(n)  最差情况：T(n) = O(n log n)  平均情况：T(n) = O(n log n)
}
