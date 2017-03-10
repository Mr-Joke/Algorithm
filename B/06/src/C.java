/*
三羊献瑞

观察下面的加法算式：

      祥 瑞 生 辉
  +   三 羊 献 瑞
-------------------
   三 羊 生 瑞 气

(如果有对齐问题，可以参看【图1.jpg】)

其中，相同的汉字代表相同的数字，不同的汉字代表不同的数字。

请你填写“三羊献瑞”所代表的4位数字（答案唯一），不要填写任何多余内容。
*/

public class C{
	public static void main(String[] args){
		out:
		for(int a = 1;a < 10;a++)
			for(int b = 0;b < 10;b++)
				for(int c = 0;c < 10;c++)
					for(int d = 0;d < 10;d++)
						for(int e = 1;e < 10;e++)
							for(int f = 0;f < 10;f++)
								for(int g = 0;g < 10;g++)
									for(int h = 0;h < 10;h++)
										for(int i = 0;i < 10;i++){
											if(a!=b && a!=c && a!=d && a!=e && a!=f && a!=g && a!=h && a!=i)
												if(b!=c && b!=d && b!=e && b!=f && b!=g && b==h && b!=i)
													if(c!=d && c!=e && c!=f && c!=g && c!=h && c!=i)
														if(d!=e && d!=f && d!=g && d!=h && d!=i)
															if(e!=f && e!=g && e!=h && e!=i)
																if(f!=g && f!=h && f!=i)
																	if(g!=h && g!=i)
																		if(h!=i){
																			int num1 = a * 1000 + b * 100 + c * 10 + d;
																			int num2 = e * 1000 + f * 100 + g * 10 + h;
																			int result = e * 10000 + f * 1000 + c * 100 + b * 10 + i;
																			if(num1 + num2 == result){
																				System.out.println(" "+num1);
																				System.out.println("+"+num2);
																				System.out.println("-------");
																				System.out.println(result);
																				break out;
																			}
																		}
										}

	}
}
