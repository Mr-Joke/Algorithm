/**
Description:<br>
冒泡排序实现类<br>
Time 2017/03/06 18:30<br>
@author Mrzhou
@version 1.8.0_112
*/
public class BubbleSort{

  /**
  上升法（有序区在前，无序区在后）<br>
  1.从无序区向后往前遍历，取当前的元素与前一个元素比较<br>
  2.如果当前元素比前一个元素小，则交换，否则继续遍历前一个<br>
  3.每一趟遍历到当前无序区的首元素处理完后结束一轮，即有序
    区增加一个元素，无序区减少一个元素<br>
  4.重复以上步骤，直到无序区全部变有序<br>

  @param data 待排序数组
  */
  public static void riseSort(int[] data){
    int temp;
    for (int i = 0;i < data.length ;i++ ) {
      for (int j = data.length - 1;j > i ;j-- ) {
        if (data[j] < data[j-1]) {
          temp = data[j];
          data[j] = data[j-1];
          data[j-1] = temp;
        }
      }
    }
  }

  /**
  下沉法（无序区在前，有序区在后）<br>
  1.从无序区向前往后遍历，取当前元素与后一个元素比较<br>
  2.如果当前元素比后一个元素大，则交换，否则继续遍历后一个<br>
  3.每一趟遍历到当前无序区最后一个元素处理完后结束一轮，即
    有序区增加一个元素，无序区减少一个元素<br>
  4.重复以上步骤，直到无序区全部变有序<br>

  @param data 待排序数组
  */
  public static void sinkSort(int[] data){
    int temp;
    for (int i = data.length - 1;i > 0 ;i-- ) {
      for (int j = 0;j < i ;j++ ) {
        if (data[j] > data[j+1]) {
          temp = data[j];
          data[j] = data[j+1];
          data[j+1] = temp;
        }
      }
    }
  }

}
