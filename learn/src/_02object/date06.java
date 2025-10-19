/*

1) final 关键字（变量、方法、类的用法和注意事项）
2) 继承（extends、super、方法重写、构造器调用、访问控制等）

*/
package _02object;

public class date06 {

    // 入口：运行 final 和继承的示例
    public static void main(String[] args) {
        System.out.println("--- final 关键字示例 ---");
        finalExamples();

        System.out.println();
        System.out.println("--- 继承（extends）示例 ---");
        inheritanceExamples();
    }

    // ============== final 关键字示例 ==============
    /*
    记：final 可以修饰变量、方法和类。
    - final 变量：一旦赋值后不能再被重新赋值（对于引用类型，引用不可变，但引用指向的对象可以变）。
    - final 方法：不能被子类重写（override）。
    - final 类：不能被继承（例如 java.lang.String 就是 final 的）。
    */
    public static void finalExamples() {
        // final 修饰基本类型
        final int MY_NUMBER = 10; // 记：MY_NUMBER 只能被赋值一次
        System.out.println("MY_NUMBER = " + MY_NUMBER);
        // MY_NUMBER = 20; // 如果取消注释，这行会编译错误：无法为 final 变量 MY_NUMBER 分配值

        // final 修饰引用类型
        final Person p = new Person("Alice");
        System.out.println("初始 person.name = " + p.name);
        p.name = "Bob"; // 记：final 引用不可变，但对象可变 -> 允许修改字段
        System.out.println("修改后 person.name = " + p.name);
        // p = new Person("Cathy"); // 取消注释会编译错误：无法为 final 变量 p 分配值

        // final 方法示例
        ChildWithFinalMethod child = new ChildWithFinalMethod();
        child.normalMethod();
        child.finalMethod();
        // 记：ChildWithFinalMethod 不能重写 ParentWithFinalMethod 中的 finalMethod。
        // 如果尝试在子类重写 finalMethod，则编译器会报错（示例中已遵守规则）。

        // final 类示例
        FinalClass f = new FinalClass();
        f.sayHello();
        // 记：不能写 class Sub extends FinalClass {} ，因为 FinalClass 是 final 的。
    }

    // 一个简单的类用于演示 final 引用的行为
    static class Person {
        public String name;
        public Person(String name) { this.name = name; }
    }

    // 父类：包含一个 final 方法和一个普通方法
    static class ParentWithFinalMethod {
        public void normalMethod() {
            System.out.println("ParentWithFinalMethod: normalMethod");
        }

        public final void finalMethod() {
            System.out.println("ParentWithFinalMethod: finalMethod (不能被子类重写)");
        }
    }

    static class ChildWithFinalMethod extends ParentWithFinalMethod {
        // 允许重写 normalMethod
        @Override
        public void normalMethod() {
            System.out.println("ChildWithFinalMethod: override normalMethod");
        }

        // 如果在此尝试重写 finalMethod，会导致编译错误（示例中不写重写体）
        // public void finalMethod() { ... } // 编译错误
    }

    // final 类示例
    static final class FinalClass {
        public void sayHello() {
            System.out.println("FinalClass: 我是 final 类的实例，不能被继承");
        }
    }


    // ============== 继承（extends）基础示例 ==============
    /*
    记：继承是面向对象的重要特性之一，用法及要点：
    - 子类使用 extends 关键字继承父类：class Child extends Parent {}
    - 子类会继承父类的非 private 成员（字段和方法）；private 成员不能直接访问。
    - 使用 super 关键字访问父类的成员或调用父类构造器（super(...)）。
    - 方法重写（override）：子类可以重写父类的方法，方法签名必须一致；推荐使用 @Override 注解。
    - 构造器：创建子类实例时，会先调用父类构造器（默认调用无参构造器），可以用 super(...) 指定父类构造器。
    - 多态相关：父类引用可以指向子类对象，方法在运行时根据实际对象类型决定调用哪个实现。
    */
    public static void inheritanceExamples() {
        // 示范：父类和子类
        AnimalParent parent = new AnimalParent("动物爸爸");
        parent.voice();

        // 子类继承父类
        DogChild dog = new DogChild("小狗");
        dog.voice(); // 子类重写了 voice()
        dog.parentVoice(); // 子类通过 super 调用父类的实现

        // 访问控制示例：protected 字段可以被子类访问
        System.out.println("dog.parentName (protected) = " + dog.getParentName());

        // 多态演示：父类引用指向子类对象
        AnimalParent poly = new DogChild("多态狗");
        poly.voice(); // 运行时调用子类的 voice()

        // 构造器调用顺序说明（构造器中有打印）
        System.out.println("查看构造器调用顺序见上面的输出（先父类后子类）");
    }

    static class AnimalParent {
        // protected：允许子类访问，但同包之外的非子类不能访问
        protected String parentName;

        public AnimalParent(String name) {
            this.parentName = name;
            System.out.println("AnimalParent 构造器：name=" + name);
        }

        public void voice() {
            System.out.println("AnimalParent: 我会叫（默认）");
        }
    }

    static class DogChild extends AnimalParent {
        public DogChild(String name) {
            // 使用 super 调用父类的构造器
            super(name + " 的子代");
            System.out.println("DogChild 构造器：name=" + name);
        }

        // 重写父类方法
        @Override
        public void voice() {
            System.out.println("DogChild: 汪汪（子类重写）");
        }

        public void parentVoice() {
            // 调用父类被重写的方法实现
            super.voice();
        }

        public String getParentName() {
            // 访问父类的 protected 字段
            return this.parentName;
        }
    }
}
