/**
Description:<br>
快速排序实现类<br>
Time 2017/03/06 20:20<br>
@author Mrzhou
@version 1.8.0_112
*/
public class QuickSort{

  /**
  快速排序<br>
  1.判断起始位置与结束位置是否相等，相等直接return<br>
  2.确定每一趟的轴值<br>
  3.对轴值的左边进行快速排序<br>
  4.对轴值的右边进行快速排序<br>

  @param data 待排序数组
  @param start 起始位置(数组下标)
  @param end 结束位置(数组下标)
  */
  public static void quickSort(int[] data,int start,int end){
    if(start >= end) return;
    int axisValueIndex = getAxisValueIndex(data,start,end);
    if(axisValueIndex > start)
      quickSort(data,start,axisValueIndex-1);
    if(axisValueIndex < end)
      quickSort(data,axisValueIndex+1,end);
  }

  /**
  确定轴值：<br>
  1.首元素当做轴值<br>
  2.从待排序序列的另一端向轴值一端遍历取出每一个元素与轴值比较<br>
  3.如果取出的元素比轴值大，则继续遍历<br>
  4.如果取出的元素比轴值小，则交换两个元素<br>
  5.把交换后的元素当做轴值，执行步骤2<br>
  6.循环出口，前后下标相撞<br>

  @param data 待排序数组
  @param start 待排子序列的起始位置(数组下标)
  @param end 待排子序列的结束位置(数组下标)
  @return 返回轴值下标
  */
  public static int getAxisValueIndex(int[] data,int start,int end){
    int low = start;
    int high = end;
    int temp;
    while(low < high){
      while(low < high){
        if (data[low] > data[high]) {
          temp = data[low];
          data[low] = data[high];
          data[high] = temp;
          low++;
          break;
        }else {
          high--;
        }
      }
      while(low < high){
        if (data[low] > data[high]) {
          temp = data[low];
          data[low] = data[high];
          data[high] = temp;
          high--;
          break;
        }else {
          low++;
        }
      }
    }
    return low;
  }
}
