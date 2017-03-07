public class B{
	public static void main(String[] args) {
		int sum = 0, total = 0;
		for (int i = 1;i <= 100 ;i++ ) {
			sum += i;
			total += sum;
		}
		System.out.println(total);//result 171700
	}
}