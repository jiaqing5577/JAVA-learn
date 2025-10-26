package _02object;

/*
枚举类（Enum）

枚举类型是Java 5中引入的一种特殊的数据类型，用于定义一组固定的常量。
枚举类隐式继承java.lang.Enum类，因此不能继承其他类，但可以实现接口。
*/

public class date08 {

    public static void main(String[] args) {

        // 1. 基本枚举使用
        System.out.println("\n--- 1. 基本枚举使用 ---");
        BasicEnumDemo.run();

        // 2. 带构造函数和字段的枚举
        System.out.println("\n--- 2. 带构造函数和字段的枚举 ---");
        EnumWithFieldsDemo.run();

        // 3. 带方法的枚举
        System.out.println("\n--- 3. 带方法的枚举 ---");
        EnumWithMethodsDemo.run();

        // 4. 实现接口的枚举
        System.out.println("\n--- 4. 实现接口的枚举 ---");
        EnumImplementingInterfaceDemo.run();

        // 5. 枚举常用方法
        System.out.println("\n--- 5. 枚举常用方法 ---");
        EnumMethodsDemo.run();
    }

    /*
    1. 基本枚举使用
    
    最简单的枚举类型只包含枚举常量。
    每个枚举常量都是该枚举类型的实例，且是public static final的。
    */
    static class BasicEnumDemo {
        // 定义一个简单的枚举类型
        enum Color {
            RED, GREEN, BLUE
        }

        static void run() {
            // 直接使用枚举常量
            Color c1 = Color.RED;
            System.out.println("颜色枚举值: " + c1);

            // 遍历所有枚举常量
            System.out.print("所有颜色: ");
            for (Color color : Color.values()) {
                System.out.print(color + " ");
            }
            System.out.println();

            // 使用switch语句
            switch (c1) {
                case RED:
                    System.out.println("红色");
                    break;
                case GREEN:
                    System.out.println("绿色");
                    break;
                case BLUE:
                    System.out.println("蓝色");
                    break;
            }
        }
    }

    /*
    2. 带构造函数和字段的枚举
    
    枚举可以有字段、构造函数和方法，使得枚举常量可以携带更多信息。
    枚举的构造函数必须是private或包私有的（默认就是private）。
    */
    static class EnumWithFieldsDemo {
        // 定义带有字段和构造函数的枚举
        enum Planet {
            MERCURY(3.303e+23, 2.4397e6),
            VENUS(4.869e+24, 6.0518e6),
            EARTH(5.976e+24, 6.37814e6),
            MARS(6.421e+23, 3.3972e6);

            private final double mass;   // 质量(千克)
            private final double radius; // 半径(米)

            // 构造函数必须是private（可以省略private关键字）
            Planet(double mass, double radius) {
                this.mass = mass;
                this.radius = radius;
            }

            // 获取字段的方法
            double getMass() {
                return mass;
            }

            double getRadius() {
                return radius;
            }

            // 计算表面重力加速度
            double surfaceGravity() {
                final double G = 6.67300E-11;
                return G * mass / (radius * radius);
            }
        }

        static void run() {
            // 使用枚举常量
            Planet earth = Planet.EARTH;
            System.out.println("地球质量: " + earth.getMass() + " 千克");
            System.out.println("地球半径: " + earth.getRadius() + " 米");
            System.out.println("地球表面重力加速度: " + earth.surfaceGravity() + " m/s^2");

            // 遍历所有行星
            System.out.println("\n所有行星信息:");
            for (Planet planet : Planet.values()) {
                System.out.printf("%s: 质量=%.2e 千克, 半径=%.2e 米%n",
                        planet, planet.getMass(), planet.getRadius());
            }
        }
    }

    /*
    3. 带方法的枚举
    
    枚举可以定义抽象方法，每个枚举常量都需要实现该方法。
    也可以定义普通方法供所有枚举常量共享。
    */
    static class EnumWithMethodsDemo {
        // 定义带抽象方法的枚举
        enum Operation {
            PLUS {
                public double apply(double x, double y) {
                    return x + y;
                }
            },
            MINUS {
                public double apply(double x, double y) {
                    return x - y;
                }
            },
            TIMES {
                public double apply(double x, double y) {
                    return x * y;
                }
            },
            DIVIDE {
                public double apply(double x, double y) {
                    return x / y;
                }
            };

            // 抽象方法，每个枚举常量都必须实现
            public abstract double apply(double x, double y);
        }

        static void run() {
            double x = 5.0;
            double y = 3.0;

            // 遍历所有操作并执行
            for (Operation op : Operation.values()) {
                System.out.printf("%.1f %s %.1f = %.1f%n",
                        x, op, y, op.apply(x, y));
            }
        }
    }

    /*
    4. 实现接口的枚举
    
    枚举可以实现一个或多个接口，为枚举常量提供统一的行为规范。
    */
    static class EnumImplementingInterfaceDemo {
        // 定义接口
        interface Drawable {
            void draw();
        }

        // 实现接口的枚举
        enum Shape implements Drawable {
            CIRCLE {
                public void draw() {
                    System.out.println("绘制圆形");
                }
            },
            RECTANGLE {
                public void draw() {
                    System.out.println("绘制矩形");
                }
            },
            TRIANGLE {
                public void draw() {
                    System.out.println("绘制三角形");
                }
            };

            // 可以覆盖接口方法，也可以添加枚举特有的方法
            @Override
            public String toString() {
                return "形状: " + super.toString();
            }
        }

        static void run() {
            // 使用实现了接口的枚举
            for (Shape shape : Shape.values()) {
                System.out.print(shape + " -> ");
                shape.draw();
            }
        }
    }

    /*
    5. 枚举常用方法
    
    Java枚举类继承自java.lang.Enum，拥有一些有用的方法：
    - values(): 返回枚举常量数组
    - valueOf(String name): 根据名称返回枚举常量
    - ordinal(): 返回枚举常量的位置索引（从0开始）
    - name(): 返回枚举常量的名称
    - compareTo(): 比较枚举常量的顺序
    */
    static class EnumMethodsDemo {
        enum Day {
            MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
        }

        static void run() {
            // values()方法
            System.out.println("所有星期:");
            Day[] days = Day.values();
            for (int i = 0; i < days.length; i++) {
                System.out.println((i + 1) + ". " + days[i]);
            }

            // valueOf()方法
            Day day = Day.valueOf("FRIDAY");
            System.out.println("\nvalueOf(\"FRIDAY\"): " + day);

            // ordinal()方法
            System.out.println("\n各天的序号:");
            for (Day d : Day.values()) {
                System.out.println(d + " 的序号是: " + d.ordinal());
            }

            // name()方法
            System.out.println("\nname()方法:");
            System.out.println("MONDAY.name(): " + Day.MONDAY.name());

            // compareTo()方法
            System.out.println("\ncompareTo()方法:");
            System.out.println("MONDAY.compareTo(WEDNESDAY): " + Day.MONDAY.compareTo(Day.WEDNESDAY));
            System.out.println("WEDNESDAY.compareTo(MONDAY): " + Day.WEDNESDAY.compareTo(Day.MONDAY));
            System.out.println("TUESDAY.compareTo(TUESDAY): " + Day.TUESDAY.compareTo(Day.TUESDAY));
        }
    }
}