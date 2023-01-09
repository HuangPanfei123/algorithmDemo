package com.jack.fly.primaryAlgorithm;

/**
 * @author:新晋菜鸡
 * @create: 2023-01-09 21:56
 * @Description: 反转字符串
 */
public class ReverseStringDemo {
    public static void main(String[] args) {
         String s = "hello";
        char[] chars = s.toCharArray();
        //两个指针一个从第1个，一个从最后一个开始，
        //两两交换
        int left = 0;
        int right = chars.length-1;
        while (left<right){
            char temp = chars[left];

            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        System.out.println(chars);
    }
}
