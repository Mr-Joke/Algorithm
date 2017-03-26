/**
Description:<br>
批处理作业调度问题实现类(回溯法):<br>
Time 2017/03/26
@author Mrzhou
@version 1.8.0_112
*/
import java.util.Scanner;
public class BatchJob{
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.print("请输入作业数量：");
    int n = in.nextInt();
    System.out.println("请输入 " + n + " 个作业在机器一上的处理时间:");
    int[] machineOne = initMachine(n,in);
    System.out.println("请输入 " + n + " 个作业在机器二上的处理时间:");
    int[] machineTwo = initMachine(n,in);
    System.out.print("请输入要求迟完成的时间：");
    int time = in.nextInt();
    int result = batchJobScheduling(n,machineOne,machineTwo,time);
    if(result == -1) System.out.println("在 " + time + " 的时间内无法完成批处理作业调度!");
    else System.out.println("批处理作业调度的最短时间是：" + result);
  }

  /**
  批处理作业调度：<br>

  @param n 任务个数
  @param machineOne　存储机器一完成各个任务所需时间的数组
  @param machineTwo 存储机器二完成各个任务所需时间的数组
  @param time 最迟完成时间
  @return 最短作业调度时间
  */
  public static int batchJobScheduling(int n,int[] machineOne,int[] machineTwo,int time){
    int[] result = new int[n+1];
    int[] sum1 = new int[n+1];
    int[] sum2 = new int[n+1];
    int bestTime = -1;
    for (int i = 1;i <= n ;i++ ) {
      result[i] = -1;
      sum1[i] = 0;
      sum2[i] = 0;
    }
    sum1[0]=sum2[0]=0;
    int index = 1;
    while(index >= 1){
      result[index] += 1;
      while(result[index] < n){
        int j;
        for (j = 1;j < index ;j++ ) {
          if(result[j] == result[index]) break;
        }
        //判断前面是否处理过当前任务
        if(j == index){
        /*1.判断加入当前任务后是否超过最短时间，若超过则考察下一个任务，否则可以
          2.判断前，首先要知道机器一加入当前任务后的完成时间与机器二完成上一个任务的时间谁先谁后
          3.选择较后的一个时间加上当前任务在机器二上完成的时间就等于当前任务的完成后的时间
        */
          sum1[index] = sum1[index-1] + machineOne[result[index]];//加入当前任务后，机器一总时间
          //判断机器一当前总时间与机器二完成上一个的总时间
          if(sum1[index] > sum2[index-1])
            sum2[index] = sum1[index] + machineTwo[result[index]];
          else
            sum2[index] = sum2[index-1] + machineTwo[result[index]];
          //判断加入当前任务时间与最短时间
          if(sum2[index] <= time) break;
          else result[index] += 1;//超过最短时间
        }
        else result[index] += 1;//当前作业已处理过
      }

      if(result[index] < n && index < n){
        //不是最后一个，但是满足筛选条件，则进入下一个任务
        index++;
      }else{
        //判断是否是最后一个任务，且最后一个任务满不满足条件
        if(result[index] < n && index == n){
          //最后一个任务，且满足
          if(time >= sum2[index]){
            time = sum2[index];
            bestTime = time;
            System.out.print("当前最短作业安排是：");
            for (int k = 1;k <= n ;k++ ) {
              System.out.print((result[k]+1) + " ");
            }
            System.out.println();
            System.out.println("最短时间是：" + time);
          }
        }
        //回溯(因为找到最短时间，现在找到的只是当前最短)
        result[index--] = -1;
      }
    }
    return bestTime;
  }

  /**
  输入各机器上完成任务的时间：<br>

  @param n 任务个数
  @param in 获取键盘输入的对象
  @return 存储各个任务完成时间的数组
  */
  public static int[] initMachine(int n,Scanner in){
    int[] machine = new int[n];
    for (int i = 0;i < n ;i++ ) {
      machine[i] = in.nextInt();
    }
    return machine;
  }
}
