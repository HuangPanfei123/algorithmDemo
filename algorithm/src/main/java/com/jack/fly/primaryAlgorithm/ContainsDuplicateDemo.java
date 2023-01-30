package com.jack.fly.primaryAlgorithm;

import java.util.Arrays;

/**
 * @author:新晋菜鸡
 * @create: 2023-01-14 20:41
 * @Description: 存在重复元素
 */
public class ContainsDuplicateDemo {
    public static void main(String[] args) {
//        int [] nums = new int []{1,1,1,3,3,4,3,2,4,2};
//        int [] nums1 = new int []{1,2,3,4};
//        boolean duplicate = containsDuplicate(nums1);
//        System.out.println(duplicate);
        int climbStairs = climbStairs(1);
        System.out.println(climbStairs);
    }
    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int index = 0;
        while(index<nums.length-1){
            if(nums[index]==nums[index+1]){
                return true;
            }
            index++;
        }
        return false;
    }
    public static int climbStairs(int n) {

        if(n<=2){
            return n;
        }
        int [] dp =  new int [n+1] ;
        dp[1] = 1;
        dp[2] =2;
        for(int i = 3;i<=n;i++){

                dp[i] = dp[i-1]+dp[i-2];

        }
        return dp[n];
    }
}
