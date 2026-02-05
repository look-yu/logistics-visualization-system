// 文件名：CalcDemo.java
public class CalcDemo {
    public static void main(String[] args) {
        // 定义整数变量：int，赋值数字
        int a = 10;
        int b = 3;
        // 定义小数变量：double，存储浮点数
        double c = 10.5;
        double d = 2.2;

        // 基本运算：+ - * / %（%是取余，求除法的余数）
        System.out.println(a + " + " + b + " = " + (a + b)); // 13
        System.out.println(a + " - " + b + " = " + (a - b)); // 7
        System.out.println(a + " * " + b + " = " + (a * b)); // 30
        System.out.println(a + " / " + b + " = " + (a / b)); // 整数相除取整，结果3
        System.out.println(a + " % " + b + " = " + (a % b)); // 取余，结果1
        System.out.println(c + " / " + d + " = " + (c / d)); // 小数相除，结果4.7727...

        // 变量重新赋值
        a = 20;
        System.out.println("a重新赋值后：" + a); // 20
    }
}