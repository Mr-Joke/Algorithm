/*
无穷分数

无穷的分数，有时会趋向于固定的数字。
请计算【图1.jpg】所示的无穷分数，要求四舍五入，精确到小数点后5位，小数位不足的补0。
*/
//这道题不会，源码摘抄自　http://blog.csdn.net/Jiang_Rong_Tao/article/details/51305288
public class C {

    public static void main(String[] args) {
          double a=f(0);
          System.out.println(a);
    }
    public static double f(double x){
        while(x<10){
            x=x+1.0/(f(x+1)+x+1);
        }
        return 1.0/x;
    }
}
