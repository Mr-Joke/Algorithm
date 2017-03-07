public class G{
	public static void main(String[] args) {
		int count = 0;
		for (int a = 1;a < 10 ;a++ ) {
			for (int b = 1;b < 10 ;b++ ) {
				for (int c = 2;c < 10 ;c++ ) {
					for (int d = 2;d < 10 ;d++ ) {
						for (int e = 2;e < 10 ;e++ ) {
							for (int f = 2;f < 10 ;f++ ) {
								for (int g = 2;g < 10 ;g++ ) {
									for (int h = 2;h < 10 ;h++ ) {
										for (int i = 2;i < 10 ;i++ ) {											
											if (a!=b && a!=c && a!=d && a!=e && a!=f && a!=g && a!=h && a!=i) {		
												if (b!=c && b!=d && b!=e && b!=f && b!=g && b!=h && b!=i) {
													if (c!=d && c!=e && c!=f && c!=g && c!=h && c!=i) {
														if (d!=e && d!=f && d!=g && d!=h && d!=i) {
															if (e!=f && e!=g && e!=h && e!=i) {
																if (f!=g && f!=h && f!=i) {
																	if (g!=h && g!=i) {
																		if (h!=i) {
																			if (a < c && a < d && b < d && b < e && c < f && c < g && d < g && d <h && e < h && e < i) {
																				count++;
																				System.out.println("0");
																				System.out.println(a + " " + b);
																				System.out.println(c + " " + d +" " + e);
																				System.out.println(f + " " + g +" " + h + " " + i);
																				System.out.println();
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
		System.out.println(count);//resutl 768
	}
}