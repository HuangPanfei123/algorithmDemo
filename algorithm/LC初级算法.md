# 初级算法

#### 1.数组算法

###### 1.1删除排序数组中的重复项

给你一个 **升序排列** 的数组 `nums` ，请你**[ 原地](http://baike.baidu.com/item/原地算法)** 删除重复出现的元素，使每个元素 **只出现一次** ，返回删除后数组的新长度。元素的 **相对顺序** 应该保持 **一致** 。

**示例 1：**

```java
输入：nums = [1,1,2]
输出：2, nums = [1,2,_]
解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
```

**示例 2**

```java
输入：nums = [0,0,1,1,1,2,2,3,3,4]
输出：5, nums = [0,1,2,3,4]
解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
```

 **提示**：

```
1 <= nums.length <= 3 * 104
-104 <= nums[i] <= 104
nums 已按 升序 排列
```

**思路**

1.使用双指针：使用两个指针，右指针始终往右移动，

如果右指针指向的值等于左指针指向的值，左指针不动。
如果右指针指向的值不等于左指针指向的值，那么左指针往右移一步，然后再把右指针指向的值赋给左指针。

2.统计重复个数并删除

```java
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
```



###### 1.11旋转图像 

![image-20230108224445978](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230108224445978.png)

###### 1.11.1思路

###### 先上下交换，在对角线交换

![leet0048.png](https://pic.leetcode-cn.com/1615651665-WFwYuH-leet0048.png)

实现代码：

```
public class RotateDemo {
    public static void main(String[] args) {
        int [] [] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        for(int i = 0 ;i <matrix.length/2;i++){
            int[] temp =  matrix[i];
            matrix[i]=matrix[matrix.length-i-1];
            matrix[matrix.length-i-1]=temp;
        }
    }
}
```