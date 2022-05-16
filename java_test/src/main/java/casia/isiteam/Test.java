package casia.isiteam;

import casia.isiteam.Trie.vo.TreeNode;
import casia.isiteam.list.vo.ListNode;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections.map.LinkedMap;

import java.util.*;

/**
 * @ClassName: Test
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2021/9/13
 * Email: zhiyou_wang@foxmail.com
 */
public class Test  {
    private ListNode listNode = new ListNode(1,new ListNode(2));

    public void test (){
        ListNode a = listNode;
        listNode.val = 2;
        System.out.println(a.val);
    }

    public static void main(String[] args) {
        String[] strs = {"a", "b", "ac", "ad", "be"};
        Arrays.sort(strs);
        for (String str : strs) {
            System.out.println(str);
        }

    }

}
