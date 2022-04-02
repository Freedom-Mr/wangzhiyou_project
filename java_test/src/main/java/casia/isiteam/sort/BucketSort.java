package casia.isiteam.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName: BucketSort
 * @Description: 桶排序
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/3/18
 * Email: zhiyou_wang@foxmail.com
 */
public class BucketSort {
    //桶排序
    //算法描述
    //人为设置一个BucketSize，作为每个桶所能放置多少个不同数值（例如当BucketSize==5时，该桶可以存放｛1,2,3,4,5｝这几种数字，但是容量不限，即可以存放100个3）；
    //遍历输入数据，并且把数据一个一个放到对应的桶里去；
    //对每个不是空的桶进行排序，可以使用其它排序方法，也可以递归使用桶排序；
    //从不是空的桶里把排好序的数据拼接起来
    public static void main(String[] args) {
        int[] array = {1,5,3,7,9,8,5,10,2,4,6};

        bucketSort(array);

        //打印
        for (int i : array) {
            System.out.print(i+"，");
        }
    }

    public static void bucketSort(int[] arr){

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        //桶数
        int bucketNum = (max - min) / arr.length + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for(int i = 0; i < bucketNum; i++){
            bucketArr.add(new ArrayList<Integer>());
        }

        //将每个元素放入桶
        for(int i = 0; i < arr.length; i++){
            int num = (arr[i] - min) / (arr.length);
            bucketArr.get(num).add(arr[i]);
        }

        //对每个桶进行排序
        for(int i = 0; i < bucketArr.size(); i++){
            Collections.sort(bucketArr.get(i));
        }

        for (ArrayList<Integer> arrayList : bucketArr) {
            for (int i=0;i<arrayList.size();i++){
                arr[i] = arrayList.get(i);
            }
        }
    }

    //算法分析
    //桶排序最好情况下使用线性时间O(n)，桶排序的时间复杂度，取决与对各个桶之间数据进行排序的时间复杂度，因为其它部分的时间复杂度都为O(n)。很显然，桶划分的越小，各个桶之间的数据越少，排序所用的时间也会越少。但相应的空间消耗就会增大。
    //
    //最佳情况：T(n) = O(n+k)   最差情况：T(n) = O(n+k)   平均情况：T(n) = O(n2)　
}
