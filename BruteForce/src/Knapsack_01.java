/**
Desription:<br>
０１背包问题实现类(蛮力法)<br>
Time 2017/03/19 14:24<br>
@author Mrzhou
@version 1.8.0_112
*/
public class Knapsack_01{
  public static void main(String[] args) {
    int[] weight = {7,3,4,5};
    int[] values = {42,12,40,25};
    int C = 10;
    //求出０１背包最大价值的结果集
    int[] result = getMaxValueSet(weight,values,C);
    for (int i = 0;i < result.length ;i++ ) {
      System.out.print(result[i] + " ");
    }
    System.out.println();
  }

  /**
  01背包:<br>
  1.首先求出所有可能的结果集<br>
  2.求出每一个结果集的容量与其对应的价值<br>
  3.挑出符合容量且价值最大的结果集

  @param weight 物品的重量集
  @param values 物品的单价(价值集)
  @param C　背包的容量
  @return 背包的最大价值
  */
  public static int[] getMaxValueSet(int[] weight,int[] values,int C){
    int row = (int)Math.pow(2,weight.length);
    int col = weight.length;
    int[][] resultSet = new int[row][col];//创建所有可能的结果集
    int v = 0;//背包价值
    int index=0;//最大价值所在的子集下标
    //初始化结果集
    int temp;
    for (int i = 0;i < row ;i++ ) {
      temp = i;
      //将下面多行注释部分合并到这里，直接在初始化时求出每个子集的价值
      int tempW = 0;
      int tempV = 0;
      for (int j = 0;j < col ;j++ ) {
        resultSet[i][j] = temp % 2;//初始化
        tempW += resultSet[i][j] * weight[j];//求子集的容量
        tempV += resultSet[i][j] * values[j];//求子集的价值
        temp /= 2;
      }
      //满足背包小于容量C的
      if (tempW <= C) {
        if (tempV > v) {
          v = tempV;
          index = i;//记录最大容量所在的子集下标
        }
      }
    }
    /*
    ******以下步骤可以合并到初始化的时候做，因为for循环是一样的****************

    //找出最大价值所在的子集下标
    for (int x = 0;x < row ;x++ ) {
      int tempW = 0;
      int tempV = 0;
      //算出每个子集的价值与容量
      for (int y = 0;y < col ;y++ ) {
        tempW += resultSet[x][y] * weight[y];
        tempV += resultSet[x][y] * values[y];
      }
      //满足背包小于容量C的
      if (tempW <= C) {
        if (tempV > v) {
          v = tempV;
          index = x;//记录最大容量所在的子集下标
        }
      }
    }
    */
    return resultSet[index];
  }
}
