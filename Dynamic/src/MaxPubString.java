/**
Description:<br>
最长公共子串问题实现类（动态规划法）：<br>
Time 2017/04/15
@author Mrzhou
@version 1.8.0_112
*/
import java.lang.StringBuffer;
public class MaxPubString{
  public static void main(String[] args) {
    String mainStr = "abcbdb";
    String modStr = "acbbabdbb";
    int result = getMaxPubLength(mainStr,modStr);
    System.out.println(result);
  }

  /**
  最长公共子序列：<br>

  @param mainStr 串一
  @param modStr 串二
  @return 最长公共子序列长度
  */
  public static int getMaxPubLength(String mainStr,String modStr){
    //获取两串的长度，用于创建二维数组
    int mainL = mainStr.length() + 1;
    int modL = modStr.length() + 1;
    //多出0行和0列，所以行列需要加一
    int[][] length = new int[mainL][modL];//存放最长公共子序列的长度
    int[][] path = new int[mainL][modL];//存放决策方向
    StringBuffer sb = new StringBuffer();//存放最长公共子序列
    //初始化
    for (int i = 0;i < mainL ;i++ ) {
      length[i][0] = 0;
      path[i][0] = 0;
    }
    for (int j = 0;j < modL ;j++ ) {
      length[0][j] = 0;
      path[0][j] = 0;
    }
    //动态规划求解
    for (int i = 1;i < mainL ;i++ ) {
      for (int j = 1;j < modL ;j++ ) {
        //求解子问题
        if (mainStr.charAt(i-1) == modStr.charAt(j-1)) {
          length[i][j] = length[i-1][j-1] + 1;
          path[i][j] = 1;
        }else if (path[i][j-1] >= path[i-1][j]) {
          length[i][j] = length[i][j-1];
          path[i][j] = 2;
        }else{
          length[i][j] = length[i-1][j];
          path[i][j] = 3;
        }
      }
    }
    int x = mainL - 1;
    int y = modL - 1;
    //根据查找规则查找结果
    while(x > 0 && y > 0){
      if (path[x][y] == 1) {
        sb.append(mainStr.charAt(x-1));
        x--;
        y--;
      }else if (path[x][y] == 2) {
        y--;
      }else {
        x--;
      }
    }
    //输出结果
    System.out.println(sb.reverse());
    return length[mainL-1][modL-1];
  }

}
