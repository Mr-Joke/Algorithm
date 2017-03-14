import java.util.Scanner;
public class SequentialSearch{
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int[] array = {2,1,6,3,7,8,4,9,5,0};
    int target = in.nextInt();
    int result = indexOf(array,target);
    System.out.println(result);
  }

  /**
  顺序查找：<br>
  1.遍历目标数组，顺序取出每一个元素
  2.将取出的元素与待查找元素比较，如果相等则返回该元素所在下标
  3.若整个数组中没有目标元素，返回-1

  @param array 待查找数组
  @param target 目标元素
  @return 目标元素所在下标，不存在时返回-1
  */
  public static int indexOf(int[] array,int target){
    for (int i = 0;i < array.length ;i++ ) {
      if (array[i] == target) {
        return i;
      }
    }
    return -1;
  }
}
