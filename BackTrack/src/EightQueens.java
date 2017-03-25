/**
Desription:<br>
八皇后问题(回溯法)：<br>
Time 2017/03/25
@author Mrzhou
@version 1.8.0_112
*/
/*
问题描述：
八皇后问题是19世纪著名的数学家高斯于1850年提出的。问题是：在8*8的棋盘上
摆放八个皇后，使其不能互相攻击，即任意的两个皇后都不能处于同一行、同一列
或同一斜线上。可以把八皇后问题扩展到ｎ皇后问题，即n*n的棋盘上摆放n个皇后，
使任意两个皇后都不能处于同一行、同一列或同一斜线上。
*/
import java.util.Scanner;
public class EightQueens{
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] result = eightQueens(n);//获取n皇后的结果
    if(result == null) System.out.println("不存在 " + n + " 皇后问题");
    else{
      for (int i = 0;i < result.length ;i++ ) {
        System.out.println("第 " + (i+1) + " 个皇后在第 " + (i+1) + "　行第 " + result[i] + " 列");
      }
    }
  }

  /**
  n皇后问题:<br>

  @param n 皇后个数
  @return ｎ皇后的摆放位置数组
  */
  public static int[] eightQueens(int n){
    if(n <= 0) return null;
    int[] queens = initQueens(n);//初始化皇后摆放位置，全0
    int index = 1;
    queens[0] = 1;//默认第一个位置放第一个皇后
    if(n == 1) return queens;
    //开始搜索解空间
    while(index >= 0){
      queens[index] += 1;//下一个位置
      //考察皇后摆放是否冲突
      while(queens[index] <= n){
        if(check(queens,index)) break;//当前皇后无冲突
        else queens[index] += 1;//冲突，考察一下格位置
      }
      if(queens[index] <= n && index == n - 1) return queens;//皇后摆放完毕
      if(queens[index] <=n && index < n - 1) index++;//摆放下一个皇后
      else queens[index--] = 0;//当前行所有格子都冲突，回溯
    }
    //不存在n皇后问题
    return null;
  }

  /**
  考察皇后是否摆放冲突:<br>

  @param queens 记录皇后摆放位置的数组
  @param index 当前摆放的皇后索引
  @return 皇后摆放是否冲突
  */
  public static boolean check(int[] queens,int index){
    for (int i = 0;i < index ;i++ ) {
      if(queens[i] == queens[index]) return false;
      else{
        if(abs(i,index) == abs(queens[i],queens[index])) return false;
      }
    }
    return true;
  }

  /**
  两个数字之差的绝对值:<br>

  @param a 第一个数字
  @param b 第二个数字
  @return 两个数之差的绝对值
  */
  public static int abs(int a,int b){
    return a>b?a-b:b-a;
  }

  /**
  初始化皇后的摆放位置:<br>

  @param n 皇后个数
  @return 初始化皇后位置数组
  */
  public static int[] initQueens(int n){
    int[] queens = new int[n];
    for (int i = 0;i < n ;i++ ) {
      queens[i] = 0;
    }
    return queens;
  }
}
