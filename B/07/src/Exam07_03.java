/**

凑算式

     B      DEF
A + --- + ------- = 10
     C      GHI

（如果显示有问题，可以参见【图1.jpg】）


这个算式中A~I代表1~9的数字，不同的字母代表不同的数字。

比如：
6+8/3+952/714 就是一种解法，
5+3/1+972/486 是另一种解法。

这个算式一共有多少种解法？

注意：你提交应该是个整数，不要填写任何多余的内容或说明性文字。

*/

public class Exam07_03{
  public static void main(String[] args) {
    int result = Exam07_03.getCount();
    System.out.println(result);
  }

  public static int getCount(){
    int count = 0;
    for (int a = 1;a < 10 ;a++ ) {
      for (int b = 1;b < 10 ;b++ ) {
        for (int c = 1;c < 10 ;c++ ) {
          for (int d = 1;d < 10 ;d++ ) {
            for (int e = 1;e < 10 ;e++ ) {
              for (int f = 1;f < 10 ;f++ ) {
                for (int g = 1; g < 10 ;g++ ) {
                  for (int h = 1;h < 10 ;h++ ) {
                    for (int i = 1;i < 10 ;i++ ) {
                      if (a!=b && a!=c && a!=d && a!=e && a!=f && a!=g && a!=h && a!=i) {
                        if (b!=c && b!=d && b!=e && b!=f && b!=g && b!=h && b!=i) {
                          if (c!=d && c!=e && c!=f && c!=g && c!=h && c!=i) {
                            if (d!=e && d!=f && d!=g && d!=h && d!=i) {
                              if (e!=f && e!=g && e!=h && e!=i) {
                                if (f!=g && f!=h && f!=i) {
                                  if (g!=h && g!=i) {
                                    if (h!=i) {
                                      int def = d * 100 + e * 10 + f;
                                      int ghi = g * 100 + h * 10 + i;
                                      int temp1 = b * ghi;
                                      int temp2 = c * def;
                                      int temp3 = c * ghi;
                                      if ((temp1 + temp2) % temp3 == 0 && a + (temp1 + temp2)/temp3 == 10) {
                                        System.out.println("a:" + a + "  b:" + b + "  c:"+ c + "  def:" + def + "  ghi:" +ghi);
                                        count++;
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return count;
  }
}
