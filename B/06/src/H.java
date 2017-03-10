/*

牌型种数

小明被劫持到X赌城，被迫与其他3人玩牌。
一副扑克牌（去掉大小王牌，共52张），均匀发给4个人，每个人13张。
这时，小明脑子里突然冒出一个问题：
如果不考虑花色，只考虑点数，也不考虑自己得到的牌的先后顺序，自己手里能拿到的初始牌型组合一共有多少种呢？
*/
public class H{
  public static void main(String[] args) {
    long start = System.currentTimeMillis();
    int count = 0;
    for (int a = 0;a < 5 ;a++ )
      for (int b = 0;b < 5 ;b++ )
        for (int c = 0;c < 5 ;c++ )
          for (int d = 0;d < 5 ;d++ )
            for (int e = 0;e < 5 ;e++ )
              for (int f = 0;f < 5 ;f++ )
                for (int g = 0;g < 5 ;g++ )
                  for (int h = 0;h < 5 ;h++ )
                    for (int i = 0;i < 5 ;i++ )
                      for (int j = 0;j < 5 ;j++ )
                        for (int k = 0;k < 5 ;k++ )
                          for (int l = 0;l < 5 ;l++ )
                            for (int m = 0;m < 5 ;m++ ){
                              int total = a + b + c + d + e + f + g + h + i + j + k + l + m;
                              if(total == 13) count++;
                            }
    System.out.println(count);
    long end = System.currentTimeMillis();
    System.out.println(end - start + "ms");
  }
}
