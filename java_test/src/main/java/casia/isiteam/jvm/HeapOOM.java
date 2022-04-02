package casia.isiteam.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: HeapOOM
 * @Description: 堆内存溢出, 设置 -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -verbose:gc
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/3/10
 * Email: zhiyou_wang@foxmail.com
 */
public class HeapOOM {
    static class OOMObject{
    }

    public static void main(String[] args) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        while(true){
            list.add(new OOMObject());
        }
    }
}
