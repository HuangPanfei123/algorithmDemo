package com.jack.fly.primaryAlgorithm;

/**
 * @author:新晋菜鸡
 * @create: 2023-01-13 23:58
 * @Description: 字符串匹配 KMP算法
 */
public class KMPStrStrDemo {

    public static void main(String[] args) {
        System.out.println(strStr("leetcode","leeto"));
        System.out.println(strSt2r("leetcode","leeto"));
    }

    // KMP 算法
    // ss: 原串(string)  pp: 匹配串(pattern)
    public static int strStr(String ss, String pp) {
        if (pp.isEmpty()) return 0;

        // 分别读取原串和匹配串的长度
        int n = ss.length(), m = pp.length();
        // 原串和匹配串前面都加空格，使其下标从 1 开始
        ss = " " + ss;
        pp = " " + pp;

        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();

        // 构建 next 数组，数组长度为匹配串的长度（next 数组是和匹配串相关的）
        int[] next = new int[m + 1];
        // 构造过程 i = 2，j = 0 开始，i 小于等于匹配串长度 【构造 i 从 2 开始】
        for (int i = 2, j = 0; i <= m; i++) {
            // 匹配不成功的话，j = next(j)
            while (j > 0 && p[i] != p[j + 1]) j = next[j];
            // 匹配成功的话，先让 j++
            if (p[i] == p[j + 1]) j++;
            // 更新 next[i]，结束本次循环，i++
            next[i] = j;
        }

        // 匹配过程，i = 1，j = 0 开始，i 小于等于原串长度 【匹配 i 从 1 开始】
        for (int i = 1, j = 0; i <= n; i++) {
            // 匹配不成功 j = next(j)
            while (j > 0 && s[i] != p[j + 1]) j = next[j];
            // 匹配成功的话，先让 j++，结束本次循环后 i++
            if (s[i] == p[j + 1]) j++;
            // 整一段匹配成功，直接返回下标
            if (j == m) return i - m;
        }

        return -1;
    }

    public static int strSt2r(String haystack, String needle) {

        if(needle.length() == 0 ) {
            return 0;
        }
        int n  = haystack.length();
        int m = needle.length();
        haystack = " " +haystack;
        needle = " " +needle;
        char [] ha = haystack.toCharArray();
        char [] ne = needle.toCharArray();
        int [] next = new int [m+1];

        for(int i = 2,j =  0 ;i<=m ;i++){
            while(j>0& ne[i]!=ne[j+1]){
                j = next [j];
            }
            if(ne[i]==ne[j+1]){
                j++;
            }
            next[i] = j;
        }
        for(int i = 1,j=0;i<=n; i++){
            while(j>0&&ha[i]!=ha[j+1]){
                j = next[j];
            }
            if(ha[i]==ne[j+1]){
                j++;
            }
            if(j == m){
                return i-m;
            }
        }
        return  -1;
    }

}
