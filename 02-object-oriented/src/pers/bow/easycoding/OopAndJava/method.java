package pers.bow.easycoding.OopAndJava;

public class method {
/*方法
1.方法签名（包括方法名称和参数列表）
2.参数
    代码风格：约定在每一个逗号后必须要有一个空格，不管是形参，还是实参。
    形参
    实参
    可变参数（JDK5）：适用于不确定参数个数的场景（尽量不要使用，如果一定要用，一个方法中只能有一个可变参数，且要放在最后一个参数，建议不要用Object作为可变参数）。
        用“参数类型...”的方式定义,如：
        public PrintStream printf(String format, Object... args){
            return format(format, args);
        }
        //调用方法示例
        System.out.printf("%d", 8);
        System.out.printf("%d %s", 8, "145sad");

    参数预处理（方法体中应该对传入的参数保持理性不信任）
        （1）入参保护：批处理数据时，对参数数量进行判断
        （2）参数校验

3.构造方法
    在类中，初始化顺序：静态代码块->构造方法。其中静态代码块只会被执行一次，第二次对象实例化时，不会运行。

4.类内方法
    1.实例方法（非静态方法）：在对象被创建后才会分配入口地址
    2.静态方法：类加载后，即分配相应的内存空间
        ·静态方法中不能使用实例成员变量和实例方法
        ·不能用super和this关键字
        ·有依赖关系，注意使用静态成员或方法的先后顺序
    3.静态代码块（在构造方法前执行）

5.getter和setter
    一般不包含任何业务逻辑，仅仅是为类成员属性的读取和修改，好处
        ·满足面向对象的封装特性
        ·有利于统一控制
     因此，建议类内方法定义顺序：公有方法或保护方法 > 私有方法 > getter/setter方法
     容易出错的定义方式：
        ·getter/setter中添加业务逻辑
        ·同时定义isXxx()和getXxx()
        ·相同的属性名容易带来歧义

6.同步与异步

7.覆写 override
    向上转型：
        Father father = new Son();
        //Son覆写了此方法
        Father.doSomething();

        注意：
        ·无法调用到子类中存在而父类本身中不存在的方法
        ·可以通过用到子类中覆写看父类的方法，这是一种多态实现

    覆写的条件（一大两小两同 ）：
        ·访问权限不能变小
        ·返回类型能够向上转型成父类的返回类型
        ·异常也要能向上转型成父类的异常
        ·方法名、参数类型及个数必须严格一致（所有覆写的方法必须加上@Override注解）

    覆写只能针对非静态、非final、非构造方法。


*/

////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        //3
        new Son();
        new Son();
    }
}

class Parent {
    static {
        System.out.println("Parent静态代码块");
    }
    public Parent() {
        System.out.println("Parent构造方法");
    }
}

class Son extends Parent {
    static {
        System.out.println("Son静态代码块");
    }
    public Son() {
        System.out.println("Son构造方法");
    }
}