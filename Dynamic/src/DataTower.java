/**
Description:<br>
数塔问题实现类(动态规划):<br>
Time 2017/03/27
@author Mrzhou
@version 1.8.0_112
*/
import java.util.Scanner;
public class DataTower{
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[][] tower = new int[n][];
    int[][] result = new int[n][];
    int[][] path = new int[n][];
    for (int i = 0;i < n ;i++ ) {
      tower[i] = new int[i+1];
      result[i] = new int[i+1];
      path[i] = new int[i+1];
      for (int j = 0;j <= i ;j++ ) {
        tower[i][j] = in.nextInt();//初始化数塔
      }
    }
    int maxValue = dataTower(tower,result,path,n);//动态规划求数塔问题
    System.out.println("数塔最大值和是：" + maxValue);
  }

  /**
  数塔问题：<br>

  @param tower 数塔
  @param result　保存数塔的最优解
  @param path 保存数塔最优解的路径
  @param n 数塔的层数
  @return 数塔的最优解
  */
  public static int dataTower(int[][] tower,int[][] result,int[][] path,int n){
    for (int i = 0;i < n ;i++ ) {
      result[n-1][i] = tower[n-1][i];//最后一排为的最优解为原始数据
    }
    for (int j = n - 2;j >= 0 ;j-- ) {
      for (int k = 0;k <= j ;k++ ) {
        //取得子问题的最优解,并且保存路径
        if(result[j+1][k] > result[j+1][k+1]){
          result[j][k] = tower[j][k] + result[j+1][k];
          path[j][k] = k;
        }else{
          result[j][k] = tower[j][k] + result[j+1][k+1];
          path[j][k] = k + 1;
        }
      }
    }
    //输出路径
    System.out.print("路径为：" + tower[0][0]);
    int index = path[0][0];
    for (int l = 1;l < n ;l++ ) {
      System.out.print(" " + tower[l][index]);
      index = path[l][index];
    }
    System.out.println();
    return result[0][0];
  }
}
