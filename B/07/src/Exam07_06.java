/*
蛮力法
用时　47242ms
*/
public class Exam07_06{
  public static void main(String[] args) {
    long start = System.currentTimeMillis();
    int[] array = new int[10];
    int count = 0;
    for (int a = 0;a < 10 ;a++ ) {
      array[0] = a;
      for (int b = 0;b < 10 ;b++ ) {
        array[1] = b;
        for (int c = 0;c < 10 ;c++ ) {
          array[2] = c;
          for (int d = 0;d < 10 ;d++ ) {
            array[3] = d;
            for (int e = 0;e < 10 ;e++ ) {
              array[4] = e;
              for (int f = 0;f < 10 ;f++ ) {
                array[5] = f;
                for (int g = 0;g < 10 ;g++ ) {
                  array[6] = g;
                  for (int h = 0;h < 10 ;h++ ) {
                    array[7] = h;
                    for (int i = 0;i < 10 ;i++ ) {
                      array[8] = i;
                      for (int j = 0;j < 10 ;j++ ) {
                        array[9] = j;
                        if(a!=b && a!=c && a!=d && a!=e && a!=f && a!=g && a!=h && a!=i && a!=j)
  												if(b!=c && b!=d && b!=e && b!=f && b!=g && b!=h && b!=i && b!=j)
  													if(c!=d && c!=e && c!=f && c!=g && c!=h && c!=i && c!=j)
  														if(d!=e && d!=f && d!=g && d!=h && d!=i && d!=j)
  															if(e!=f && e!=g && e!=h && e!=i && e!=j)
  																if(f!=g && f!=h && f!=i && f!=j)
  																	if(g!=h && g!=i && g!=j)
  																		if(h!=i && h!=j)
                                        if(i!=j)
                                          if(isSatisfy(array))count++;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    System.out.println(count);
    long end = System.currentTimeMillis();
    System.out.println(end - start + "ms");
  }

  /**
  判断是否满足：<br>

  @param array 待判断数组
  @return 是否满足
  */
  public static boolean isSatisfy(int[] array){
    switch(0){
      case 0:{
        if(isNear(array[0],array[1]) || isNear(array[0],array[3]) ||
        isNear(array[0],array[4]) || isNear(array[0],array[5]))
        return false;
      }
      case 1:{
        if(isNear(array[1],array[0]) || isNear(array[1],array[2]) ||
        isNear(array[1],array[4]) || isNear(array[1],array[5]) || isNear(array[1],array[6]))
        return false;
      }
      case 2:{
        if(isNear(array[2],array[1]) || isNear(array[2],array[5]) ||
        isNear(array[2],array[6]))
        return false;
      }
      case 3:{
        if(isNear(array[3],array[0]) || isNear(array[3],array[4]) ||
        isNear(array[3],array[7]) || isNear(array[3],array[8]))
        return false;
      }
      case 4:{
        if(isNear(array[4],array[0]) || isNear(array[4],array[1]) ||
        isNear(array[4],array[3]) || isNear(array[4],array[5]) || isNear(array[4],array[7]) ||
        isNear(array[4],array[8]) || isNear(array[4],array[9]))
        return false;
      }
      case 5:{
        if(isNear(array[5],array[0]) || isNear(array[5],array[1]) ||
        isNear(array[5],array[2]) || isNear(array[5],array[4]) ||isNear(array[5],array[6]) ||
        isNear(array[5],array[8]) || isNear(array[5],array[9]))
        return false;
      }
      case 6:{
        if(isNear(array[6],array[1]) || isNear(array[6],array[2]) ||
        isNear(array[6],array[5]) || isNear(array[6],array[9]))
        return false;
      }
      case 7:{
        if(isNear(array[7],array[3]) || isNear(array[7],array[4]) ||
        isNear(array[7],array[8]))
        return false;
      }
      case 8:{
        if(isNear(array[8],array[3]) || isNear(array[8],array[4]) ||
        isNear(array[8],array[5]) || isNear(array[8],array[7]) || isNear(array[8],array[9]))
        return false;
      }
      case 9:{
        if(isNear(array[9],array[4]) || isNear(array[9],array[5]) ||
        isNear(array[9],array[6]) || isNear(array[9],array[8]))
        return false;
        //满足
        return true;
      }
    }
    return false;
  }

  /**
  是否相邻：<br>

  @param a　待判断的数
  @param b 待判断的数周围的数
  @return 是否相邻
  */
  public static boolean isNear(int a,int b){
    if(a - b <= 1 && a - b >= -1) return true;
    return false;
  }
}
