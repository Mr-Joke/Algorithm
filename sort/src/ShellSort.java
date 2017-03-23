/**
Description:<br>
希尔排序实现类<br>
Time 2017/03/23 22:31
@author Mrzhou
@version 1.8.0_112
*/
public class ShellSort{
  public static void main(String[] args) {
    int[] array = {5,1,3,8,2,6,4,9,7,0};
    shellSort(array);
    for (int i = 0;i < array.length ;i++ ) {
      System.out.print(array[i] + " ");
    }
    System.out.println();
  }

  /**
  希尔排序:<br>
  1.确定每一趟的增量，对每一趟进行有增量的插入排序
  2.每一趟排序完缩小增量
  3.直到增量缩小至1

  @param data 待排序数组
  */
  public static void shellSort(int[] data){
    int increment = data.length / 2;
    do{
      insertSort(data,increment);
      increment /= 2;
    }while(increment >= 1);
  }

  /**
  指定增量的插入排序:<br>

  @param data 待排序数组
  @param increment 增量
  */
  public static void insertSort(int[] data,int increment){
    int temp;
    for (int i = 0;i < increment ;i++ ) {
      //间隔为增量increment的插入排序
      for (int j = i + increment;j < data.length ;j += increment ) {
        //首先判断待考察元素有没有比本趟插入排序的前一个元素小
        if(data[j] < data[j - increment]){
          //若比前一个元素小，则先存储当前元素
          temp = data[j];
          int index = j - increment;
          do{
            //将前一个元素后移，并继续向前重复判断
            data[index + increment] = data[index];
            index -= increment;
          }while(index >=0 && data[index] > temp);
          //找到插入空隙
          data[index + increment] = temp;
        }
      }
    }
  }
}
