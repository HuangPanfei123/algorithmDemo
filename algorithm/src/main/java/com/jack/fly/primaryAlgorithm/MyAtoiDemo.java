package com.jack.fly.primaryAlgorithm;

/**
 * @author:新晋菜鸡
 * @create: 2023-01-14 19:39
 * @Description: 字符串转换整数 (atoi)
 */
public class MyAtoiDemo {
    public static void main(String[] args) {

        int myAtoi = myAtoi("-2147483649");

        System.out.println("myAtoi:" + myAtoi);
        System.out.println(Integer.MAX_VALUE / 10);
        System.out.println(Integer.MIN_VALUE / 10);

    }

    public static int myAtoi(String str) {
        char[] chars = str.toCharArray();
        int len = chars.length;
        int res = 0;
        int signe = 1;
        int index = 0;
        //去空格
        while (index < len && chars[index] == ' ') {
            index++;

        }
        char singeChar = chars[index];
        //读取正负符号
        if (singeChar == '+') {
            index++;
        } else if (singeChar == '-') {
            signe = -1;
            index++;
        }

        while (index < len) {
            char currChar = chars[index];
            //判断字符是否合法
            if (chars[index] > '9' || chars[index] < '0') {
                break;
            }
            System.out.println(chars[index] - '0');
            System.out.println(Integer.MAX_VALUE % 10);
            //判断是否在符合范围
            if (res > Integer.MAX_VALUE / 10
                    || (res == Integer.MAX_VALUE / 10 && (currChar - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10
                    || (res == Integer.MIN_VALUE / 10 && (currChar - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }

            res = res * 10 + signe * (chars[index] - '0');
            index++;
        }
        return res;
    }


}
