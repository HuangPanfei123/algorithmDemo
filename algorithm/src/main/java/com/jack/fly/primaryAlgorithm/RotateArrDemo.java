package com.jack.fly.primaryAlgorithm;

/**
 * @author:新晋菜鸡
 * @create: 2023-01-10 23:38
 * @Description: 旋转数组
 */
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
