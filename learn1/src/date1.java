import java.util.Scanner;

public class date1 {
    /*public是指公有，其他类可以访问
    static 修饰符，静态方法，类方法
    void 修饰符，,表示函数无返回值
    main() 方法，是程序的入口，也是程序的开始执行点String[] args是main方法的参数，表示字符串数组
    args是命令行参数，可以通过命令行传递参数给程序
    */
    public static void main(String[] args) {
        // 输出字符串到控制台
        System.out.println("hello world");
        // 声明一个int类型的变量，并赋值为20
        int age = 20;
        System.out.println(age);
        System.out.println(age+5);//25,这里的加号可计算，所以没有链接符的作用
        System.out.println("age="+(age));//字符和变量不能计算，+号起链接符作用


        // 1. 变量声明与赋值
        int number = 10; // 整型变量
        double price = 19.99; // 浮点型变量
        char grade = 'A'; // 字符型变量，单引号
        String name = "张三"; // 字符串变量，双引号
        long bigNumber = 123456789L; // 长整型变量，末尾加L
        boolean isJavaFun = true; // 布尔型变量
        System.out.println("number: " + number);
        System.out.println("price: " + price);
        System.out.println("grade: " + grade);
        System.out.println("isJavaFun: " + isJavaFun);
        System.out.println("name: " + name);
        System.out.println("bigNumber: " + bigNumber);

        // 2. 常量的声明（final关键字）
        final double PI = 3.14159; // PI是常量，不再被修改
        System.out.println("圆周率: " + PI);


        // 3. 基本运算符
        int sum = number + age; // 加法
        int diff = number - age; // 减法
        int product = number * age; // 乘法
        double quotient = (double)number / age; // 除法，注意类型转换,(double)强制转换为浮点数
        int mod = number % 3; // 取余
        System.out.println("sum: " + sum);
        System.out.println("diff: " + diff);
        System.out.println("product: " + product);
        System.out.println("quotient: " + quotient);
        System.out.println("mod: " + mod);

        // 4. 注释的用法
        // 这是单行注释
        /* 这是多行注释
           可以写多行内容 */

        // 5. if/else 条件语句
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入你的年龄: ");
        age = sc.nextInt(); // 从控制台读取整数输入,并赋值给age变量,next函数接收到输入才会继续往下执行代码
        if (age >= 18) {
            System.out.println("成年人");
        } else {
            System.out.println("未成年人");
        }

        // 6. for 循环
        for (int i = 0; i < 3; i++) {
            System.out.println("for循环第" + (i+1) + "次");
        }

        // 7. while 循环
        int count = 0;
        while (count < 2) {
            System.out.println("while循环第" + (count+1) + "次");
            count++;
        }

        // 8. 方法的调用
        printHello(); // 调用自定义方法
        // 自定义方法，打印一句话


        // 9. 数组的声明与使用
        //int [] scores; // 声明一个整型数组
        int[] scores = {90, 85, 100}; // 声明并初始化数组
        System.out.println("第一个分数: " + scores[0]);
        for (int s : scores) {//从scores数组中取出每一个元素赋值给s
            System.out.println("遍历数组分数: " + s);
        }
    }

    public static void printHello() {
        System.out.println("你好，世界");

    }
}

