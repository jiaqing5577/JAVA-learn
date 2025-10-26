package _02object;

/*
内部类（Inner Class）

Java内部类是在另一个类的内部定义的类。主要分为四种类型：
1. 成员内部类（Member Inner Class）
2. 静态内部类（Static Nested Class）
3. 局部内部类（Local Inner Class）
4. 匿名内部类（Anonymous Inner Class）
 */
public class date10 {

    private String outerField = "外部类字段";

    public static void main(String[] args) {

        // 1. 成员内部类示例
        System.out.println("\n--- 1. 成员内部类 ---");
        MemberInnerClassDemo.run();

        // 2. 静态内部类示例
        System.out.println("\n--- 2. 静态内部类 ---");
        StaticNestedClassDemo.run();

        // 3. 局部内部类示例
        System.out.println("\n--- 3. 局部内部类 ---");
        LocalInnerClassDemo.run();

        // 4. 匿名内部类示例
        System.out.println("\n--- 4. 匿名内部类 ---");
        AnonymousInnerClassDemo.run();
    }

    /*
    1. 成员内部类（Member Inner Class）
       特点：
       - 是外部类的一个成员，与类的属性和方法平级
       - 可以访问外部类的所有成员（包括private）
       - 必须先创建外部类实例，再创建内部类实例
       - 内部类中可以通过"外部类名.this"访问外部类实例
     */
    static class MemberInnerClassDemo {
        static void run() {
            // 创建外部类实例
            OuterClass1 outer = new OuterClass1();
            // 通过外部类实例创建内部类实例
            OuterClass1.InnerClass inner = outer.new InnerClass();
            inner.display();
        }
    }

    static class OuterClass1 {
        private String outerField = "外部类私有字段";

        // 成员内部类
        class InnerClass {
            private String innerField = "内部类字段";

            public void display() {
                System.out.println("访问内部类字段：" + innerField);
                // 直接访问外部类的字段
                System.out.println("直接访问外部类字段：" + outerField);
                // 通过"外部类名.this"访问外部类实例
                System.out.println("通过外部类.this访问外部类字段：" + OuterClass1.this.outerField);
            }
        }
    }

    /*
    2. 静态内部类（Static Nested Class）
       特点：
       - 使用static修饰，属于外部类本身而不属于外部类的实例
       - 可以访问外部类的所有静态成员
       - 不能直接访问外部类的非静态成员
       - 创建时不依赖外部类实例
     */
    static class StaticNestedClassDemo {
        static void run() {
            // 直接创建静态内部类实例，无需外部类实例
            OuterClass2.StaticInnerClass inner = new OuterClass2.StaticInnerClass();
            inner.display();
        }
    }

    static class OuterClass2 {
        private static String staticOuterField = "外部类静态字段";
        private String instanceOuterField = "外部类实例字段";

        // 静态内部类
        static class StaticInnerClass {
            private String innerField = "静态内部类字段";

            public void display() {
                System.out.println("访问静态内部类字段：" + innerField);
                // 可以访问外部类的静态字段
                System.out.println("访问外部类静态字段：" + staticOuterField);
                // 不能直接访问外部类的实例字段，需要通过实例访问
                // System.out.println(instanceOuterField); // 编译错误
                OuterClass2 outer = new OuterClass2();
                System.out.println("通过外部类实例访问实例字段：" + outer.instanceOuterField);
            }
        }
    }

    /*
    3. 局部内部类（Local Inner Class）
       特点：
       - 定义在方法或作用域内
       - 只能在定义的方法内使用
       - 可以访问外部类的所有成员以及所在方法的final或effectively final局部变量
     */
    static class LocalInnerClassDemo {
        static void run() {
            OuterClass3 outer = new OuterClass3();
            outer.someMethod();
        }
    }

    static class OuterClass3 {
        private String outerField = "外部类字段";

        public void someMethod() {
            final String localVariable = "局部变量（final）";
            String effectivelyFinal = "实际上final的变量";

            // 局部内部类
            class LocalInnerClass {
                private String innerField = "局部内部类字段";

                public void display() {
                    System.out.println("访问局部内部类字段：" + innerField);
                    // 访问外部类字段
                    System.out.println("访问外部类字段：" + outerField);
                    // 访问方法中的final变量
                    System.out.println("访问局部final变量：" + localVariable);
                    // 访问实际上final的变量（没有重新赋值）
                    System.out.println("访问实际上final的变量：" + effectivelyFinal);
                }
            }

            // 创建并使用局部内部类
            LocalInnerClass localInner = new LocalInnerClass();
            localInner.display();
        }
    }

    /*
    4. 匿名内部类（Anonymous Inner Class）
       特点：
       - 没有名字的内部类，通常用于实现接口或继承类
       - 可以访问外部类的所有成员
       - 可以访问所在方法的final或effectively final局部变量
       - 创建时会立即生成该类的实例
     */
    static class AnonymousInnerClassDemo {
        static void run() {
            OuterClass4 outer = new OuterClass4();
            outer.createAnonymousClass();
        }
    }

    static class OuterClass4 {
        private String outerField = "外部类字段";

        public void createAnonymousClass() {
            final String localVariable = "局部final变量";

            // 使用匿名内部类实现Runnable接口
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("在匿名内部类中执行");
                    System.out.println("访问外部类字段：" + outerField);
                    System.out.println("访问局部final变量：" + localVariable);
                }
            };

            // 执行匿名内部类的方法
            runnable.run();

            // 使用匿名内部类继承Thread类
            Thread thread = new Thread() {
                @Override
                public void run() {
                    System.out.println("在线程匿名内部类中执行");
                    System.out.println("访问外部类字段：" + outerField);
                }
            };

            thread.start();
            try {
                thread.join(); // 等待线程执行完毕
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // 内部类访问外部类的示例
    class AccessOuterDemo {
        void demonstrateAccess() {
            System.out.println("访问外部类字段：" + outerField);
        }
    }

    public void demonstrateInnerAccess() {
        AccessOuterDemo inner = new AccessOuterDemo();
        inner.demonstrateAccess();
    }
}