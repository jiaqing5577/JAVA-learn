
public class date1 {
    public static void main(String[] args) {
        // 输出字符串到控制台
        System.out.println("hello world");
        // 声明一个int类型的变量，并赋值为20
        int age = 20;
        System.out.println(age);

        // 1. 变量声明与赋值
        int number = 10; // 整型变量
        double price = 19.99; // 浮点型变量
        char grade = 'A'; // 字符型变量，单引号
        boolean isJavaFun = true; // 布尔型变量
        String name = "张三"; // 字符串变量，双引号
        System.out.println("number: " + number);
        System.out.println("price: " + price);
        System.out.println("grade: " + grade);
        System.out.println("isJavaFun: " + isJavaFun);
        System.out.println("name: " + name);

        // 2. 常量的声明（final关键字）
        final double PI = 3.14159; // PI是常量，不��再被修改
        System.out.println("圆周率: " + PI);

        // 3. 基本运算符
        int sum = number + age; // 加法
        int diff = number - age; // 减法
        int product = number * age; // 乘法
        double quotient = (double)number / age; // 除法，注意类型转换
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

        // 8. 方法的调��
        printHello(); // 调用自定义方法

        // 9. 数组的声明与使用
        int[] scores = {90, 85, 100}; // 声明并初始化数组
        System.out.println("第一个分数: " + scores[0]);
        for (int s : scores) {
            System.out.println("遍历数组分数: " + s);
        }
    }

    // 自定义方法，打印一句话
    public static void printHello() {
        System.out.println("你好，世界");
    }
}

