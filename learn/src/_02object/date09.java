package _02object;

/*
抽象类和接口

抽象类和接口是Java中实现抽象的重要机制，它们都用于定义抽象方法，但有不同的特性和使用场景。

抽象类（Abstract Class）：
- 使用abstract关键字修饰
- 可以包含抽象方法（没有方法体）和具体方法（有方法体）
- 可以包含成员变量、构造方法、静态方法等
- 子类通过extends关键字继承抽象类，必须实现所有抽象方法（除非子类也是抽象类）
- 一个类只能继承一个抽象类（单继承）

接口（Interface）：
- 使用interface关键字定义
- Java 8之前只能包含抽象方法（public abstract）
- Java 8开始可以包含默认方法（default）和静态方法（static）
- Java 9开始可以包含私有方法（private）
- 成员变量默认是public static final（常量）
- 类通过implements关键字实现接口，必须实现所有抽象方法
- 一个类可以实现多个接口（多实现）

选择原则：
- 如果需要共享代码实现，使用抽象类
- 如果需要定义行为规范，使用接口
- 如果需要多重继承，使用接口
- 优先使用接口，因为更加灵活
*/

public class date09 {

    public static void main(String[] args) {

        // 1. 抽象类示例
        System.out.println("\n--- 1. 抽象类示例 ---");
        AbstractClassDemo.run();

        // 2. 接口示例
        System.out.println("\n--- 2. 接口示例 ---");
        InterfaceDemo.run();

        // 3. 抽象类与接口对比
        System.out.println("\n--- 3. 抽象类与接口对比 ---");
        ComparisonDemo.run();

        // 4. Java 8接口新特性
        System.out.println("\n--- 4. Java 8接口新特性 ---");
        Java8InterfaceDemo.run();
    }

    /*
    1. 抽象类示例
    
    抽象类是不能被实例化的类，通常包含一些抽象方法供子类实现。
    抽象类可以包含：
    - 抽象方法（必须被子类实现）
    - 具体方法（可以被子类继承或重写）
    - 成员变量
    - 构造方法（不能直接调用，但可以被子类构造方法调用）
    - 静态方法
    */
    static class AbstractClassDemo {
        // 抽象类
        abstract static class Animal {
            protected String name;

            // 构造方法
            public Animal(String name) {
                this.name = name;
            }

            // 具体方法
            public void sleep() {
                System.out.println(name + " 正在睡觉");
            }

            // 抽象方法，子类必须实现
            public abstract void makeSound();

            // 抽象方法
            public abstract void move();
        }

        // 继承抽象类的具体类
        static class Dog extends Animal {
            public Dog(String name) {
                super(name); // 调用父类构造方法
            }

            // 实现抽象方法
            @Override
            public void makeSound() {
                System.out.println(name + " 汪汪叫");
            }

            // 实现抽象方法
            @Override
            public void move() {
                System.out.println(name + " 四肢奔跑");
            }

            // 子类特有的方法
            public void wagTail() {
                System.out.println(name + " 摇尾巴");
            }
        }

        // 另一个继承抽象类的具体类
        static class Bird extends Animal {
            public Bird(String name) {
                super(name);
            }

            // 实现抽象方法
            @Override
            public void makeSound() {
                System.out.println(name + " 啾啾叫");
            }

            // 实现抽象方法
            @Override
            public void move() {
                System.out.println(name + " 挥动翅膀飞翔");
            }

            // 子类特有的方法
            public void fly() {
                System.out.println(name + " 在天空中自由飞翔");
            }
        }

        static void run() {
            // 不能创建抽象类实例
            // Animal animal = new Animal("动物"); // 编译错误

            // 创建具体类实例
            Dog dog = new Dog("小白");
            Bird bird = new Bird("小鸟");

            // 调用继承的方法
            dog.sleep();
            bird.sleep();

            // 调用实现的抽象方法
            dog.makeSound();
            dog.move();
            bird.makeSound();
            bird.move();

            // 调用子类特有方法
            dog.wagTail();
            bird.fly();
        }
    }

    /*
    2. 接口示例
    
    接口定义了一组规范，实现接口的类必须遵循这些规范。
    接口可以包含：
    - 抽象方法（默认public abstract）
    - 默认方法（default，Java 8新增）
    - 静态方法（static，Java 8新增）
    - 常量（默认public static final）
    - 私有方法（private，Java 9新增）
    */
    static class InterfaceDemo {
        // 定义接口
        interface Flyable {
            // 常量
            int MAX_ALTITUDE = 10000;

            // 抽象方法（默认public abstract）
            void fly();

            // 默认方法（Java 8新增）
            default void land() {
                System.out.println("着陆");
            }

            // 静态方法（Java 8新增）
            static void describe() {
                System.out.println("这是会飞的动物接口");
            }
        }

        interface Swimmable {
            void swim();

            default void dive() {
                System.out.println("潜水");
            }
        }

        // 实现单个接口
        static class Sparrow implements Flyable {
            private String name;

            public Sparrow(String name) {
                this.name = name;
            }

            @Override
            public void fly() {
                System.out.println(name + " 扇动翅膀在天空飞翔，最高可飞到" + MAX_ALTITUDE + "米");
            }
        }

        // 实现多个接口
        static class Duck implements Flyable, Swimmable {
            private String name;

            public Duck(String name) {
                this.name = name;
            }

            @Override
            public void fly() {
                System.out.println(name + " 扇动翅膀飞行");
            }

            @Override
            public void swim() {
                System.out.println(name + " 在水中游泳");
            }

            // 可以重写默认方法
            @Override
            public void land() {
                System.out.println(name + " 降落在水面上");
            }
        }

        static void run() {
            // 创建实现接口的类实例
            Sparrow sparrow = new Sparrow("麻雀");
            Duck duck = new Duck("鸭子");

            // 调用实现的方法
            sparrow.fly();
            sparrow.land(); // 使用默认方法
            Flyable.describe(); // 调用静态方法

            duck.fly();
            duck.swim();
            duck.land(); // 重写的默认方法
            duck.dive(); // 使用默认方法

            // 接口类型的引用
            Flyable flyer1 = new Sparrow("小麻雀");
            Flyable flyer2 = new Duck("小鸭子");

            flyer1.fly();
            flyer2.fly();
        }
    }

    /*
    3. 抽象类与接口对比
    
    通过具体示例对比抽象类和接口的特点
    */
    static class ComparisonDemo {
        // 抽象类示例
        abstract static class Vehicle {
            protected String brand;

            public Vehicle(String brand) {
                this.brand = brand;
            }

            // 具体方法
            public void start() {
                System.out.println(brand + " 启动");
            }

            // 抽象方法
            public abstract void run();

            public abstract void stop();
        }

        // 接口示例
        interface GPS {
            void navigate();
        }

        interface Bluetooth {
            void connect();
        }

        // 汽车类：继承抽象类并实现多个接口
        static class Car extends Vehicle implements GPS, Bluetooth {
            public Car(String brand) {
                super(brand);
            }

            @Override
            public void run() {
                System.out.println(brand + " 汽车在路上行驶");
            }

            @Override
            public void stop() {
                System.out.println(brand + " 汽车停车");
            }

            @Override
            public void navigate() {
                System.out.println(brand + " 汽车导航开启");
            }

            @Override
            public void connect() {
                System.out.println(brand + " 汽车蓝牙连接");
            }
        }

        static void run() {
            Car car = new Car("宝马");

            // 调用继承自抽象类的方法
            car.start();
            car.run();
            car.stop();

            // 调用实现接口的方法
            car.navigate();
            car.connect();

            // 多态性：不同类型的引用
            Vehicle vehicle = car;
            GPS gps = car;
            Bluetooth bt = car;

            vehicle.run();
            gps.navigate();
            bt.connect();
        }
    }

    /*
    4. Java 8接口新特性
    
    Java 8为接口引入了默认方法和静态方法，增强了接口的能力
    */
    static class Java8InterfaceDemo {
        // 定义带默认方法和静态方法的接口
        interface Animal {
            // 抽象方法
            void makeSound();

            // 默认方法
            default void sleep() {
                System.out.println("动物正在睡觉");
            }

            // 静态方法
            static void info() {
                System.out.println("这是动物接口");
            }

            // 默认方法可以被重写
            default void move() {
                System.out.println("动物在移动");
            }
        }

        // 实现接口
        static class Cat implements Animal {
            private String name;

            public Cat(String name) {
                this.name = name;
            }

            @Override
            public void makeSound() {
                System.out.println(name + " 喵喵叫");
            }

            // 重写默认方法
            @Override
            public void move() {
                System.out.println(name + " 蹑手蹑脚地走动");
            }

            // 可以调用默认方法
            public void rest() {
                sleep(); // 调用默认方法
            }
        }

        // 另一个实现
        static class Horse implements Animal {
            private String name;

            public Horse(String name) {
                this.name = name;
            }

            @Override
            public void makeSound() {
                System.out.println(name + " 嘶鸣");
            }

            // 使用默认的move方法
        }

        static void run() {
            Cat cat = new Cat("小猫");
            Horse horse = new Horse("小马");

            // 调用实现的方法
            cat.makeSound();
            cat.move(); // 重写的方法
            cat.rest(); // 调用默认方法

            horse.makeSound();
            horse.move(); // 默认方法

            // 调用静态方法
            Animal.info();

            // 多态使用
            Animal animal1 = cat;
            Animal animal2 = horse;

            animal1.sleep(); // 默认方法
            animal2.sleep(); // 默认方法
        }
    }
}