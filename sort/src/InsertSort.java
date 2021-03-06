/**
 Description:<br>
 插入排序实现类<br>
 Time 2017/03/09 14:54<br>
 @author Mrzhou
 @version 1.8.0_112
 */
public class InsertSort{

    /**
     插入排序（麻烦）：<br>
     1.将数组的首元素作为有序区的元素<br>
     2.取无序区的第一个元素出来<br>
     3.将取出元素从有序区的最后一个元素一直向前遍历比较<br>
     4.若该元素比当前有序区的元素大，则插入在其后面，否则继续向前遍历<br>
     5.循环执行以上步骤直到无序区全都变成有序区

     @param data 待排序数组
     */
    public static void insertSort1(int[] data){
        //循环从无序区的第一个元素开始
        for (int i = 1;i < data.length ;i++ ) {
            //用临时变量存储待插入元素
            int temp = data[i];
            //从有序区开始遍历比较
            for (int j = i - 1 ;j >= 0 ;j-- ) {
                //找到插入位置
                if (data[j] < temp) {
                    //将插入位置后面的所有元素往后挪一位，空出位置
                    for (int k = i - 1;k > j ;k-- ) {
                        data[k+1] = data[k];
                    }
                    //插入
                    data[j+1] = temp;
                    break;
                }else {
                    //插入位置在0号的时候
                    if (j == 0) {
                        for (int k = i - 1;k >= 0 ;k-- ) {
                            data[k+1] = data[k];
                        }
                        data[0] = temp;
                    }
                }
            }
        }
    }

    /**
  		插入排序（简短版）：<br>
  		1.先用临时变量存储当前元素
  		2.从当前元素向前遍历，取出每一个元素
  		3.将取出的元素与临时变量存储的元素作比较
  		4.若取出的元素较大，则将该元素往后移，
  	  	否则，将临时变量存储的元素插入到该元素后面。

  		@param data 待排序数组
  	*/
  	public static void insertSort2(int[] data){

  		for(int i = 0; i < data.length;i++){
  			int temp = data[i];
  			int j;
  			for(j = i;j > 0;j--){
  				if(data[j-1] > temp){
  					data[j] = data[j-1];
  				}else break;
  			}
  			data[j] = temp;
  		}
  	}
}
