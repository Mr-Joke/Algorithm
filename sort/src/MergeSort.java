/**
Desciption:
<br> 归并排序实现类
<br> @Time 2017/03/05 19:17:32
@author Mrzhou
@version 1.8.0_112
*/
public class MergeSort{
  /**
  归并排序:<br>
  1.将待排序序列划分为两个规模小的子序列<br>
  2.求解子问题1，即对前一个子序列进行归并排序<br>
  3.求解子问题2，即对后一个子序列进行归并排序<br>
  4.子问题结果合并，即合并两个字序列<br>
  5.将排序好的数组序列回填<br>

  @param data 待排序数组
  @param start 待排序的起始位置（数组下标）
  @param end 待排序的末尾位置（数组下标）
  */
  public static void mergeSort(int[] data,int start,int end){
    //当起始位置等于末尾位置，即只有一个元素，有序
    if (start >= end) return;
    //创建新数组，用于存放每趟归并排序的结果
    int[] array = new int[data.length];
    //中间位置
    int mid = (start + end) / 2;
    //对左边子序列求归并排序
    mergeSort(data,start,mid);
    //对右边子序列求归并排序
    mergeSort(data,mid+1,end);
    //合并子序列
    merge(data,array,start,mid,end);
    //回填
    for (int i = start;i <= end ;i++ ) {
      data[i] = array[i];
    }
  }

  /**
  合并：<br>
  1.将前一个子序列的首元素与后一个子序列的首元素比较，将较小的元素填入数组{@code array}中，
  较小数组所在的子序列的下标索引++，然后数组{@code array}++；<br>
  2.循环执行以上步骤，直到其中一个子序列遍历完。<br>
  3.处理划分不平衡的情况，即前后子序列的长度不同<br>

  @param data 待排序数组
  @param array 存储合并后元素的数组
  @param start 子序列的起始位置
  @param mid 子序列的中间位置
  @param end 子序列的末尾位置
  */
  public static void merge(int[] data,int[] array,int start,int mid,int end){
    int low = start;
    int center = mid+1;
    int index = start;

    //循环遍历两个子序列
    while(low <= mid && center <= end){
      //取较小着存入array数组
      if (data[low] < data[center]) {
        array[index++] = data[low++];
      }else {
        array[index++] = data[center++];
      }
    }
    //处理特殊情况，即两个子序列长度不等
    //前一个子序列长时
    while(low <= mid){
      array[index++] = data[low++];
    }
    //后一个子序列长时
    while(center <= end){
      array[index++] = data[center++];
    }
  }
}
