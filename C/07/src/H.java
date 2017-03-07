import java.util.Scanner;
public class H{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] array = new int[1_000_000];
		int num = in.nextInt();
		array[0] = 1;
		for (int i = 1;i < num ;i++ ) {
			int result = getMaxNumber(i + 1);
			if (array[i-1] > result) {
				array[i] = array[i-1];
			}else {
				array[i] = result;
			}
		}
		System.out.println(array[num-1]);
	}

	public static int getMaxNumber(int num){
		int max = num;
		while(num != 1){
			if (num % 2 == 0) {
				num /= 2;
			}else {
				num = num * 3 + 1;
			}
			if (num > max) {
				max = num;
			}
		}
		return max;
	}
}