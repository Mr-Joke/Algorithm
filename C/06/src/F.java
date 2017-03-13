/*
奇妙的数字

小明发现了一个奇妙的数字。它的平方和立方正好把0~9的10个数字每个用且只用了一次。
你能猜出这个数字是多少吗？69

*/
public class F{
    /*
    思路：
    １．循环从１开始，判断每个数字的平方和立方后的数的长度加起来是否等于10
    ２．若长度等于10，则将这两个数拼接起来，组成一个字符串
    ３．拼接起来的字符串的每一个字母是否个各不相同，若是，则输出
    */
    public static void main(String[] args){
    	for(int i = 1;i < 200;i++){
        int square = i * i;
        int cubic = i * i * i;
        //将平方和立方后的数字转化成字符串
        String squareStr = String.valueOf(square);
        String cubicStr = String.valueOf(cubic);
        //判断两个字符串的长度加起来是否等于10
        if (squareStr.length() + cubicStr.length() == 10) {
          //将两个字符串拼接成一个，便于比较每一个字符是否相等
          String newStr = squareStr + cubicStr;
          //定义flag标志用于跳出最外层循环
          boolean flag = true;
          int j;
          //j定义在外层，用于判断是否循环能够执行到最后，如果能执行到最后，表示没有相同的字符
          for (j = 0;j < newStr.length() && flag ;j++ ) {
            for (int k = j + 1;k < newStr.length() && flag ;k++ ) {
              char ch1 = newStr.charAt(j);
              char ch2 = newStr.charAt(k);
              //当判断到一个字符相等，则表示不符合，直接结束本轮判断，跳出最外层循环
              if (ch1 == ch2) {
                flag = false;
                break;
              }
            }
          }
          if (j == newStr.length()) {
            System.out.println(i);
            break;
          }
        }
	    }
    }
}
