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
    int[] path = new int[n-1];
    for (int i = 0;i < n ;i++ ) {
      tower[i] = new int[i+1];
      result[i] = new int[i+1];
      for (int j = 0;j <= i ;j++ ) {
        tower[i][j] = in.nextInt();
      }
    }
    int maxValue = dataTower(tower,result,path,n);
    System.out.println(maxValue);
  }

  /***/
  public static int dataTower(int[][] tower,int[][] result,int[] path,int n){
    for (int i = 0;i < n ;i++ ) {
      result[n-1][i] = tower[n-1][i];//最后一排为的最优解为原始数据
    }
    for (int j = n - 2;j >= 0 ;j-- ) {
      for (int k = 0;k <= j ;k++ ) {
        //取得自问题的最优解,并且保存路径
        if(result[j+1][k] > result[j+1][k+1]){
          result[j][k] = tower[j][k] + result[j+1][k];
          path[j] = k;
        }else{
          result[j][k] = tower[j][k] + result[j+1][k+1];
          path[j] = k + 1;
        }
      }
    }
    //输出路径
    System.out.print("路径为：" + tower[0][0]);
    for (int l = 1;l < n ;l++ ) {
      System.out.print(" " + tower[l][path[l-1]]);
    }
    System.out.println();
    return result[0][0];
  }
}
