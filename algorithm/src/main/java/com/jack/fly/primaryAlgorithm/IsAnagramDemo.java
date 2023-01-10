package com.jack.fly.primaryAlgorithm;

import java.util.HashMap;

/**
 * @author:新晋菜鸡
 * @create: 2023-01-10 23:05
 * @Description: 有效的字母异位词
 */
public class IsAnagramDemo {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        boolean anagram = isAnagram(s, t);
        System.out.println(anagram);
    }

    public static boolean isAnagram(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        if (tChar.length != sChar.length) {
            return false;
        }
        //统计字母(字符)出现的次数
        int[] count = new int[26];
        for (int i = 0; i < sChar.length; i++) {
            count[sChar[i] - 'a']++;
        }

        for (int i = 0; i < tChar.length; i++) {
            //该字符在 s中不存在
            if (count[tChar[i] - 'a'] == 0) {
                return false;
            }
            count[tChar[i] - 'a']--;
        }

        return true;

    }


}
