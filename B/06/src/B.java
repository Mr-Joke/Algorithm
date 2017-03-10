/*
立方变自身

观察下面的现象,某个数字的立方，按位累加仍然等于自身。
1^3 = 1
8^3  = 512    5+1+2=8
17^3 = 4913   4+9+1+3=17
...

请你计算包括1,8,17在内，符合这个性质的正整数一共有多少个？
*/

public class B{
	public static void main(String[] args){
		int count = 0;
		for(int i = 1;true;i++){
			int trible = i * i * i;
			String str = String.valueOf(trible);
			int value = 0;
			for(int j = 0;j < str.length();j++){
				int bitValue = str.charAt(j) - '0';
				value += bitValue;
			}
			if(value == i)
				System.out.println(++count);
		}
	}
}
