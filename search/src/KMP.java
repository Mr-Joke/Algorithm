public class KMP{
  public static void main(String[] args) {
    String mainStr = "ababaababcb";
    String subStr = "ababc";
    int result = searchSubString(mainStr,subStr);
    System.out.println(result);
  }

  /**
  串匹配问题(KMP)：<br>

  @param mainStr 主串
  @param subStr 模式串
  @return 匹配的模式串首元素所在主串的下标，不匹配时返回-1
  */
  public static int searchSubString(String mainStr,String subStr){
    int[] next = getNext(subStr);
    if(next == null) return -1;
    int mainIndex = 0;
    int subIndex = 0;
    while(mainIndex < mainStr.length()){
      if(mainStr.charAt(mainIndex) != subStr.charAt(subIndex)){
        //若不匹配，则模式串的下标取其next数组中的值
        if(next[subIndex] == -1) mainIndex++;
        else subIndex = next[subIndex];
      }else{
        //匹配则主串与模式串的下标++
        mainIndex++;
        subIndex++;
      }
      //当匹配时返回下标
      if(subIndex >= subStr.length()) return mainIndex-subIndex;
    }
    return -1;
  }

  /**
  生成next数组：<br>

  @param subStr 模式串
  @return 模式串的next数组
  */
  public static int[] getNext(String subStr){
    if(subStr == null || subStr.equals("")) return null;
    int[] next = new int[subStr.length()];
    int i,j,k;
    next[0]=-1;
    //填next数组
    if (next.length > 1) {
      //前二位固定-1 0
      next[1] = 0;
      for (i = 2;i < next.length ;i++ ) {
        //从第数组下标２开始，求出每个下标对应的next数组值
        for (j = 1;j < i;j++ ) {
          for (k = j;k < i ;k++ ) {
            if (subStr.charAt(k) != subStr.charAt(k-j)) {
              break;
            }
          }
          //next[i]等于元素i之前的串中真前缀与真后缀相等的最大长度
          if (k == i) {
            next[i] = i-j;
            break;
          }
        }
        //j等于i表示整趟遍历完都没有相等的子串，因此next[i]=0
        if (j == i) {
          next[i] = 0;
        }
      }
    }
    return next;
  }
}
