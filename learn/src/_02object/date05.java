package _02object;

// 定义一个Person类 - 这是创建对象的模板
public class date05 {
    // 类的属性(也叫字段)
    String name;      // 姓名
    int age;          // 年龄
    
    // 构造器(Constructor) - 用于创建对象时初始化属性
    public date05(String name, int age) {
        this.name = name;  // this关键字指向当前对象本身
        this.age = age;
    }
    
    // 默认构造器
    public date05() {
        // 不带参数的构造器
    }
    
    // 方法 - 对象可以执行的操作
    public void introduce() {
        System.out.println("大家好，我叫" + name + "，今年" + age + "岁");
    }
    
    // 封装示例 - 私有属性和公共getter/setter方法
    private String secret;  // 私有属性，只能在类内部访问
    
    public String getSecret() {  // 公共的获取方法
        return secret;
    }
    
    public void setSecret(String secret) {  // 公共的设置方法
        this.secret = secret;
    }
    
    // 静态方法示例 - 属于类而不是特定对象，可以通过类也可以通过对象调用。
    public static void printClassInfo() {
        System.out.println("这是Person类，用于创建人物对象");
    }
}