package primaryAlgorithm;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * @author:新晋菜鸡
 * @create: 2023-01-08 22:34
 * @Description: 旋转图像
 */
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
