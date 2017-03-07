/**

分小组

9名运动员参加比赛，需要分3组进行预赛。
有哪些分组的方案呢？

我们标记运动员为 A,B,C,... I
下面的程序列出了所有的分组方法。

该程序的正常输出为：
ABC DEF GHI
ABC DEG FHI
ABC DEH FGI
ABC DEI FGH
ABC DFG EHI
ABC DFH EGI
ABC DFI EGH
ABC DGH EFI
ABC DGI EFH
ABC DHI EFG
ABC EFG DHI
ABC EFH DGI
ABC EFI DGH
ABC EGH DFI
ABC EGI DFH
ABC EHI DFG
ABC FGH DEI
ABC FGI DEH
ABC FHI DEG
ABC GHI DEF
ABD CEF GHI
ABD CEG FHI
ABD CEH FGI
ABD CEI FGH
ABD CFG EHI
ABD CFH EGI
ABD CFI EGH
ABD CGH EFI
ABD CGI EFH
ABD CHI EFG
ABD EFG CHI
..... (以下省略，总共560行)。

*/

public class E
{
	public static String remain(int[] a)
	{
		String s = "";
		for(int i=0; i<a.length; i++){
			if(a[i] == 0) s += (char)(i+'A');
		}	
		return s;
	}
	
	public static void f(String s, int[] a)
	{
		for(int i=0; i<a.length; i++){
			if(a[i]==1) continue;
			a[i] = 1;
			for(int j=i+1; j<a.length; j++){
				if(a[j]==1) continue;
				a[j]=1;
				for(int k=j+1; k<a.length; k++){
					if(a[k]==1) continue;
					a[k]=1;
					System.out.println(s + " " + (char)('A' + i) + (char)('A' + j) + (char)('A' + k) + " " + remain(a));  //填空位置
					a[k]=0;
				}
				a[j]=0;
			}
			a[i] = 0;
		}
	}
	
	public static void main(String[] args)
	{
		int[] a = new int[9];		
		a[0] = 1;
		
		for(int b=1; b<a.length; b++){
			a[b] = 1;
			for(int c=b+1; c<a.length; c++){
				a[c] = 1;
				String s = "A" + (char)(b+'A') + (char)(c+'A');
				f(s,a);
				a[c] = 0;
			}
			a[b] = 0;
		}
	}
}
/*
process step:

1.a 100 000 000
2.a 110 000 000 b=1
3.a 111 000 000 b =1 c=2
4.s ABC
5.f(s,a)----> *




*
1.a 111 100 000 i=3
2.a 111 110 000 i=3 j=4
3.a 111 111 000 i=3 j=4 k=5
4.----> **
5.sout ABC DEF GHI
6.a 111 110 000 i=3 j=4 k=5
7.a 111 110 100 i=3 j=4 k=6
8.----> ***
9.sout ABC DEG FHI



**
1.a 111 111 000 s=""
2.a 111 111 000 s="" i=0
3.a 111 111 000 s="" i=1
...
8.a 111 111 000 s=G i=6
9.a 111 111 000 s=GH i=7
10.a 111 111 000 s=GHI i=8
11.return s

***
1.a 111 110 100 s=""
2.a 111 110 100 s="" i=0
3.a 111 110 100 s="" i=1
..
7.a 111 110 100 s=F i=5
8.a 111 110 100 s=F i=6
9.a 111 110 100 s=FH i=7
10.a 111 110 100 s=FHI i=8
11.return s

*/