package _01base;

public class date04_1014 {
    public static void main(String[] args) {
        // Java数组学习笔记
        System.out.println("=== Java数组学习笔记 ===");
        System.out.println();

        // 1. 数组的概念
        // 数组是存储相同类型元素的容器
        // 数组在内存中是连续存储的
        // 数组长度在创建时确定，之后不能改变
        // 与Python的列表不同，Java数组不能动态改变大小
        
        // 2. 数组的声明和初始化
        // 声明数组的方式
        int[] array1;  // 声明一个数组变量
        int array2[];  // 另一种声明方式
        
        // 初始化数组的方式

        int[] arr1 = new int[5];  // 创建一个长度为5的int数组，默认值为0
        

        int[] arr2 = {1, 2, 3, 4, 5};  // 声明并初始化数组
        
        int[] arr3 = new int[]{1, 2, 3, 4, 5};
        

        // 3. 数组的基本操作
        // 访问数组元素
        // 获取数组长度
        // 遍历数组
        
        System.out.println("   访问元素: arr2[0] = " + arr2[0]);  // 访问第一个元素
        System.out.println("   修改元素: arr2[0] = 10;");
        arr2[0] = 10;//修改索引
        System.out.println("   修改后arr2[0] = " + arr2[0]);
        
        // 获取数组长度
        System.out.println("   数组长度: arr2.length = " + arr2.length);//Python列表使用len(list)获取长度");
        
        // 遍历数组
        System.out.println("   遍历数组 - 普通for循环:");
        for (int i = 0; i < arr2.length; i++) {
            System.out.println("     arr2[" + i + "] = " + arr2[i]);
        }
        
        System.out.println("   遍历数组 - 增强for循环(推荐):");
        for (int element : arr2) {
            System.out.println("     element = " + element);
        }
        System.out.println("   Python对比: for element in list:");
        System.out.println();

        // 4. 数组的内存结构
        // 数组变量存储在栈(stack)中，存储的是数组的引用(地址)
        // 数组元素存储在堆(heap)中，通过引用访问
        // 数组索引从0开始
        // Python列表也是对象，但内部实现机制不同


        // 5. 多维数组

        // 二维数组声明和初始化
        System.out.println("   二维数组声明: int[][] matrix = new int[3][4];");
        int[][] matrix = new int[3][4];  // 3行4列的二维数组
        

        int[][] irregularArray = new int[3][];  // 行数固定，列数可变
        irregularArray[0] = new int[2];  // 第一行2列
        irregularArray[1] = new int[4];  // 第二行4列
        irregularArray[2] = new int[3];  // 第三行3列
        
        // 初始化二维数组
        int[][] matrix2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        
        System.out.println("   遍历二维数组:");
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[i].length; j++) {
                System.out.print(matrix2[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.println("  增强for循环遍历二维数组:");
        for (int[] row : matrix2) {//逐行遍历
            for (int element : row) {//遍历每一行的元素
                System.out.print(element + " ");
            }
            System.out.println();
        }
        System.out.println("   Python对比: Python使用嵌套列表，如 [[1, 2], [3, 4]]");
        System.out.println();

        // 6. 数组的常见算法

        int[] numbers = {5, 2, 8, 1, 9, 3};

        // 查找最大值
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];//遍历比较，取最大值
            }
        }
        System.out.println(" 最大值: " + max);
        
        // 计算总和
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        System.out.println(" 总和: " + sum);

        // 7. 数组与方法
        // 数组作为参数传递

        printArray(arr2);
        
        // 数组作为返回值
        System.out.println("   数组作为返回值:");
        int[] returnedArray = getArray();
        System.out.print("  返回的数组: ");
        for (int num : returnedArray) {
            System.out.print(num + " ");
        }


        // 10. 实际应用案例
        
        // 存储5个学生的成绩
        double[] scores = {85.5, 92.0, 78.5, 96.0, 88.5};
        String[] names = {"张三", "李四", "王五", "赵六", "钱七"};
        
        System.out.println("    学生成绩:");
        for (int i = 0; i < names.length; i++) {
            System.out.println("      " + names[i] + ": " + scores[i]);
        }
        
        // 计算平均分
        double total = 0;
        for (double score : scores) {
            total += score;
        }
        double average = total / scores.length;
        System.out.println("    平均分: " + average);
        
        // 找到最高分和对应学生
        double maxScore = scores[0];
        int maxIndex = 0;
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > maxScore) {
                maxScore = scores[i];
                maxIndex = i;
            }
        }
        System.out.println("    最高分: " + names[maxIndex] + " - " + maxScore);
        System.out.println();

        System.out.println("=== Java数组学习结束 ===");
    }
    
    // 打印数组的方法
    public static void printArray(int[] arr) {
        System.out.print("  数组内容: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    // 返回数组的方法
    public static int[] getArray() {
        return new int[]{10, 20, 30};
    }
}