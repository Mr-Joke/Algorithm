/**
Description:<br>
多段图最短路径实现类(动态规划):<br>
Time 2017/03/29
@author Mrzhou
@version 1.8.0_112
*/
import java.util.Scanner;
public class MSGSPP{
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[][] graph = initGraph(n,in);
    int[][] graphValue = initGraph(n,in);
    int result = shortestPath(graph,graphValue,n);
    System.out.println(result);
  }

  /**
  多段图的最短路径问题：<br>

  @param graph 图的关系矩阵
  @param graphValue 图的路径值
  @param n 图的结点数
  @return 多段图的最短路径值
  */
  public static int shortestPath(int[][] graph,int[][] graphValue,int n){
    int[] minValue = new int[n];//存储从0结点到每个结点的最小值
    int[] path = new int[n];//最短路径的路径
    //初始化
    for (int i = 0;i < n ;i++ ) {
      minValue[i] = 0;
      path[i] = -1;
    }
    for (int j = 1;j < n ;j++ ) {
      for (int k = 0;k < j ;k++ ) {
        //判断上一个结点是否能到达当前结点
        if (graph[k][j] == 1) {
          //判断当前结点的最小值是否最小
          int temp = graphValue[k][j] + minValue[k];
          if(minValue[j] == 0) {
            minValue[j] = temp;
            path[j] = k;
          }
          else if (temp < minValue[j]) {
            maxValue[j] = temp;
            path[j] = k;
          }
        }
      }
    }
    //输出路径
    System.out.print(n-1);
    int pathValue = path[n-1];
    while(pathValue >= 0){
      System.out.print("<--" + pathValue);
      pathValue = path[pathValue];
    }
    System.out.println();
    return minValue[n-1];
  }

  /**
  初始化图：<br>

  @param n 图的结点个数
  @param in 键盘输入对象
  @return 含所填信息的图
  */
  public static int[][] initGraph(int n,Scanner in){
    int[][] graph = new int[n][n];
    for (int i = 0;i < n ;i++ ) {
      for (int j = 0;j < n ;j++ ) {
        graph[i][j] = in.nextInt();
      }
    }
    return graph;
  }
}
