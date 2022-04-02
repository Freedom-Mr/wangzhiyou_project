package casia.isiteam;

import java.util.Arrays;

/**
 * @ClassName: lengthOfLongestSubstring
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2021/9/15
 * Email: zhiyou_wang@foxmail.com
 */
public class lengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "aba";

        int maxLength = s.length()>0?1:0;

        char[] chars = s.toCharArray();
        int length =chars.length;
        for (int i = 0; i < length; i++) {
            String i_char = String.valueOf(chars[i]);
            String maxString = i_char;
            for (int j = i+1; j < length; j++) {
                String j_char = String.valueOf(chars[j]);
                if( maxString.contains(j_char) ){
                    System.out.println(maxString);
                    break;
                }else {
                    maxString+=j_char;
                }
            }
            maxLength = maxString.length()>maxLength ? maxString.length() : maxLength;
        }
//        System.out.println(maxLength);


        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);
            Arrays.stream(last).forEach(c->{
                System.out.print(c+",");
            });
            System.out.println();

            start = Math.max(start, last[index] + 1);
            res   = Math.max(res, i - start + 1);
            last[index] = i;

            Arrays.stream(last).forEach(c->{
                System.out.print(c+",");
            });

            System.out.println();
            System.out.println();

        }
        System.out.println(res);
    }
}
