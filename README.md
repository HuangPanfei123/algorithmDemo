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

###### 1.2买卖股票的最佳时机 II

给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。

在每一天，你可以决定是否购买和/或出售股票。你在任何时候 **最多** 只能持有 **一股** 股票。你也可以先购买，然后在 **同一天** 出售。

返回 你能获得的 **最大** 利润 。

 

**示例 1：**

```java
输入：prices = [7,1,5,3,6,4]
输出：7
解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
     总利润为 4 + 3 = 7 。
```

**示例 2：**

```java
输入：prices = [1,2,3,4,5]
输出：4
解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
     总利润为 4 。
```

**示例 3：**

```java
输入：prices = [7,6,4,3,1]
输出：0
解释：在这种情况下, 交易无法获得正利润，所以不参与交易可以获得最大利润，最大利润为 0 。
```

**提示：**

```java
1 <= prices.length <= 3 * 104
0 <= prices[i] <= 104
```

思路1：求区间最高度  后一天比前一天价格高则累加

代码如下：

```java
public class MaxProfitDemo {
    public static void main(String[] args) {
        int [] prices = {7,1,5,3,6,4};
        int maxProfit = maxProfit(prices);
        System.out.println(maxProfit);
    }
    public static int maxProfit(int [] prices){
        int max = 0;
        for (int i = 1 ; i<prices.length;i++){
            if(prices[i]-prices[i-1]>0){
                max+=prices[i]-prices[i-1];
            }
        }
        return max;
    }
}
```

思路2：动态规划 //TODO

###### 1.3旋转数组

给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。

**示例 1:**

```java
输入: nums = [1,2,3,4,5,6,7], k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右轮转 1 步: [7,1,2,3,4,5,6]
向右轮转 2 步: [6,7,1,2,3,4,5]
向右轮转 3 步: [5,6,7,1,2,3,4]
```

**示例 2:**

```java
输入：nums = [-1,-100,3,99], k = 2
输出：[3,99,-1,-100]
解释: 
向右轮转 1 步: [99,-1,-100,3]
向右轮转 2 步: [3,99,-1,-100]
```

**提示：**

```java
1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
0 <= k <= 105
```

参考思路：使用临时数组

可以使用一个临时数组，先把原数组的值存放到一个临时数组中，然后再把临时数组的值重新赋给原数组，重新赋值的时候要保证每个元素都要往后移k位，如果超过数组的长度就从头开始，所以这里可以使用(i + k) % length来计算重新赋值的元素下标

![image.png](https://pic.leetcode-cn.com/1610068849-iinvCs-image.png)

参考代码：

```java
public class RotateArrDemo {
    public static void main(String[] args) {
        int [] arr =  new int[]{1,2,3,4,5,6,7};
        int[] resultArr = rotateArr(arr, 3);
        for (int i = 0 ; i < resultArr.length ; i++){
            System.out.print(resultArr[i]+",");
        }
    }

    public static int [] rotateArr(int []  arr ,int  k){

        int len = arr.length;

        //创建一个临时数组
        int [] tempArr = new int[len];
        for (int i = 0 ; i < len ; i++){
            tempArr[i] = arr[i];
        }

        //然后在把临时数组的值重新放到原数组，并且往右移动k位
        for (int i = 0 ; i < len ; i++){
              arr[(i+k)%len] = tempArr[i];
        }

        return arr;
    }
}
```



###### 1.4存在重复元素

给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。

**示例 1：**

```
输入：nums = [1,2,3,1]
输出：true
```

**示例 2：**

```
输入：nums = [1,2,3,4]
输出：false
```

**示例 3：**

```
输入：nums = [1,1,1,3,3,4,3,2,4,2]
输出：true
```

**提示：**

```
1 <= nums.length <= 105
-109 <= nums[i] <= 109
```

**思路：排序后比较**

**实现代码：**

```java
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
```



###### 只出现一次的数字

给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。

**示例 1 ：**

```
输入：nums = [2,2,1]
输出：1
```

**示例 2 ：**

```
输入：nums = [4,1,2,1,2]
输出：4
```

**示例 3 ：**

```
输入：nums = [1]
输出：1
```

**提示**：

1 <= nums.length <= 3 * 104
-3 * 104 <= nums[i] <= 3 * 104
除了某个元素只出现一次以外，其余每个元素均出现两次。

**思路：异或运算**

**参考代码：**

```java
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
```



###### 1.11旋转图像 

![image-20230108224445978](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230108224445978.png)

**思路**

**先上下交**换，在对角线交换

![leet0048.png](https://pic.leetcode-cn.com/1615651665-WFwYuH-leet0048.png)

实现代码：

```java
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

#### 2.字符串

###### 2.1反转字符串

编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。

不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。

**示例 1：**

```java
输入：s = ["h","e","l","l","o"]
输出：["o","l","l","e","h"]
```

**示例 2：**

```java
输入：s = ["H","a","n","n","a","h"]
输出：["h","a","n","n","a","H"]
```

**提示：**

- `1 <= s.length <= 105`
- `s[i]` 都是 [ASCII](https://baike.baidu.com/item/ASCII) 码表中的可打印字符

**思路：**

使用双指针一个从第一个开始，一个从数组的最后一个开始，两两交换

代码实现：

```java
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
```



###### 2.2整数反转

给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。

如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。

**假设环境不允许存储 64 位整数（有符号或无符号）。**

**示例 1：**

```java
输入：x = 123
输出：321
```

**示例 2：**

```java
输入：x = -123
输出：-321
```

**示例 3：**

```java
输入：x = 120
输出：21
```

**示例 4：**

```java
输入：x = 0
输出：0
```

**参考思路：**

一位数一位数反转，使用 求余  乘10的方式 参考如下：

![image.png](https://pic.leetcode-cn.com/a161e3f0d41ad2866cb2bffe12084963b4e4c2e20086b71e377618d6b944fe4c-image.png)



参考代码：

```java
public class ReverseDemo {
    public static void main(String[] args) {


        int reverse = reverse(1230);
        System.out.println(reverse);

    }

    public static int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int t = x % 10;
            int newRes = res * 10 + t;
            //如果数字不相等则是溢出，直接返回0
            if ((newRes - t) / 10 != res) {
                return 0;
            }
            res = newRes;
            x = x / 10;
        }
        return res;
    }
    
}
```

###### 2.3字符串中的第一个唯一字符

给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。

**示例 1：**

```java
输入: s = "leetcode"
输出: 0
```

**示例 2:**

```java
输入: s = "loveleetcode"
输出: 2
```

**示例 3:**

```java
输入: s = "aabb"
输出: -1
```

**提示:**

```java
1 <= s.length <= 105
s 只包含小写字母
```

思路：

使用hasmap 存储每个字符出现的次数 再遍历遍历字符数组 ，数组中首先出现第一次的字符输出

代码实现：

```java
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
```



###### 2.4有效的字母异位词

给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。

 

**示例 1:**

```java
输入: s = "anagram", t = "nagaram"
输出: true
```

**示例 2:**

```java
输入: s = "rat", t = "car"
输出: false
```

**提示:**

```java
1 <= s.length, t.length <= 5 * 104
s 和 t 仅包含小写字母
```

参考思路：

计算两个字符串中字符的差值

- 先统计字符串s中每个字符的数量
- 减去t中每个字符对应的数量

如果最后结果都是0，说明t是s的字母异位词。

![image-20230110233703064](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230110233703064.png)



代码实现：

```java
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
```



###### 2.5验证回文串

如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。

字母和数字都属于字母数字字符。给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。

**示例 1：**

```java
输入: s = "A man, a plan, a canal: Panama"
输出：true
解释："amanaplanacanalpanama" 是回文串。
```

**示例 2：**

```java
输入：s = "race a car"
输出：false
解释："raceacar" 不是回文串。
```

**示例 3：**

```java
输入：s = " "
输出：true
解释：在移除非字母数字字符之后，s 是一个空字符串 "" 。
由于空字符串正着反着读都一样，所以是回文串。
```

**提示：**

- `1 <= s.length <= 2 * 105`
- `s` 仅由可打印的 ASCII 字符组成

**思路：**

使用双指针解决

![image.png](https://pic.leetcode-cn.com/4d9102ff750701d75d5ba25800498d67bb11b06444cc543670ced1aac00cf4d0-image.png)





**参考实现代码：**

```java
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
```

###### 2.55获取最长回文串

​	给你一个字符串 `s`，找到 `s` 中最长的回文子串。

如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。



**示例 1：**

```
输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。
```

**示例 2：**

```
输入：s = "cbbd"
输出："bb"
```

**提示：**

- `1 <= s.length <= 1000`
- `s` 仅由数字和英文字母组成

**参考思路：中心扩散法。**

中心扩散法怎么去找回文串？
从每一个位置出发，向两边扩散即可。遇到不是回文的时候结束。举个例子，str = acdbbdaastr=acdbbdaa 我们需要寻找从第一个 b（位置为 33）出发最长回文串为多少。怎么寻找？
首先往左寻找与当期位置相同的字符，直到遇到不相等为止。
然后往右寻找与当期位置相同的字符，直到遇到不相等为止。
最后左右双向扩散，直到左和右不相等。如下图所示：

![img](https://pic.leetcode-cn.com/2f205fcd0493818129e8d3604b2d84d94678fda7708c0e9831f192e21abb1f34.png)





每个位置向两边扩散都会出现一个窗口大小（len）。如果 len>maxLen(用来表示最长回文串的长度）。则更新 maxLen 的值。
因为我们最后要返回的是具体子串，而不是长度，因此，还需要记录一下 maxLen 时的起始位置（maxStart），即此时还要 maxStart=len。

代码实现：

```java
package com.jack.fly.primaryAlgorithm;

/**
 * @author:新晋菜鸡
 * @create: 2023-02-08 21:57
 * @Description: 最长回文串  中心扩散法
 */
public class LongestPalindrome1Demo {
    public static void main(String[] args) {
        String palindrome = longestPalindrome("babad");
        System.out.println(palindrome);



    }

    public static String  longestPalindrome(String str){

        if(str == null || str.length()==0){
            return  str;
        }
        int strLen = str.length();
        //记录回文的起点
        int left = 0;
        //记录回文的终点
        int right = 0;
        //记录每次获取的回文长度
        int len =1;
        //记录最大的回文长度
        int maxLen = 0;
        //记录截取的起点
        int maxStart = 0;
        for (int i = 0; i < strLen; i++) {
            left = i - 1;
            right = i + 1;
            //首先往左寻找与当期位置相同的字符，直到遇到不相等为止。
            while (left >= 0 && str.charAt(left) == str.charAt(i)) {
                len++;
                left--;
            }
            //然后往右寻找与当期位置相同的字符，直到遇到不相等为止。
            while (right < strLen && str.charAt(right) == str.charAt(i)) {
                len++;
                right++;
            }
            //最后左右双向扩散，直到左和右不相等
            while (left >= 0 && right < strLen && str.charAt(right) == str.charAt(left)) {
                len = len + 2;
                left--;
                right++;
            }
            if (len > maxLen) {
                maxLen = len;
                maxStart = left;
            }
            len = 1;
        }
        return str.substring(maxStart + 1, maxStart + maxLen + 1);

    }



}
```









###### 2.6.字符串转换整数 (atoi)

请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。

函数 myAtoi(string s) 的算法如下：

1.读入字符串并丢弃无用的前导空格
2.检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
3.读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
4.将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
返回整数作为最终结果。

注意：

本题中的空白字符只包括空格字符 ' ' 。
除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。

**示例 1：**

```java
输入：s = "42"
输出：42
解释：加粗的字符串为已经读入的字符，插入符号是当前读取的字符。
第 1 步："42"（当前没有读入字符，因为没有前导空格）
         ^
第 2 步："42"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
         ^
第 3 步："42"（读入 "42"）
           ^
解析得到整数 42 。
由于 "42" 在范围 [-231, 231 - 1] 内，最终结果为 42 。
```

**示例 2：**

```java
输入：s = "   -42"
输出：-42
解释：
第 1 步："   -42"（读入前导空格，但忽视掉）
            ^
第 2 步："   -42"（读入 '-' 字符，所以结果应该是负数）
             ^
第 3 步："   -42"（读入 "42"）
               ^
解析得到整数 -42 。
由于 "-42" 在范围 [-231, 231 - 1] 内，最终结果为 -42 。
```

**示例 3：**

```java
输入：s = "4193 with words"
输出：4193
解释：
第 1 步："4193 with words"（当前没有读入字符，因为没有前导空格）
         ^
第 2 步："4193 with words"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
         ^
第 3 步："4193 with words"（读入 "4193"；由于下一个字符不是一个数字，所以读入停止）
             ^
解析得到整数 4193 。
由于 "4193" 在范围 [-231, 231 - 1] 内，最终结果为 4193 。
```

**提示：**

```java
0 <= s.length <= 200
s 由英文字母（大写和小写）、数字（0-9）、' '、'+'、'-' 和 '.' 组成
```



**参考思路：**

**1.定义一个指针index 指向正在判断的字符**
**2.先把空格去掉index++**
**3.再判断是否有符号 index++ 并保留**
**4.遇到非数字直接return**
**5.先允许越界，越界后数据肯定和期望值不同，整除10后和原来的数比较即可，根据符号返回对应的最值**
**6.返回结果时，带上符号**



**实现代码：**

```java
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
```

###### 2.7实现 strStr()

给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。

**示例 1：**

```java
输入：haystack = "sadbutsad", needle = "sad"
输出：0
解释："sad" 在下标 0 和 6 处匹配。
第一个匹配项的下标是 0 ，所以返回 0 。
```

**示例 2：**

```java
输入：haystack = "leetcode", needle = "leeto"
输出：-1
解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
```

**提示：**

```java
1 <= haystack.length, needle.length <= 104
haystack 和 needle 仅由小写英文字符组成
```

**参考思路：**KMP算法

求出next数组

参考实现：

```java
public class KMPStrStrDemo {
public static void main(String[] args) {
    System.out.println(strStr("leetcode","leeto"));
  
}

// KMP 算法
// ss: 原串(string)  pp: 匹配串(pattern)
public static int strStr(String ss, String pp) {
    if (pp.isEmpty()) return 0;

    // 分别读取原串和匹配串的长度
    int n = ss.length(), m = pp.length();
    // 原串和匹配串前面都加空格，使其下标从 1 开始
    ss = " " + ss;
    pp = " " + pp;

    char[] s = ss.toCharArray();
    char[] p = pp.toCharArray();

    // 构建 next 数组，数组长度为匹配串的长度（next 数组是和匹配串相关的）
    int[] next = new int[m + 1];
    // 构造过程 i = 2，j = 0 开始，i 小于等于匹配串长度 【构造 i 从 2 开始】
    for (int i = 2, j = 0; i <= m; i++) {
        // 匹配不成功的话，j = next(j)
        while (j > 0 && p[i] != p[j + 1]) j = next[j];
        // 匹配成功的话，先让 j++
        if (p[i] == p[j + 1]) j++;
        // 更新 next[i]，结束本次循环，i++
        next[i] = j;
    }

    // 匹配过程，i = 1，j = 0 开始，i 小于等于原串长度 【匹配 i 从 1 开始】
    for (int i = 1, j = 0; i <= n; i++) {
        // 匹配不成功 j = next(j)
        while (j > 0 && s[i] != p[j + 1]) j = next[j];
        // 匹配成功的话，先让 j++，结束本次循环后 i++
        if (s[i] == p[j + 1]) j++;
        // 整一段匹配成功，直接返回下标
        if (j == m) return i - m;
    }

    return -1;
}
}
```

#### 3.链表(3.1-3.8题均为链表图文学中案例)

###### 3.1环形链表 I

给你一个链表的头节点 head ，判断链表中是否有环。

如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。

如果链表中存在环 ，则返回 true 。 否则，返回 false 。

**示例 1：**

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist.png)

```java
输入：head = [3,2,0,-4], pos = 1
输出：true
解释：链表中有一个环，其尾部连接到第二个节点。
```

**示例 2：**

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist_test2.png)

```
输入：head = [1,2], pos = 0
输出：true
解释：链表中有一个环，其尾部连接到第一个节点。
```

**示例 3：**![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist_test3.png)

```
输入：head = [1], pos = -1
输出：false
解释：链表中没有环。
```

**提示：**

- 链表中节点的数目范围是 `[0, 104]`
- `-105 <= Node.val <= 105`
- `pos` 为 `-1` 或者链表中的一个 **有效索引** 。



**思路：**快慢指针

**慢指针针每次走一步，快指针每次走两步**，如果相遇就说明有环，如果有一个为空说明没有环。代码比较简单

```java
/**
 * @author:新晋菜鸡
 * @create: 2023-01-28 22:17
 * @Description: 环形链表 I
 */
public class Solution {
    public static boolean hasCycle(ListNode head) {
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (fast.next!=null){
            fast =fast.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
             next = null;
     }
    }
}
```



###### 3.2环形链表 II

给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。

如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（**索引从 0 开始**）。如果 pos 是 -1，则在该链表中没有环。**注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。**

不允许修改 链表。

**示例 1：**![img](https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist.png)

```
输入：head = [3,2,0,-4], pos = 1
输出：返回索引为 1 的链表节点
解释：链表中有一个环，其尾部连接到第二个节点。
```

**示例 2：**![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist_test2.png)

```
输入：head = [1,2], pos = 0
输出：返回索引为 0 的链表节点
解释：链表中有一个环，其尾部连接到第一个节点。
```

**示例 3：**![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist_test3.png)

```
输入：head = [1], pos = -1
输出：返回 null
解释：链表中没有环。
```

**提示：**

- 链表中节点的数目范围在范围 `[0, 104]` 内
- `-105 <= Node.val <= 105`
- `pos` 的值为 `-1` 或者链表中的一个有效索引

**思路：快慢指针**

先判断有无环，再进行判断进去的节点

两种假设：

**1、假设环很大**

![image.png](https://pic.leetcode-cn.com/1602292232-mKjJWE-image.png)

假如他们在相遇点相遇了，那么慢指针走过的距离是a+b，快指针走过的距离就是a+b+c+b，因为相同时间内快指针走的距离是慢指针的2倍，所以有a+b+c+b = 2*(a+b)，整理得到a=c，**也就是说从相遇点到环的入口和链表的起始点到环的入口，距离是一样的**。在相遇点的时候我们可以使用两个指针，一个从相遇点开始，一个从链表头开始，他们每次都走一步，直到他们再次相遇位置，那么这个相遇点就是环的入口。

**2**、**环很小**![image.png](https://pic.leetcode-cn.com/1602293014-KzCeuw-image.png)

那么这种情况，快指针在环上转了好几圈了，慢指针才走到环上，假如快指针在环上已经走了`m`圈了，慢指针在环上走了`n`圈，

他们最终在环上相遇，那么

- **慢指针走过的距离是：a+b+n\*(b+c)** (`b+c`其实就是环的长度)
- **快指针走过的距离是：a+b+m\*(b+c)**

在相同的时间内快指针走过的距离是慢指针的`2`倍，所以有

- **a+b+m\*(b+c) = 2\*(a+b+n\*(b+c))**

整理得到

 **a+b=(m-2n)(b+c)，**

上面b+c其实是环的长度，也就是说a+b等于(m-2n)个环的长度，这个时候我们还可以使用两个指针一个从相遇点开始，一个从链表头开始，这时候就会出现一个现象就是一个指针在链表上走，一个指针在环上转圈，最终会走到第1种情况，就是环很小（我们可以认为链表前面减去m-2n-1个环的长度就是第一种情况了）

参考代码：

```java
/**
 * @author:新晋菜鸡
 * @create: 2023-01-30 21:45
 * @Description: 环形链表 II
 */
public class DetectCycleDemo {

    public ListNode detectCycle(ListNode head) {
        //快慢指针
        ListNode fast =  head;
        ListNode slow =  head;

        //判断是否有环
        while(fast!=null&&fast.next!= null){
            fast = fast.next.next;
            slow = slow.next;
            //判断是否有环
            if(fast==slow){
               while (head!=slow){
                   head = head.next;
                   slow =slow.next;
               }
                return  slow;
            }

        }

        return null;
    }
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
```

###### 3.3相交链表

给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。

图示两个链表在节点 c1 开始相交：

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/160_statement.png)

题目数据 保证 整个链式结构中不存在环。

注意，函数返回结果后，链表必须 保持其原始结构 。

自定义评测：

评测系统 的输入如下（你设计的程序 不适用 此输入）：

intersectVal - 相交的起始节点的值。如果不存在相交节点，这一值为 0
listA - 第一个链表
listB - 第二个链表
skipA - 在 listA 中（从头节点开始）跳到交叉节点的节点数
skipB - 在 listB 中（从头节点开始）跳到交叉节点的节点数
评测系统将根据这些输入创建链式数据结构，并将两个头节点 headA 和 headB 传递给你的程序。如果程序能够正确返回相交节点，那么你的解决方案将被 视作正确答案 。

**示例 1：**



![img](https://assets.leetcode.com/uploads/2021/03/05/160_example_1_1.png)

```
输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
输出：Intersected at '8'
解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,6,1,8,4,5]。
在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
— 请注意相交节点的值不为 1，因为在链表 A 和链表 B 之中值为 1 的节点 (A 中第二个节点和 B 中第三个节点) 是不同的节点。换句话说，它们在内存中指向两个不同的位置，而链表 A 和链表 B 中值为 8 的节点 (A 中第三个节点，B 中第四个节点) 在内存中指向相同的位置。
```

**示例 2：**

![image-20230130223735729](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230130223735729.png)

```
输入：intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
输出：Intersected at '2'
解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
从各自的表头开始算起，链表 A 为 [1,9,1,2,4]，链表 B 为 [3,2,4]。
在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。


```

**示例 3：**![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/160_example_3.png)

```
输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
输出：null
解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
这两个链表不相交，因此返回 null 。
```

**提示：**

listA 中节点数目为 m
listB 中节点数目为 n
1 <= m, n <= 3 * 104
1 <= Node.val <= 105
0 <= skipA <= m
0 <= skipB <= n
如果 listA 和 listB 没有交点，intersectVal 为 0
如果 listA 和 listB 有交点，intersectVal == listA[skipA] == listB[skipB]

**思路：双指针**

我们还可以使用两个指针，最开始的时候一个指向链表A，一个指向链表B，然后他们每次都要往后移动一位，顺便查看节点是否相等。如果链表A和链表B不相交，基本上没啥可说的，我们这里**假设链表A和链表B相交**。那么就会有两种情况，

- 一种是链表`A`的长度和链表`B`的长度相等，他们每次都走一步，最终在相交点肯定会相遇。
- 一种是链表`A`的长度和链表`B`的长度不相等，如下图所示

![image.png](https://pic.leetcode-cn.com/1602776172-sopScf-image.png)

虽然他们有交点，但他们的长度不一样，所以他们完美的错开了，即使把链表都走完了也找不到相交点。

我们仔细看下上面的图，如果A指针把链表A走完了，然后再从链表B开始走到相遇点就相当于把这两个链表的所有节点都走了一遍，同理**如果B指针把链表B走完了，然后再从链表A开始一直走到相遇点也相当于把这两个链表的所有节点都走完了**

所以如果A指针走到链表末尾，下一步就让他从链表B开始。同理如果B指针走到链表末尾，下一步就让他从链表A开始。只要这两个链表相交最终肯定会在相交点相遇，如果不相交，最终他们都会同时走到两个链表的末尾，我们来画个图看一下

![image.png](https://pic.leetcode-cn.com/1602776200-FJFAes-image.png)

![image.png](https://pic.leetcode-cn.com/1602776207-NyQrCj-image.png)

如上图所示，`A`指针和`B`指针如果一直走下去，那么他们最终会在相交点相遇，

参考代码：

```java
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //tempA和tempB我们可以认为是A,B两个指针
    ListNode tempA = headA;
    ListNode tempB = headB;
    while (tempA != tempB) {
        //如果指针tempA不为空，tempA就往后移一步。
        //如果指针tempA为空，就让指针tempA指向headB（注意这里是headB不是tempB）
        tempA = tempA == null ? headB : tempA.next;
        //指针tempB同上
        tempB = tempB == null ? headA : tempB.next;
    }
    //tempA要么是空，要么是两链表的交点
    return tempA;
}
```

###### 3.4删除链表的倒数第N个节点

给你一个链表，删除链表的倒数第 `n` 个结点，并且返回链表的头结点。

**示例 1：**![img](https://assets.leetcode.com/uploads/2020/10/03/remove_ex1.jpg)

```
输入：head = [1,2,3,4,5], n = 2
输出：[1,2,3,5]
```

**示例 2：**

```
输入：head = [1], n = 1
输出：[]
```

**示例 3：**

```
输入：head = [1,2], n = 1
输出：[1]
```

**提示：**

- 链表中结点的数目为 `sz`
- `1 <= sz <= 30`
- `0 <= Node.val <= 100`
- `1 <= n <= sz`

**参考思路：双指针求解**

上面是先计算链表的长度，其实不计算链表的长度也是可以，我们可以使用两个指针，一个指针fast先走n步，然后另一个指针slow从头结点开始，找到要删除结点的前一个结点，这样就可以完成结点的删除了

```java
public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode fast = head;
    ListNode slow = head;
    //fast移n步，
    for (int i = 0; i < n; i++) {
        fast = fast.next;
    }
    //如果fast为空，表示删除的是头结点
    if (fast == null)
        return head.next;

    while (fast.next != null) {
        fast = fast.next;
        slow = slow.next;
    }
    //这里最终slow不是倒数第n个节点，他是倒数第n+1个节点，
    //他的下一个结点是倒数第n个节点,所以删除的是他的下一个结点
    slow.next = slow.next.next;
    return head;
}
```
