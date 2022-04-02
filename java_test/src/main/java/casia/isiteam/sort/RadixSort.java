package casia.isiteam.sort;

import java.util.ArrayList;

/**
 * @ClassName: RadixSort
 * @Description: 桶排序
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/3/18
 * Email: zhiyou_wang@foxmail.com
 */
public class RadixSort {
    //基数排序
    public static void main(String[] args) {
        int[] array = {1,5,3,7,9,8,5,10,2,4,6};

        radixSort(array);

        //打印
        for (int i : array) {
            System.out.print(i+"，");
        }
    }

    /**
     * 基数排序
     * @param array
     * @return
     */
    public static int[] radixSort(int[] array) {
        if (array == null || array.length < 2)
            return array;
        // 1.先算出最大数的位数；
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max, array[i]);
        }
        int maxDigit = 0;
        while (max != 0) {
            max /= 10;
            maxDigit++;
        }
        int mod = 10, div = 1;
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 10; i++)
            bucketList.add(new ArrayList<Integer>());
        for (int i = 0; i < maxDigit; i++, mod *= 10, div *= 10) {
            for (int j = 0; j < array.length; j++) {
                int num = (array[j] % mod) / div;
                bucketList.get(num).add(array[j]);
            }
            int index = 0;
            for (int j = 0; j < bucketList.size(); j++) {
                for (int k = 0; k < bucketList.get(j).size(); k++)
                    array[index++] = bucketList.get(j).get(k);
                bucketList.get(j).clear();
            }
        }
        return array;
    }

    // 算法分析
    //最佳情况：T(n) = O(n * k)   最差情况：T(n) = O(n * k)   平均情况：T(n) = O(n * k)
    //
    //基数排序有两种方法：
    //
    //MSD 从高位开始进行排序 LSD 从低位开始进行排序
}
