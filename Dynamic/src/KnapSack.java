/**
Description:<br>
01背包问题实现类（动态规划法）：<br>
Time 2017/04/18
@author Mrzhou
@version 1.8.0_112
*/
public class KnapSack{
  public static void main(String[] args) {
    int[] weight = {2,2,6,5,4};
    int[] value = {6,3,5,4,6};
    int n = 5;
    int C = 10;
    int amount = 0;
    int[] result = knapSack(weight,value,n,C);//返回物品的选择集
    for (int i = 0;i < result.length ;i++ ) {
      amount += value[i] * result[i];//计算背包的总价值
      System.out.print(result[i] + " ");
    }
    System.out.println();
    System.out.println(amount);
  }

  /**
  01背包问题：<br>

  @param weight 物品的重量集
  @param value 物品的价值集
  @param n 物品的数量
  @param C 背包的容量
  @return 背包的选择结果集
  */
  public static int[] knapSack(int[] weight,int[] value,int n,int C){
    int[][] valueTable = new int[n+1][C+1];
    int[] result = new int[n];
    //初始子问题
    for (int i = 0;i <= n ;i++ ) {
      valueTable[i][0] = 0;//第0列，表示背包容量为0
    }
    for (int j = 0;j <= C ;j++ ) {
      valueTable[0][j] = 0;//第0行，表示背包没有放任何物品
    }
    //动态规划填表
    for (int x = 1;x <= n ;x++ ) {//x从1开始，而数组weight和value从0开始，所以下面weight[x-1],value[x-1]
      for (int y = 1;y <= C ;y++ ) {
        if (y < weight[x-1]) {//如果当前物品比当前背包容量大，表示放不进去
          valueTable[x][y] = valueTable[x-1][y];
        }else{//若能放进去，则比较放与不放的大小
          valueTable[x][y] = max(valueTable[x-1][y],valueTable[x-1][y-weight[x-1]] + value[x-1]);
        }
      }
    }
    //从表中得出结果
    for (int k=C,l=n;l > 0 ;l-- ) {
      if (valueTable[l][k] > valueTable[l-1][k]) {
        result[l-1] = 1;
        k-=weight[l-1];
      }else{
        result[l-1] = 0;
      }
    }
    //返回结果
    return result;
  }

  /**
  比较两个数的大小

  @param a 第一个数
  @param b 第二个数
  @return 返回两个数中的较大值
  */
  public static int max(int a,int b){
    return a>b?a:b;
  }
}
