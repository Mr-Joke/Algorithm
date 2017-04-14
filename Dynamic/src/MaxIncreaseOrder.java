/**
Description:<br>
最长递增子序列实现类（动态规划法）：<br>
Time 2017/04/14
@author Mrzhou
@version 1.8.0_112
*/
import java.util.Scanner;
public class MaxIncreaseOrder{
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();//n个元素
    int[] array = new int[n];
    for (int i = 0;i < n ;i++ ) {
      array[i] = in.nextInt();//初始化n个元素到数组中
    }
    int result = maxIncreaseOrder(array,n);//求最长递增子序列
    System.out.println(result);
  }

  /**
  最长递增子序列：<br>

  @param array 待求序列
  @param array 待求序列的元素个数
  @return 最长递增子序列的长度
  */
  public static int  maxIncreaseOrder(int[] array,int n){
    int[] length = new int[n];//存储0~i的元素的最长递增子序列的长度
    int[][] order = new int[n][n];//存储最长递增子序列
    //初始化
    for (int i = 0;i < n ;i++ ) {
      length[i] = 1;
      order[i][0] = array[i];
    }
    for (int x = 1;x < n ;x++ ) {
      int max = 1;
      for (int y = x - 1;y >= 0 ;y-- ) {
        //判断新加入的元素对之前的子问题的影响
        if (array[y] < array[x] && max < length[y] + 1) {
          //新加入的元素造成子序列最大时
          max = length[y] + 1;
          length[x] = max;
          for (int z = 0;z < max - 1 ;z++ ) {
            order[x][z] = order[y][z];
          }
          order[x][max-1] = array[x];
        }
      }
    }
    int maxLenghtIndex = 0;
    for (int j = 0;j < n ;j++ ) {
      if(length[maxLenghtIndex] < length[j]) maxLenghtIndex = j;//找到最长递增子序列的下标
    }
    for (int k = 0;k < length[maxLenghtIndex] ;k++ ) {
      System.out.print(order[maxLenghtIndex][k] + " ");//输出最长递增子序列
    }
    System.out.println();
    return length[maxLenghtIndex];
  }
}
