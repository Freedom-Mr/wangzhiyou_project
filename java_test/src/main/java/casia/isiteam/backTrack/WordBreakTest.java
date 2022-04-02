package casia.isiteam.backTrack;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: WordBreak
 * @Description: 回溯算法
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/3/15
 * Email: zhiyou_wang@foxmail.com
 */
public class WordBreakTest {
    //给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
    //
    //注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。

    //例如1：
    //输入: s = "leetcode", wordDict = ["leet", "code"]
    //输出: true
    //解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
    //输入: s = "applepenapple", wordDict = ["apple", "pen"]

    //例如2：
    //输出: true
    //解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
    //     注意，你可以重复使用字典中的单词。

    public static void main(String[] args) {
        String s = "applepenapple";
        List<String> wordDict = Arrays.asList(new String[]{"apple","pen"});
        System.out.println( wordBreak(s,wordDict) );
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] valid = new boolean[s.length() + 1];
        valid[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (wordDict.contains(s.substring(j,i)) && valid[j]) {
                    valid[i] = true;

                }
            }
        }
        for (boolean b : valid) {
            System.out.print(b+"\t");
        }
        return valid[s.length()];
    }
}
