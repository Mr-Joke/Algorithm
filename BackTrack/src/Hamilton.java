/**
Desription:<br>
哈密顿回路问题实现类(回溯法)<br>
Time 2017/03/24
@author Mrzhou
@version 1.8.0_112
*/
/*
问题：
爱尔兰数学家哈密顿提出了著名的周游世界的问题。设正面体20个顶点代表20个城市，
哈密顿回路问题要求从一个城市出发，经过每一个城市恰好一次，然后回到该城市。

输入：
  一个含ｎ个结点的无向图(n个城市)
输出：
  路过城市的路径

解题步骤跟图着色差不多，关键点在于如何判断城市是否满足要求，这里不同。
*/
import java.util.Scanner;
public class Hamilton{
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.print("请输入城市的个数：");
    int n = in.nextInt();
    if(n <= 0){
      System.out.println("请认真对待本程序!!!");
      return;
    }
    System.out.println("请输入 " + n + " 个城市的路径图：");
    int[][] graph = new int[n][n];
    for (int i = 0;i < n ;i++ ) {
      for (int j = 0;j < n ;j++ ) {
        graph[i][j] = in.nextInt();
      }
    }
    int[] result = hamilton(graph,n);
    if(result == null) System.out.println("不存在哈密顿回路");
    else{
      for (int k = 0;k < result.length;k++ ) {
        System.out.print(result[k] + " ");
      }
      System.out.println();
    }
  }

  /**
  哈密顿回路：<br>

  @param graph 含城市信息的图
  @param n 城市个数
  @return 经过的城市信息
  */
  public static int[] hamilton(int[][] graph,int n){
    int[] track = initTrack(n);//初始化路径
    int index = 1;
    track[0] = 1;//默认从1城市开始
    if(n == 1) return track;
    while(index > 0){
      track[index] += 1;//搜索城市（解空间）
      while(track[index] <= n){
        if(check(graph,track,index)) break;//检查下一个城市是否可达
        else track[index] += 1;//继续考察下一个城市
      }
      //当最后一个城市能回到最初的城市，表示成功，返回
      if(index == n - 1 && track[index] <= n) return track;
      if(track[index] <= n && index < n - 1) index++;//前往下一个
      else track[index--] = 0;//回溯
    }
    return null;
  }

  /**
  考察下一个城市是否可达<br>

  @param graph 含城市信息的图
  @param track 含已经过城市信息的数组
  @param index 待考察城市所在数组下标
  @return 城市是否可达
  */
  public static boolean check(int[][] graph,int[] track,int index){
    int firstCity = track[0];//第一个城市
    int curCity = track[index - 1];//当前城市
    int nextCity = track[index];//待考察城市
    for (int i = 0;i < index ;i++ ) {
      if(nextCity == track[i]) return false;//待考察城市是否已经路过
    }
    //判断待考察城市是否可达
    if(graph[curCity - 1][nextCity - 1] == 1){
      //判断是否为最后一个城市
      if (index == track.length - 1) {
        //判断最后一个城市是否能回到第一个城市
        if(graph[nextCity - 1][firstCity - 1] == 0) return false;
      }
      return true;
    }
    //待考察城市不可达
    return false;
  }

  /**
  初始化途经城市<br>

  @param n 城市个数
  @return 全0，一开始没有去任何城市
  */
  public static int[] initTrack(int n){
    int[] track = new int[n];
    for (int i = 0;i < n ;i++ ) {
      track[i] = 0;
    }
    return track;
  }
}
