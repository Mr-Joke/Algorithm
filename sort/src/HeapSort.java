/**
Description:<br>
堆排序实现类<br>
Time 2017/03/07 11:11
@author Mrzhou
@version 1.7.0_71
*/

public class HeapSort{
	/**
	堆排序：<br>
	1.对待排序数组进行筛选，形成大根堆<br>
	2.将大根堆堆顶元素与堆底元素交换<br>
	3.堆底下标减一<br>
	4.重复执行以上步骤，直到大根堆全变成有序序列<br>
	
	@param array 待排序数组
	@param top 堆顶下标
	@param bottom 堆底下标
	*/
	public static void heapSort(int[] array,int top,int bottom){
		int temp;
		int heapBottom = bottom;
		//将待排序数组调整成大根堆
		for(int i = bottom;i >= top;i--){
			siftSort(array,i,bottom);
		}
		do{
			//交换堆顶堆底元素
			temp = array[top];
			array[top] = array[heapBottom];
			array[heapBottom] = temp;
			//堆底下标减一
			heapBottom--;
			//此时大根堆已乱，重新筛选
			siftSort(array,top,heapBottom);
		}while(heapBottom > top);
	}
	
	/**
	大根堆筛选：<br>
	1.判断以当前根的子树是否为大根堆<br>
	2.判断大根堆的方式：<br>
		1)判断当前元素是否存在子元素，若不存在，则已是大根堆<br>
		2)若存在子元素，则判断是否有右孩子<br>
			I.若无右孩子，则判断左孩子是否比根大<br>
				i.若比根大，则交换，将左孩子当作新的根，执行步骤1；否则已是大根堆，终止循环<br>
			II.若有右孩子，则判断左右孩子谁大，将较大者与根比较，若根大，则已是大根堆，终止循环<br>
			   否则交换根与较大的子元素，将该子元素当作根，执行步骤1；<br>
	
	@param array 待筛选数组
	@param top 子树的根下标
	@param bottom 待筛选数组最后一个元素下标
	*/
	public static void siftSort(int[] array,int top,int bottom){
		int temp;	
		int root = top;
		int leftSon = 2 * root + 1;
		int rightSon = leftSon + 1;
		while(!(leftSon > bottom)){
			//存在孩子节点
			if(rightSon > bottom){
				//不存在右孩子节点
				if(array[root] < array[leftSon]){
					//根比左孩子小
					temp = array[root];
					array[root] = array[leftSon];
					array[leftSon] = temp;
				}
				break;
			}else{
				//存在右孩子节点
				if(array[leftSon] > array[rightSon]){
					//左孩子较大
					if(array[root] < array[leftSon]){
						//根比左孩子小
						temp = array[root];
						array[root] = array[leftSon];
						array[leftSon] = temp;
						root = leftSon;
						leftSon = 2 * root + 1;
						rightSon = leftSon + 1;
					}else{
						break;
					}	
				}else{
					//右孩子较大
					if(array[root] < array[rightSon]){
						//根比右孩子小
						temp = array[root];
						array[root] = array[rightSon];
						array[rightSon] = temp;
						root = rightSon;
						leftSon = 2 * root + 1;
						rightSon = leftSon + 1;
					}else{
						break;
					}
				}
			}
		}
	}
}