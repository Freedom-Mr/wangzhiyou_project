package casia.isiteam.dp;

/**
 * @ClassName: LongestPalindrome
 * @Description: 最长回文字符串
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/3/17
 * Email: zhiyou_wang@foxmail.com
 */
public class LongestPalindrome {

    //给你一个字符串 s，找到 s 中最长的回文子串。
    public static void main(String[] args) {
        //测试用例
        String st1 = "babad";
        String st2 = "cbbd";
        String st3 = "babadab";
        String st4 = "a";

        //输出  暴力解法
        System.out.println("暴力解法：");
        System.out.println(longestPalindrome1(st1));//"bab"
        System.out.println(longestPalindrome1(st2));//"bb"
        System.out.println(longestPalindrome1(st3));//"badab"
        System.out.println(longestPalindrome1(st4));//"a"

        //输出  中心扩展算法
        System.out.println("\r\n中心扩展算法：");
        System.out.println(longestPalindrome2(st1));//"bab"
        System.out.println(longestPalindrome2(st2));//"bb"
        System.out.println(longestPalindrome2(st3));//"badab"
        System.out.println(longestPalindrome2(st4));//"a"

        //输出  动态规划
        System.out.println("\r\n动态规划：");
        System.out.println(longestPalindrome3(st1));//"bab"
        System.out.println(longestPalindrome3(st2));//"bb"
        System.out.println(longestPalindrome3(st3));//"badab"
        System.out.println(longestPalindrome3(st4));//"a"
    }

    /**
     * 暴力解法
     * 时间复杂度 O(n^3)
     * @param s
     * @return
     */
    public static String longestPalindrome1(String s){
        String rs = s.charAt(0)+"";
        for(int i=1;i<s.length();i++){
            for(int j=0;j<i;j++){
                String str = s.substring(j,i+1);
                int left = 0;
                int right = str.length()-1;
                boolean is = true;
                while(left<=right){
                    if( str.charAt(left++) != str.charAt(right--) ){
                        is = false;
                        break;
                    }
                }
                if( is ){
                    rs = str.length()>rs.length()?str:rs;
                }
            }
        }
        return rs;
    }


    /**
     * 中心扩展算法
     * 时间复杂度：O(n^2)，其中 n 是字符串的长度。长度为 1 和 2 的回文中心分别有 n 和 n-1 个，每个回文中心最多会向外扩展 O(n) 次。
     * 空间复杂度：O(1)
     */
    public static String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    public static int expandAroundCenter(String s, int left, int right) {
        while ( left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right) ) {
            --left;
            ++right;
        }
        return right - left - 1;
    }

    /**
     * 动态规划
     * 时间复杂度：O(n^2)，其中 n 是字符串的长度。动态规划的状态总数为 O(n^2)，对于每个状态，我们需要转移的时间为 O(1)。
     * 空间复杂度：O(n^2)，即存储动态规划状态需要的空间。
     */
    public static String longestPalindrome3(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
