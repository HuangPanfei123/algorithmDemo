package primaryAlgorithm;

import java.util.Arrays;
import java.util.function.IntConsumer;

/**
 * @author:新晋菜鸡
 * @create: 2023-01-08 22:54
 * @Description: 删除重复元素
 */
public class RemoveDuplicatesDemo {
    public static void main(String[] args) {
        int [] nums = {0,0,1,1,1,2,2,3,3,4};

        //使用双指针方法
        int left = 0;

        for (int i = 0 ; i< nums.length;i++ ){
            if(nums[i]!=nums[left]){
                //如果左指针和右指针指向的值一样，说明有重复的，
                //这个时候，左指针不动，右指针继续往右移。如果他俩
                //指向的值不一样就把右指针指向的值往前挪

                left++;
                nums[left] = nums[i];
            }

        }
        System.out.println("left:"+left);
        Arrays.stream(nums).forEach(value -> System.out.print(value));

        //找出重复个数，并删除
        int count = 0 ;
        for (int i = 1 ; i< nums.length;i++ ){
            if(nums[i]==nums[i-1]){
                //如果有重复就累加
                count++;

            }else {
                //如果没有重复，后面的就往前挪
                nums[i-count] = nums[i];
            }
        }
        //输出删除后数组长度
        System.out.println(nums.length-count);

    }
}
