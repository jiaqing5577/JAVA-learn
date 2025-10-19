/*
1. 多态（Polymorphism）
2. 单例模式：饿汉式（Eager）和懒汉式（Lazy）

*/
package _02object;

public class date07 {

    // 程序入口：运行两个演示（多态与单例）
    public static void main(String[] args) {
        System.out.println("== 多态示例 ==");
        runPolymorphismExample();

        System.out.println();
        System.out.println("== 单例示例 ==");
        runSingletonExample();
    }

    // ================= 多态（Polymorphism）示例 =================
    /*
    多态基本概念（面向对象三大特性之一）：
    1. 编译时看引用类型（变量声明的类型），运行时看实际对象类型（new 出来的类型）。
    2. 方法调用会发生动态绑定（也叫运行时绑定），即调用的是实际对象重写后的方法。
    3. 多态的好处：统一接口、可替换实现（例如方法参数接受父类/接口），增强扩展性。

    用 Animal / Dog / Cat 演示：
    - Animal 定义一个 speak() 方法（父类），子类重写该方法。
    - 使用 Animal 引用指向 Dog 或 Cat 的对象，调用 speak() 时会执行子类的实现，这就是多态。
    - 还演示了 instanceof 与向下转型（downcast）的正确与安全使用方式。
    */
    public static void runPolymorphismExample() {
        // 下面逐行解释：
        // 1) 声明一个父类类型的引用 a1，但实际创建的是 Dog 对象。
        //    - 在编译阶段，a1 的类型被认为是 Animal（即编译器知道它有 Animal 的方法）；
        //    - 在运行阶段，因为对象实际是 Dog，所以调用重写后的 Dog.speak()。
        Animal a1 = new Dog(); // 编译时类型是 Animal，运行时类型是 Dog

        // 同理，a2 变量在运行时会表现为 Cat 的行为
        Animal a2 = new Cat();

        // 这里看起来像是在调用父类的方法，但实际上发生了动态绑定：
        // 在运行时 JVM 会查找对象的真实类型并调用对应实现（Dog 或 Cat 的实现）。
        a1.speak(); // 期望输出：Dog: 汪汪！我是狗
        a2.speak(); // 期望输出：Cat: 喵喵！我是猫

        // 向下转型演示：如果我们需要访问子类特有方法（例如 Dog.fetch），
        // 必须把父类引用强转回子类类型，且之前可以用 instanceof 进行类型检查以保证安全。
        if (a1 instanceof Dog) {
            // 只有当 a1 的运行时类型确实是 Dog 时，向下转型才安全
            Dog d = (Dog) a1; // 向下转型（必须保证实际对象类型兼容）
            d.fetch(); // 调用 Dog 独有的方法
        }

        // 把多态用于方法参数：makeAnimalSpeak 接受 Animal 类型，传入任意子类都可以
        // 这体现了 "面向接口编程" 的思想（写方法时只依赖父类型或接口）。
        makeAnimalSpeak(new Dog()); // 仍然会调用 Dog 的 speak
        makeAnimalSpeak(new Cat()); // 仍然会调用 Cat 的 speak

        // 总结性注释：
        // - 如果子类覆盖（override）了父类方法，运行时会调用子类版本。
        // - 多态有利于扩展：增加新的子类不需要修改使用父类型的代码。
    }

    // 接受父类类型的通用方法（演示多态作为参数）
    public static void makeAnimalSpeak(Animal a) {
        // 这里无需关心 a 的具体子类型，统一调用 speak()
        // 这句在运行时会发生动态绑定，调用实际对象的实现。
        a.speak();
    }


    // 父类（基类）：Animal
    static class Animal {
        // 父类的方法：默认实现
        // 注意：如果子类需要不同的行为，可以在子类中使用 @Override 注解覆盖该方法。
        public void speak() {
            System.out.println("Animal: 我在叫（默认实现）");
        }
    }

    // 子类：Dog，重写了 speak 方法，并添加了子类独有的方法 fetch
    static class Dog extends Animal {
        @Override
        public void speak() {
            // 这是子类对父类方法的重写（override）
            // @Override 注解的好处：编译器会检查方法签名是否正确，避免手误导致的方法重载而非重写。
            System.out.println("Dog: 汪汪！我是狗");
        }

        // 子类特有的方法
        // 只有当引用为 Dog 类型（或被强转为 Dog）时，才能调用该方法。
        public void fetch() {
            System.out.println("Dog: 我可以捡回骨头（子类特有行为）");
        }
    }

    // 子类：Cat
    static class Cat extends Animal {
        @Override
        public void speak() {
            System.out.println("Cat: 喵喵！我是猫");
        }

        public void scratch() {
            System.out.println("Cat: 我可以抓沙发（子类特有行为）");
        }
    }


    // ================= 单例模式（Singleton）示例 =================
    /*
    单例模式目的：保证类在内存中只有一个实例，并提供一个全局访问点。
    常见实现：
    - 饿汉式（Eager）：类加载时就创建好实例，线程安全，但可能造成资源浪费（实例提前创建）。
    - 懒汉式（Lazy）：第一次访问时创建实例，可以延迟初始化。需要注意线程安全问题。

    下面用两个示例类演示：EagerSingleton（饿汉）和 LazySingleton（线程安全的懒汉 - 双重检查锁定）。
    */
    public static void runSingletonExample() {
        // 说明：下面对比同一类型的两个变量是否引用同一个对象（== 比较的是引用是否相同）。

        // 饿汉式使用
        EagerSingleton e1 = EagerSingleton.getInstance();
        EagerSingleton e2 = EagerSingleton.getInstance();
        // 期望输出 true，因为饿汉式在类加载时就创建了单例实例，两个引用应指向同一个对象
        System.out.println("EagerSingleton e1 == e2 ? " + (e1 == e2));
        e1.hello();
        e2.hello();

        // 懒汉式使用（线程安全的双重检查锁）
        // 第一次调用时会创建实例，之后再调用会返回同一个实例。
        LazySingleton l1 = LazySingleton.getInstance();
        LazySingleton l2 = LazySingleton.getInstance();
        System.out.println("LazySingleton l1 == l2 ? " + (l1 == l2));
        l1.hello();
        l2.hello();

        // 演示一个非线程安全的懒汉示例（仅用于说明，不在并发环境中使用）
        NonThreadSafeLazy n1 = NonThreadSafeLazy.getInstance();
        NonThreadSafeLazy n2 = NonThreadSafeLazy.getInstance();
        System.out.println("NonThreadSafeLazy n1 == n2 ? " + (n1 == n2));

        // - 对于线程不安全的实现，多个线程同时判断 instance==null 时可能创建多个实例，违反单例目的。
        // - 可以通过 synchronized、volatile、静态内部类持有实例或枚举等方式保证线程安全。
    }

    // 饿汉式单例：类加载时创建实例
    static class EagerSingleton {
        // 私有静态实例，类加载时初始化（JVM 保证线程安全）
        private static final EagerSingleton INSTANCE = new EagerSingleton();

        // 私有构造器，防止外部 new
        private EagerSingleton() {
            // 这里可以放一些初始化代码，例如打开文件或建立连接（但饿汉式会在类加载时就执行，可能造成资源浪费）。
        }

        // 对外暴露的访问点
        public static EagerSingleton getInstance() {
            return INSTANCE;
        }

        public void hello() {
            // 打印 hashCode 帮助观察是否为同一个实例（同一对象的 hashCode 一般相同）
            System.out.println("EagerSingleton instance hash:" + this.hashCode());
        }
    }

    // 懒汉式单例（线程安全）：双重检查锁定 + volatile
    static class LazySingleton {
        // volatile 保证不同线程可见且禁止重排序，配合双重检查锁定使用
        private static volatile LazySingleton instance;

        private LazySingleton() {
            // 私有构造器，防止外部通过 new 创建多个实例
        }

        public static LazySingleton getInstance() {
            // 第一重判断：避免每次都进入 synchronized，提升性能
            if (instance == null) {
                // 同步块：只有在 instance 为 null 时才会进入，避免不必要的同步开销
                synchronized (LazySingleton.class) {
                    // 第二重判断：线程 A 在进入 synchronized 前可能已经创建了实例，
                    // 因此需要再次检查
                    if (instance == null) {
                        instance = new LazySingleton();
                    }
                }
            }
            return instance;
        }

        public void hello() {
            System.out.println("LazySingleton instance hash:" + this.hashCode());
        }
    }

    // 非线程安全的懒汉式（示例，仅用于对比）
    static class NonThreadSafeLazy {
        private static NonThreadSafeLazy instance;

        private NonThreadSafeLazy() {
        }

        // 线程不安全：多个线程可能同时进入 if(instance==null) 并创建多个实例
        public static NonThreadSafeLazy getInstance() {
            if (instance == null) {
                instance = new NonThreadSafeLazy();
            }
            return instance;
        }
    }
}
