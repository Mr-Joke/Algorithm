/**
Description:<br>
折半查找实现类<br>
Time 2017/03/09 11:51<br>
@author Mrzhou
@version 1.8.0_112
*/
public class BinarySearch{

	/**
		二分查找：<br>
		1.将目标元素与待查找序列的中间元素比较，如果相等，则返回下标<br>
		2.比较起始下标与结束下标，如果相等，返回-1，即没有该元素（因为前面比较过元素不等了）<br>
		3.如果目标元素比和中间元素大，则对待查找序列后半部分执行二分查找（递归），
	  否则对前半部分执行二分查找<br>

		@param data 待查找序列
		@param targetNum 目标元素
		@param start 待查找序列起始位置
		@param end 待查找序列末尾位置
		@return 目标元素所在序列下标(不存在是返回-1)
	*/
	public static int binarySearch(int[] data,int targetNum,int start,int end){
		int mid = (start + end) / 2;
		if(targetNum == data[mid]) return mid;
		if(start >= mid) return -1;
		return targetNum > data[mid]?binarySearch(data,targetNum,mid,end):binarySearch(data,targetNum,start,mid);
	}
}
