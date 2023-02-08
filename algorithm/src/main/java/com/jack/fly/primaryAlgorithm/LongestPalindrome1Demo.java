package com.jack.fly.primaryAlgorithm;

/**
 * @author:新晋菜鸡
 * @create: 2023-02-08 21:57
 * @Description: 最长回文串  中心扩散法
 */
public class LongestPalindrome1Demo {
    public static void main(String[] args) {
        String palindrome = longestPalindrome("babad");
        System.out.println(palindrome);



    }

    public static String  longestPalindrome(String str){

        if(str == null || str.length()==0){
            return  str;
        }
        int strLen = str.length();
        //记录回文的起点
        int left = 0;
        //记录回文的终点
        int right = 0;
        //记录每次获取的回文长度
        int len =1;
        //记录最大的回文长度
        int maxLen = 0;
        //记录截取的起点
        int maxStart = 0;
        for (int i = 0; i < strLen; i++) {
            left = i - 1;
            right = i + 1;
            //首先往左寻找与当期位置相同的字符，直到遇到不相等为止。
            while (left >= 0 && str.charAt(left) == str.charAt(i)) {
                len++;
                left--;
            }
            //然后往右寻找与当期位置相同的字符，直到遇到不相等为止。
            while (right < strLen && str.charAt(right) == str.charAt(i)) {
                len++;
                right++;
            }
            //最后左右双向扩散，直到左和右不相等
            while (left >= 0 && right < strLen && str.charAt(right) == str.charAt(left)) {
                len = len + 2;
                left--;
                right++;
            }
            if (len > maxLen) {
                maxLen = len;
                maxStart = left;
            }
            len = 1;
        }
        return str.substring(maxStart + 1, maxStart + maxLen + 1);

    }



}
