/*
三角形面积

如【图1】所示。图中的所有小方格面积都是1。
那么，图中的三角形面积应该是多少呢？
*/
public class A{
	public static void main(String[] args){
		final int LENGTH = 8;
		final int HEIGHT = 8;
		int totalArea = LENGTH * HEIGHT;
		int result = totalArea - (4 * HEIGHT + 4 * (HEIGHT - 2) + 2 * LENGTH) / 2;
		System.out.println(result);
	}
}
