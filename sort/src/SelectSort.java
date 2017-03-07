/**
Description:<br>
选择排序实现类<br>
Time 2017/03/06 18:45<br>
@author Mrzhou
@version 1.8.0_112
*/
public class SelectSort{

  /**
  选择排序（有序区在前，无序区在后）<br>
  1.从无序区的第二个元素开始，向后遍历，取出每一个元素<br>
  2.将取出的元素与无序区首元素比较，如果比首元素小，则交换，否则继续<br>
  3.每趟遍历到无序区最后一个元素处理完后结束，即无序区的首元素变成有
    序区的最后一个元素<br>
  4.重复执行以上步骤，直到无序区全部变成有序<br>

  @param data 待排序数据
  */
  public static void selectSort(int[] data){
    int temp;
    for (int i = 0;i < data.length ;i++ ) {
      for (int j = i + 1;j < data.length ;j++ ) {
        if (data[i] > data[j]) {
          temp = data[i];
          data[i] = data[j];
          data[j] = temp;
        }
      }
    }
  }
}
