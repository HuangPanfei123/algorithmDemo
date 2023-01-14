package com.jack.fly.primaryAlgorithm;

import java.util.Arrays;

/**
 * @author:新晋菜鸡
 * @create: 2023-01-14 20:41
 * @Description: 存在重复元素
 */
public class ContainsDuplicateDemo {
    public static void main(String[] args) {
        int [] nums = new int []{1,1,1,3,3,4,3,2,4,2};
        int [] nums1 = new int []{1,2,3,4};
        boolean duplicate = containsDuplicate(nums1);
        System.out.println(duplicate);
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
}
