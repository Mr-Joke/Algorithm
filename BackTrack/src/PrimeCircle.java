/**
Description:<br>
素环数实现类(回溯法)<br>
Time 2017/03/20<br>
@author Mrzhou
@version 1.8.0_112
*/
/*
问题描述：<br>
把整数{1,2..,20}填入到一个环中，要求每个整数只填写一次，并且相邻两个整数
之和是一个素数。例如，{1,2,3,4}就是一个素环数<br>
<br>
算法设计思路：<br>
这个素环数共有20个位置，每个位置可以填写的整数1~20,共有20种可能，约束条件
是：正在试探的数满足一下条件：<br>
1)与前面已填数字不相同<br>
2)与前一个数字求和的结果为素数<br>
3)最后一个素与第一个数的和为素数<br>
在填写到第k个位置时，如果数字满足以上条件，则继续填写第k+1个位置；如果1~20
都无法满足条件，则取消对k位置的填写，回溯到第k-1个位置。<br>
*/
import java.util.Scanner;
public class PrimeCircle{
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] result = getPrimeCircle(n);
    for (int i = 0;i < n ;i++ ) {
      System.out.print(result[i] + " ");
    }
    System.out.println();
  }

  /**
  素环数:<br>

  @param n 素环数的规模
  @return 返回素环数数组
  */
  public static int[] getPrimeCircle(int n){
    int[] array = init(n);//首先初始化全0，便于每趟从1开始
    int index = 1;
    array[0] = 1;//从一开始考察
    while(index < n){
      array[index] += 1;//先填进去
      while(array[index] <= n){
        if(isSatisfy(array,index)){
          //满足
          index++;
          break;
        }
        else array[index] += 1;//不满足，考察下一个
      }
      if(index == n) return array;//全都填完，返回结果
      if(array[index] > n){
        //当前考察的数超过范围（即当前位置没有符合的数），回溯
        array[index--] = 0;
      }
    }
    return null;
  }

  /**
  判断是否满足条件：<br>

  @param array 当前素环数数组
  @param index 当前考察的元素下标
  @return 是否满足
  */
  public static boolean isSatisfy(int[] array,int index){
    for (int i = 0;i < index ;i++ ) {
      if(array[i] == array[index]) return false;
    }
    if(!isPrime(array[index-1],array[index])) return false;
    return true;
  }

  /**
  判断当前元素与前一个元素之和是否为素数:<br>

  @param prev 前一个数
  @param current 当前数
  @return 是否为素数
  */
  public static boolean isPrime(int prev,int current){
    int sum = prev + current;
    int sqrt = (int)Math.sqrt(sum);
    for (int i = 2;i <= sqrt ;i++ ) {
      if(sum % i == 0) return false;
    }
    return true;
  }

  /**
  初始化数组:<br>

  @param n 素环数规模
  */
  public static int[] init(int n){
    int[] array = new int[n];
    for (int i = 0;i < n ;i++ ) {
      array[i] = 0;
    }
    return array;
  }
}
