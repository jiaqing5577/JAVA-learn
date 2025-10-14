public class date3_1013 {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        // 创建类的实例以调用test1方法
        date3_1013 demo = new date3_1013();
        
        // 调用各种演示方法
        demo.ifElseDemo();
        demo.switchDemo();
        demo.forLoopDemo();
        demo.whileLoopDemo();
        demo.fixedWhileLoopDemo(); // 调用修正后的while循环示例

    }
    
    /**
     * if-else 分支语句演示
     */
    public void ifElseDemo() {

        // 基本if语句
        int age = 18;
        if (age >= 18) {
            System.out.println("你已经成年了");
        }
        
        // if-else语句
        int score = 85;
        if (score >= 60) {
            System.out.println("恭喜你，考试及格了！");
        } else {
            System.out.println("很遗憾，你需要补考");
        }
        
        // 多重if-else语句
        int grade = 85;
        if (grade >= 90) {
            System.out.println("优秀");
        } else if (grade >= 80) {
            System.out.println("良好");
        } else if (grade >= 70) {
            System.out.println("中等");
        } else if (grade >= 60) {
            System.out.println("及格");
        } else {
            System.out.println("不及格");
        }
        

        String status = "没钱";
        // 错误的方式：使用 == 比较字符串，不同于python
        // if (status == "没钱") { ... } 
        
        // 正确的方式：使用 equals 方法比较字符串
        if ("没钱".equals(status)) {
            System.out.println("正确：使用equals方法比较字符串");
        }
    }
    
    /**
     * switch 分支语句演示
     */
    public void switchDemo() {
        
        // 根据数字显示星期几
        int day = 3;
        switch (day) {
            case 1:
                System.out.println("星期一");
                break;
            case 2:
                System.out.println("星期二");
                break;
            case 3:
                System.out.println("星期三");
                break;
            case 4:
                System.out.println("星期四");
                break;
            case 5:
                System.out.println("星期五");
                break;
            case 6:
                System.out.println("星期六");
                break;
            case 7:
                System.out.println("星期日");
                break;
            default:
                System.out.println("无效的日期");
                break;
        }
        
        // switch与字符串的使用 (JDK 7+支持)
        String fruit = "apple";
        switch (fruit) {
            case "apple":
                System.out.println("这是一个苹果");
                break;
            case "banana":
                System.out.println("这是一根香蕉");
                break;
            case "orange":
                System.out.println("这是一个橙子");
                break;
            default:
                System.out.println("未知水果");
                break;
        }
    }
    
    /**
     * for 循环
     */
    public void forLoopDemo() {
        
        // 基本for循环
        System.out.println("基本for循环 - 打印1到5:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("数字: " + i);
        }
        
        // for循环计算1到10的和
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        System.out.println("1到10的和为: " + sum);
        
        // 增强for循环(For-Each)遍历数组
        System.out.println("增强for循环遍历数组:");
        String[] fruits = {"苹果", "香蕉", "橙子", "葡萄"};
        for (String f : fruits) {
            System.out.println("水果: " + f);
        }
        
        // 嵌套for循环打印九九乘法表
        System.out.println("九九乘法表:");
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + (i*j) + "\t");
            }
            System.out.println();
        }
    }
    
    /**
     * while 循环
     */
    public void whileLoopDemo() {
        
        // 基本while循环
        System.out.println("基本while循环 - 打印1到5:");
        int i = 1;
        while (i <= 5) {
            System.out.println("数字: " + i);
            i++;
        }
        
        // 计算1到100之间所有偶数的和
        int num = 1;
        int evenSum = 0;
        while (num <= 100) {
            if (num % 2 == 0) {
                evenSum += num;
            }
            num++;
        }
        System.out.println("1到100之间所有偶数的和为: " + evenSum);
    }
    
    /**
     * while循环示例
     */
    public void fixedWhileLoopDemo() {


        String out = "";
        int money = 200;
        
        while(true) {
            if (money > 100) {
                out = "有钱";
                System.out.println("还有钱: " + money + "元");
                money = money - 50;
            } else {
                out = "没钱";
                System.out.println("没钱了，剩余: " + money + "元");
            }

            if ("没钱".equals(out)) {
                break;
            }
        }
        System.out.println("循环结束");
    }

}