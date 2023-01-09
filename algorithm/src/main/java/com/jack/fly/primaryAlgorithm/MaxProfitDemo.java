package com.jack.fly.primaryAlgorithm;

/**
 * @author:新晋菜鸡
 * @create: 2023-01-09 22:51
 * @Description: 买卖股票的最佳时机 II
 */
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
