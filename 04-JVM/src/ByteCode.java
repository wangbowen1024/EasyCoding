/*
字节码

1.字节码主要指令如下
    加载或存储指令
        ·将局部变量加载到操作栈中。
            如：ILOAD（将int类型的局部变量压入栈）和ALOAD（将对象引用的局部变量压入栈）
        ·从操作栈顶存储到局部变量表
            如：ISTORE、ASTORE等
        ·将常量加载到操作栈顶，这是极为高频使用的指令
            如：ICOUNT、BIPUSH、SIPUSH、LDC等
    运算指令
        ·对两个操作栈帧上的值进行运算，并把结果写入操作栈顶
            如：IADD、IMUL等
    类型转换指令
        ·显示转换两种不同的数值类型
            如：I2L、D2F等
    对象创建与访问指令
        ·创建对象指令
            如：NEW、NEWARRAY等
        ·访问属性指令
        ·检查实例类型指令
    操作栈管理指令
        ·出栈操作
        ·复制栈顶元素并压入栈
    方法调用与返回指令
    同步指令

    源码如何转为字节码？
        JAVA源文件 -> 词法解析 ----token流---> 语法解析 -> 语义分析 -> 生成字节码 -> 字节码


类加载过程

1.Class类
    获取Class类：private static Class<One> one = One.class;
    创建一个对象：One oneObject = one.newInstance();
        ·newInstance()在JDK9中已经是过时的，使用getDeclaredConstructor().newInstance()的方式。
        ·和new的区别：newInstance是弱类型，只能调用无参的构造方法，如果没有默认构造方法抛出异常。
                       new是强类型，可以调用任何构造方法，在使用new的时候，这个类可以没有被加载过。
    获取对象的私有成员属性对象Field：Field privateFieldInOne = one.getDeclaredField("inner");
        可以用此类似的方式获取其他声明，如注解、方法等。
    设置私有对象可任意访问和修改:
        privateFieldInOne.setAccessible(true);
        privateFieldInOne.set(oneObject, "HI");//可以在类外修改私有成员

2.类加载器
    自定义类加载器的情况：
        ·隔离加载类
        ·修改类的加载方式
        ·扩展加载器
        ·防止源码泄露


内存布局

1.Heap（堆区）
2.Metaspace（元空间）
3.JVM Stack（虚拟机栈）
    ·局部变量表
    ·操作栈
    ·动态连接
    ·方法返回地址

4.本地方法栈
5.程序计数寄存器


对象实例化

垃圾回收




 */

public class ByteCode {
}
