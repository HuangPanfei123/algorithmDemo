package com.jack.fly.primaryAlgorithm;

/**
 * @author:新晋菜鸡
 * @create: 2023-02-08 22:58
 * @Description: 只出现过一次的数字
 */
public class SingleNumberDemo {
    public static void main(String[] args) {
        int [] nums = {2,2,1};
        int number = singleNumber(nums);
        System.out.println(number);
    }
    public static int singleNumber(int [] nums){
        int res = 0;
        for (int n: nums
             ) {
            res = n^res;
        }
        return res;
    }
}
