package com.jack.fly.primaryAlgorithm;

import java.util.Locale;

/**
 * @author:新晋菜鸡
 * @create: 2023-01-13 00:09
 * @Description: 验证回文串
 */
public class IsPalindromeDemo {
    public static void main(String[] args) {

        boolean palindrome = isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(palindrome);

    }

    public static boolean isPalindrome(String s) {

        if (s == null || s.length() == 0)
            return true;
        s = s.toLowerCase();
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i)))
                i++;
            while (i < j && !Character.isLetterOrDigit(s.charAt(j)))
                j--;
            if (s.charAt(i) != s.charAt(j))
                return false;
        }
        return true;

    }
}
