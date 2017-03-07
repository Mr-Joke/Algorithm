/**

有奖猜谜

小明很喜欢猜谜语。
最近，他被邀请参加了X星球的猜谜活动。

每位选手开始的时候都被发给777个电子币。
规则是：猜对了，手里的电子币数目翻倍，
猜错了，扣除555个电子币, 扣完为止。

小明一共猜了15条谜语。
战果为：vxvxvxvxvxvxvvx
其中v表示猜对了，x表示猜错了。

请你计算一下，小明最后手里的电子币数目是多少。

请填写表示最后电子币数目的数字。
注意：你提交的应该是一个整数，不要填写任何多余的内容或说明性文字。


*/
public class A{
	public static void main(String[] args) {
		int init = 777;
		for (int i = 1;i < 13 ;i++ ) {
			if (i % 2 == 1) {
				init *= 2;
			}else {
				init -= 555;
			}
		}
		init *= 4;
		init -= 555;
		System.out.println(init);//result 58497
	}
}