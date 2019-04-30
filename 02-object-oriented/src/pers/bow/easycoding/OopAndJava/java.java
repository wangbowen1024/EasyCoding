package pers.bow.easycoding.OopAndJava;
/*JAVA
1.类的定义
    成员
    方法：公有方法放在首屏，getter/stter放在最后
2.接口与抽象类
    不能被实例化，但可以定义引用变量指向实例对象

    语法区别
    语法维度                抽象类             接口
    定义关键字              abstract           interface
    子类继承或实现关键字    extends            implements
    方法实现                可以有             不能有，但在JDK8之后，允许有default实现
    方法访问控制符          无限制             有限制，默认是public abstract类型
    属性访问控制符          无限制             有限制，默认是public static final类型
    静态方法                可以有             不能有
    static{}静态代码块      可以有             不能有
    本类型之间扩展          单继承             多继承
    本类型之间扩展关键字    extends            extends

--------
    接口：can-do
          文件名：VehicleSaf.java
          public interface VehicleSaf [extends 接口名1,接口名2] {
              //变量（默认是public static final）
              //方法（默认是public abstract，只声明方法，不能实现）
              double brake(int initSpeed, int brakeTime);
          }
          与类的区别
          1.接口不能用于实例化对象。
          2.接口没有构造方法。
          3.接口中所有的方法必须是抽象方法。
          4.接口不能包含成员变量，除了 static 和 final 变量。
          5.接口不是被类继承了，而是要被类实现。
          6.接口支持多继承。

    抽象类：is-a
        抽象类总结规定
        1. 抽象类不能被实例化(初学者很容易犯的错)，如果被实例化，就会报错，编译无法通过。只有抽象类的非抽象子类可以创建对象。
        2. 抽象类中不一定包含抽象方法，但是有抽象方法的类必定是抽象类。
        3. 抽象类中的抽象方法只是声明，不包含方法体，就是不给出方法的具体实现也就是方法的具体功能。
        4. 构造方法，类方法（用 static 修饰的方法）不能声明为抽象方法。
        5. 抽象类的子类必须给出抽象类中的抽象方法的具体实现，除非该子类也是抽象类。

3.内部类
    静态内部类（常用，如Map中Node）
    成员内部类
    局部内部类
    匿名内部类（如线程启动）

4.访问控制权限

    访问权限控制符         任何地方        包外子类        包内      类内
    public                 OK              OK              OK        OK
    protected              NO              OK              OK        OK
    无                     NO              NO              OK        OK
    private                NO              NO              NO        OK

    访问控制级别从严处理：
    （1）如果不允许外部直接通过new创建对象，构造方法必须是private
    （2）工具类不允许有public或default构造方法
    （3）类非static成员变量并且与子类共享，必须是protected
    （4）类非static成员变量并且仅在本类使用，必须是private
    （5）类static成员变量如果仅在本类使用，必须是private
    （6）若是static成员变量，必须考虑是否为final
    （7）类成员方法只供类内部调用，必须是private
    （8）类成员方法只对继承类公开，那么限制为protected


5.this和super
    在一个构造方法中必须出现在第一行。只能使用this或者super之一，且只能出现一次
    不能再静态方法和静态代码块中使用this和super关键字

    关键字     基本概念                             查找范围                        特异功能
    this       访问本类实例属性和方法               先找本类，没有找父类            单独使用时，表示当前对象
    super      由子类访问父类中的实例属性和方法     直接查找父类                    在子类覆写父类方法时，访问父类的同名方法

    共同点：（1）都是关键字，起指代作用
            （2）在构造方法中必须出现在第一行

6.类关系
    继承、实现、组合、聚合、依赖

7.序列化
    （1）Java原生序列化（不推荐）
    （2）Hessian序列化
    （3）JSON序列化

    注意：应用开发者对序列化要有一定的安全防范意识，对传入数据的内容进行校验或权限控制，及时更新安全漏洞，避免受到攻击。
    https://www.cnblogs.com/ssooking/p/5875215.html

 */


public class java {
}
