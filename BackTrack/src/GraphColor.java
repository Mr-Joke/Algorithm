/**
Desription:<br>
图着色问题实现类:<br>
Time 2017/03/22
@author Mrzhou
@version 1.8.0_112
*/
/*
问题描述：
给定无向连通图G=(V,E)，求最小的整数m，用m种颜色对G中的顶点着色，
使得任意两个相邻顶点着色不同

输入：n个顶点的图G=(V,E)，m种颜色
输出：n个顶点的涂色情况color[n]
*/
import java.util.Scanner;
public class GraphColor{
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.print("输入图的结点数：");
    int n = in.nextInt();
    if(n <= 0){
      System.out.println("请认真对待本程序!!!");
      return;
    }
    System.out.print("输入图结点之间的关系，0表示不相邻，1表示相邻：");
    int[][] graph = new int[n][n];
    //初始化图
    for (int i = 0;i < n ;i++ ) {
      for (int j = 0;j < n ;j++ ) {
        graph[i][j] = in.nextInt();
      }
    }
    System.out.print("输入限制图多少种颜色:");
    int m = in.nextInt();
    int[] result = graphColor(graph,n,m);//获取图着色结果
    if(result == null) System.out.println(m + " 种颜色无法给 " + n + "个结点的图上色");
    else{
      for (int i = 0;i < n ;i++ ) {
        System.out.print(result[i] + " ");
      }
      System.out.println();
    }
  }

  /**
  图着色：<br>

  @param graph 待着色图
  @param n 图的结点数
  @param m 限制需要涂的颜色种数
  @return 满足时返回图着色的结果，否则返回空
  */
  public static int[] graphColor(int[][] graph,int n,int m){
    if(m <= 0) return null;
    int[] color = initColor(n);//初始化数组
    int index = 0;
    while(index >= 0){
      color[index] += 1;//填色
      while(color[index] <= m){
        //检验当前所涂颜色是否符合
        if(check(graph,color,index)) break;//符合
        else color[index] += 1;//考察下一种颜色
      }
      if(color[index] <=m && index == n-1) return color;
      if(color[index] > m) color[index--] = 0;//回溯
      else index++;//填下一个结点
    }
    return null;
  }

  /**
  检测当前考察结点的颜色是否符合要求：<br>

  @param graph 图
  @param color 图的每个结点的颜色组成的数组
  @param index 索引，用于考察当前结点的颜色是否符合
  @return 符合或者不符合
  */
  public static boolean check(int[][] graph,int[] color,int index){
    for (int i = 0;i < index ;i++ ) {
      //判断当前结点所图的颜色是否与前面重复
      if(graph[index][i] == 1 && color[i] == color[index]) return false;
    }
    return true;
  }

  /**
  初始化颜色数组：<br>

  @param n 结点的个数
  @return 初始化后的数组
  */
  public static int[] initColor(int n){
    int[] color = new int[n];
    for (int i = 0;i < n ;i++ ) {
      color[i] = 0;
    }
    return color;
  }
}
