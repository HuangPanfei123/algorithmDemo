package com.jack.fly.primaryAlgorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:新晋菜鸡
 * @create: 2023-01-10 22:41
 * @Description: 字符串中的第一个唯一字符
 */
public class FirstUniqCharDemo {
    public static void main(String[] args) {
        String s = "loveleetcode";
        int i = firstUniqChar(s);
        System.out.println(i);
    }

    public static int firstUniqChar(String s) {
        char[] array = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c: array) {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i]) == 1) {
                return i;
            }
        }
        return -1;
    }
}
