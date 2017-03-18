public class BF{
  public static void main(String[] args) {
    String str = "abcdefghbac";
    String targetStr = "ab";
    int result = searchSubString(str,targetStr);
    System.out.println(result);
  }

  /**
  串匹配问题：<br>
  BF算法：
  １．用i来记录主串每一趟的起始位置，j表示当前比较的字符所在主串的下标
  ２．将主串当前位置(j)的字符与模式串当前的字符(j-i)比较，若相等，则ｊ++，继续执行２
  ３．若不相等，主串的起始位置++,模式串跳回起始位置,继续执行步骤２
  ４．结束标志：模式串匹配后者主串遍历到终点

  @param str 主串
  @param targetStr 模式串
  @return 匹配的模式串首字符所在主串的下标，不匹配时返回-1
  */
  public static int searchSubString(String str,String targetStr){
    for (int i = 0;i < str.length() ;i++ ) {
      int j ;
      for (j = i;j < i + targetStr.length() ;j++ ) {
        //若在一趟的比较中有其中一个不相等，则结束本趟
        if (str.charAt(j) != targetStr.charAt(j-i)) {
          break;
        }
      }
      //若j自增到（i + 模式串长度）的值，表示匹配
      if (j == i + targetStr.length()) {
        return i;
      }
    }
    //不匹配，返回-1
    return -1;
  }
}
