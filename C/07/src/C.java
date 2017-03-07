/**

平方怪圈

如果把一个正整数的每一位都平方后再求和，得到一个新的正整数。
对新产生的正整数再做同样的处理。

如此一来，你会发现，不管开始取的是什么数字，
最终如果不是落入1，就是落入同一个循环圈。

请写出这个循环圈中最大的那个数字。

请填写该最大数字。
注意：你提交的应该是一个整数，不要填写任何多余的内容或说明性文字。


*/

import java.util.Scanner;
public class C{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String num = in.nextLine();
		for (int i = 0;i < 100 ;i++ ) {
			int temp = 0;
			for (int j = 0;j < num.length()  ;j++ ) {
				int bitNum = num.charAt(j) - '0';
				temp += bitNum * bitNum;
			}
			System.out.println(temp);
			num = String.valueOf(temp);//result 145
		}
	}
}