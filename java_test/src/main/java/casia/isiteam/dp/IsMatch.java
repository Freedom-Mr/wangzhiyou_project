package casia.isiteam.dp;

/**
 * @ClassName: IsMatch
 * @Description: 正则表达式匹配
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/3/18
 * Email: zhiyou_wang@foxmail.com
 */
public class IsMatch {
    /**
     * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
     *
     * '.' 匹配任意单个字符
     * '*' 匹配零个或多个前面的那一个元素
     * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
     *
     */

    public static void main(String[] args) {
        String s1 = "aa", p1 = "a";
        String s2 = "aa", p2 = "a*";
        String s3 = "aa", p3 = ".*";
    }

    public boolean isMatch(String s, String p) {
        if(!p.contains(".") && !p.contains("*") ){

        }else if( !p.contains(".") ){

        }else if( !p.contains("*") ){

        }
        return false;
    }
}
