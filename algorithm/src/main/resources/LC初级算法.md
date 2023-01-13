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





















###### 1.11旋转图像 

![image-20230108224445978](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20230108224445978.png)

**思路**

**先上下交**换，在对角线交换

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









