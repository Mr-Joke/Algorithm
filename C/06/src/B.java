/*
立方尾不变
有些数字的立方的末尾正好是该数字本身。 比如：1,4,5,6,9,24,25,….
请你计算一下，在10000以内的数字中（指该数字，并非它立方后的数值），符合这个特征的正整数一共有多少个。
请提交该整数，不要填写任何多余的内容。
*/
public class B{
    public static void main(String[] args){
    	int count = 0;
	for(long i = 1;i < 10000;i++){
	    //立方后的结果
	    long trible = i * i * i;
	    //将原数字转换成字符串
	    String transferSrc = String.valueOf(i);
	    //将立方后的结果转换成字符串
	    String transfer = String.valueOf(trible);
	    //求出需要截取子串的起始下标
	    int index = transfer.length() - transferSrc.length();
	    //截取子串，比较是否与原数字相等
	    String result = transfer.substring(index);
	    if(result.equals(transferSrc))
		count++;
	}
	System.out.println(count);
    }
}
