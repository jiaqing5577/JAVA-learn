package _01base;// 1. 包和导入
// package 语句声明当前类所在的包
// package learn1;
// import java.util.Scanner; // 导入工具类

public class date2 {
    public static void main(String[] args) {
        System.out.println("Hello, Java!");

        // 3. 逻辑运算符
        // 正确写法：直接输出表达式结果
        System.out.println((3 > 2) && (5 < 10)); // 与运算，结果为true
        boolean logicResult2 = (3 > 5) || (2 < 4); // 或运算，结果为true
        System.out.println(logicResult2);
        boolean logicResult3 = !(3 == 4); // 非运算，结果为true

        // 调用 while 循环，只有在 main 方法中调用才会有终端的输出
        printWhile();
    }
    // 4. while 循环
    public static void printWhile() {
        int i = 0;
        while (i < 3) {
            System.out.println("while循环第" + i + "次");
            i++;
        }
    }

        // 5. for 循环
        void printFor () {
            for (int j = 0; j < 3; j++) {
                System.out.println("for循环第" + j + "次");
            }
        }

        // 6. switch 语句
        void printDay ( int day){
            switch (day) {
                case 1:
                    System.out.println("星期一");
                    break;
                case 2:
                    System.out.println("星期二");
                    break;
                default:
                    System.out.println("其他");
            }
        }

        // 7. break 和 continue
        void breakContinueDemo () {
            for (int k = 0; k < 5; k++) {
                if (k == 2) continue; // 跳过本次循环
                if (k == 4) break; // 终止循环
                System.out.println("k = " + k);
            }
        }

        // 8. 方法重载（同名不同参数的方法）
        int multiply ( int x, int y){
            return x * y;
        }
        double multiply ( double x, double y){
            return x * y;
        }

        // 9. 静态变量和静态方法
        static int staticCount = 0; // 静态变量，属于类
        static void staticMethod () {
            System.out.println("这是静态方法");
        }

        // 10. this 关键字
        int value;
        void setValue ( int value){
            this.value = value; // this 指当前对象的成员变量
        }

        // 11. 简单的对象创建和使用
        void objectDemo () {
            // 创建本类对象
            date2 obj = new date2();
            obj.setValue(100);
            System.out.println("对象的 value = " + obj.value);
        }

}
