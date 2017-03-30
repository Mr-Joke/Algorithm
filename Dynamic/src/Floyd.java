/**
Description:<br>
多源点最短路径问题：<br>
Time 2017/03/30
@author Mrzhou
@version 1.8.0_112
*/
import java.util.Scanner;
public class Floyd{
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[][] graph = new int[n][n];
    int[][] dist = new int[n][n];
    //输入带权路径图
    for (int i = 0;i < n ;i++ ) {
      for (int j = 0;j < n ;j++ ) {
        graph[i][j] = in.nextInt();
      }
    }
    floyd(graph,dist,n);//进行动态规划求解问题
    //输出问题的结果
    for (int k = 0;k < n ;k++ ) {
      for (int l = 0;l < n ;l++ ) {
        System.out.print(dist[k][l] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  /**
  多源点最短路径问题：<br>

  @param graph 带权路径初始化后图
  @param dist 待填最短路径图
  @param n 结点个数
  */
  public static void floyd(int[][] graph,int[][] dist,int n){
    //未加入中间结点时，即初始化距离
    for (int i = 0;i < n ;i++ ) {
      for (int j = 0;j < n ;j++ ) {
        dist[i][j] = graph[i][j];
      }
    }
    //加入中间结点后，即子问题
    for (int x = 0;x < n ;x++ ) {
      for (int y = 0;y < n ;y++ ) {
        for (int z = 0;z < n ;z++ ) {
          int temp = dist[y][x] + dist[x][z];
          if (temp < dist[y][z])
            dist[y][z] = temp;
        }
      }
    }
  }
}
