/**
Desription:<br>
求大公约数实现类<br>
Time 2017/03/10 <br>
@author Mrzhou
@version 1.8.0_112
*/
import java.util.Scanner;
public class CommFactor{
  /**
  求两个数的最大公约数(递归方式：公因子法)：<br>
  思路：<br>
  1.判断两个数的大小，取出较小的那个数
  2.判断较小的数是否等于1，若等于1，则返回1；
  3.用较大的数对较小的数求模，如果为0，则返回较小数。
  4.循环从2到较小的数的1/2处，判断每一个数是否同时可被两个目标数整除（取模为0）
  4.若可整除，将两个数除以该除数，继续对新的两个数求最大公约数。
  5.将此过程得到的除数相乘得出最大公约数

  @param num1 整数一
  @param num2 整数二
  @return 两个数的最大公约数
  */
  public static int getCommFactor1(int num1,int num2){
    int temp,minimun;
    if (num1 > num2) {
      minimun = num2;
      temp = num1 % num2;
    }else {
      minimun = num1;
      temp = num2 % num1;
    }
    if (minimun == 1) return 1;
    if (temp == 0) return minimun;
    int i = 2;
    while(i <= minimun / 2){
      if (num1 % i == 0 && num2 % i == 0) return i * getCommFactor1(num1/i,num2/i);
      i++;
    }
    return 1;
  }

  /**
  求两个数的最大公约数(公因子法)：<br>
  1.i从2循环到小于等于两个数结束
  2.判断i是否能同时被两个数整除，若能，则记录除数（将此前得到的除数乘以当前的除数），
    并且将两个被除数除以当前的除数(i)作为循环的结束标志,执行步骤2

  @param m 整数一
  @param n 整数二
  @return 两个整数的最大公约数
  */
  public static int getCommFactor2(int m,int n){
    int i,factor = 1;
    for (i = 2;i <= m && i <= n ;i++ ) {
      while(m % i == 0 && n % i == 0){
        factor = factor * i;
        m = m / i;
        n = n / i;
      }
    }
    return factor;
  }

  /**
  求最大公约数(辗转相除法)：<br>
  1.将两个数求模
  2.判断模是否为0，若为0，返回除数
  3.若不为0，则将除数赋值给原来的被除数，将模赋值给原来的除数，执行步骤1
  4.返回除数

  @param num1 整数一
  @param num2 整数二
  @return 两个数的最大公约数
  */
  public static int getCommFactor3(int num1,int num2){
    int mod = num1 % num2;
    while(mod != 0){
      num1 = num2;
      num2 = mod;
      mod = num1 % num2;
    }
    return num2;
  }
}
