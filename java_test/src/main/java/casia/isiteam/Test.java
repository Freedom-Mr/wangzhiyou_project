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
        String[] strs = {"# a", "## b", "## c", "### d", "# e"};

        List<Map<String,String>> result = new ArrayList<>();

//        //进化变身
//        int z=1;
//        for(String str:strs){
//            String[] headStr = str.split(" ");
//            z= headStr[0].length() == 1 ? z+1:z;
//
//        }


        //笨方法
        int i = 0;
        int number = 0;
        for(String str:strs){
            String headStr = str.substring(0,str.indexOf(" ")).replace(" ","");
            String endStr = str.substring(str.indexOf(" "));
            i=headStr.length()==1?i+1:i;
            number=headStr.length()==1?0:number;
            for(int j=0;j<headStr.length();j++){
                number = number + (j==0?j:(int)Math.pow(10,j));
            }

            Map<String,String> parms = new HashMap<>();
            String nums =number+i+"";
            StringBuffer sv = new StringBuffer();
            char[] charArray = nums.toCharArray();
            for (int z = charArray.length-1; z>=0 ; z--) {
                sv.append(sv.length()>0?".":"").append(charArray[z]);
            }
            parms.put("hn",sv.toString());
            parms.put("title",endStr);
            result.add(parms);
        }

        //打印
        System.out.println(result);
        System.out.println("a".hashCode());

        String key = "aa";
        key.length();
        Integer h ;
        String s = Integer.toBinaryString(key.hashCode());
        System.out.println(s);
        System.out.println(key.charAt(0)+"");
        System.out.println(Integer.toBinaryString(key.hashCode() >>> 1));
        StringBuilder sb = new StringBuilder();
        sb.append("a",0,1);
        sb.append("b",0,1);
        System.out.println(sb);
        System.out.println(System.getProperties());

        Test test = new Test();
        test.test();
        System.out.println( key.charAt(0) == key.charAt(1));

        Map<String,String> map=new TreeMap<String,String>();
        Map<String,String> map1=new HashMap<String,String>(31,0.5f);
        Map<String,String> map2=new LinkedHashMap<String,String>();
        for(int z=5;z>0;z--){
            map.put("key"+z, "value"+z);
        }
        for(int z=5;z>0;z--){
            map1.put("key"+z, "value"+z);
        }
        for(int z=5;z>0;z--){
            map2.put("key"+z, "value"+z);
        }
        System.out.println("**************TreeMap**************");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
        System.out.println("**************HashMap**************");
        for (Map.Entry<String, String> entry : map1.entrySet()) {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
        System.out.println("**************LinkedHashMap**************");
        for (Map.Entry<String, String> entry : map2.entrySet()) {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

        int n = 3 - 1;
        System.out.println(Integer.toBinaryString(n));
        n |= (n >>> 1);
        System.out.println(Integer.toBinaryString(n));
        System.out.println(n);

        int  o= 1;
        int  p= 2;
        System.out.println(o|p);

        long currentTimeMillis = System.currentTimeMillis();

        System.out.println();





    }

}
