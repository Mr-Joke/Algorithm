/**
Description:<br>
查找一个数是否是某个数组中两个数的和<br>
Time 2017/03/21 13:44
@author Mrzhou
@version 1.8.0_112
*/
/*
  注意：
  方法中QuickSort快速排序是我自己写的类，需要导入才能使用,sort.jar在当前目录中
  不使用IDE导入jar包编译运行的命令如下:
  javac -cp $JARPATH source.java
  java -cp $JARPATH: source

  例如：我的jar在/home/mrzhou/tool/jar/myown/sort.jar,需要编译运行本程序,则
  javac -cp /home/mrzhou/tool/jar/myown/sort.jar BothwaySearch.java
  java -cp /home/mrzhou/tool/jar/myown/sort.jar: BothwaySearch
  运行时，编写jar路径后面的:冒号不能丢，当然在windows系统下的话改成;分号
*/
import java.util.Scanner;
public class BothwaySearch{
  public static void main(String[] args) {
    int[] array = {21,30,1,5,88,14,52,23,109,7,99};
    Scanner in = new Scanner(System.in);
    int targetNum = in.nextInt();
    printTargetIndex(array,targetNum);
  }

  /**
  查找一个数组中是否有两个数的和等于目标数：<br>
  1.先将数组排序
  2.用两个油标分别从前向后、从后向前扫描,用startIndex、endIndex表示
  3.比较array[startIndex]+array[endIndex]与目标数targetNumber的大小
  4.如果目标数targetNumber大，则endIndex--，继续执行3
  5.如果目标数小，则startIndex++,继续执行3
  6.如果相等，则输出两个数
  7.如果不存在，则输出不存在

  @param array 待查找数组
  @param targetNum 目标数
  */
  public static void printTargetIndex(int[] array,int targetNum){
    QuickSort.quickSort(array,0,array.length-1);
    int startIndex = 0;
    int endIndex = array.length - 1;
    while(startIndex < endIndex){
      int sum = array[startIndex] + array[endIndex];
      if (sum > targetNum) {
        endIndex--;
      }else if (sum < targetNum) {
        startIndex++;
      }else{
        System.out.println("两个数分别是：" + array[startIndex] + "," + array[endIndex]);
        return;
      }
    }
    System.out.println("不存在两个数的和为：" + targetNum);
  }
}
