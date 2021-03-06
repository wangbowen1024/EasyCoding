/*代码风格

0.代码元素：包括类、方法、参数、常量、变量等程序中的各种要素

1.命名规约
    1.1 命名符合本语言特征
            如：在JAVA中，所有代码元素的命名均不能以下划线开头或美元符号开始或结束
    1.2 命名体现代码元素特征
            类名：采用大驼峰形式，一般为名词（如，Object、StringBuffer）。
            方法名：采用小驼峰形式，一般为动词，与参数组成动宾结构。
            变量：包括参数、成员变量、局部变量等，也采用小驼峰形式。
            常量：字母全部大写，单词之间用下划线连接

            推荐在JAVA命名时，以下列方式体现元素特征：
                ·包名统一使用小写，点分隔符之间有且仅有一个自然语义的英语单词。包名统一使用单数形式，但是类名如果有复数含义，则可以用复数形式。
                ·抽象类命名使用Abstract或Base开头；异常类命名使用Exception结尾；测试类命名以它要测试的类名开始，以Test结尾。
                ·类型与中括号紧挨相连起来定义数组。
                ·枚举类名带上Enum后缀，枚举成员名称全部大写，单词间用下划线隔开。
    1.3 命名最好望文知义
        ·常量（一般用final关键字进行修饰）
            全局变量：public static final修饰
            类内常量：private static final修饰
            ！以上2种常量，命名字母全部大写，单词间用下划线隔开
            局部常量：分为方法常量和参数常量，后者在定义形参时，增加final标识，表示此参数不能被修改
            ！用小驼峰即可

            在表示状态等信息时候，不要用1，2，3，4。可以用枚举
        ·变量
            在定义类成员变量的时候，特别是针对布尔类型，命名不要加is前缀，否则部分框架会引发序列化错误。如Boolean isDeleted，它的getter方法也是isDeleted()

2.代码展示风格
    2.1 缩进、空格与空行
        缩进
            表示层次对应关系。推荐采用4各空格缩进，禁止Tab键。可以对IDE工具设置Tab格式为4个空格
        空格
            ·任何二目、三目运算符的左右两边都必须加一个空格
            ·注释的双斜线与注释内容之间有且仅有一个空格
            ·方法参数在定义和传入时，多个参数逗号后边必须加空格
            ·没有必要增加若干空格使变量的赋值等号与上一行对应位置的等号对齐
            ·如果使左大括号内为空，则简洁写成{}即可，大括号中间无需换行和空格
            ·左右小括号与括号内部的相邻字符之间不要出现空格
            ·左大括号前需要加空格
            ·在关键词if与左侧小括号之间必须有一个空格，else前后都必须加空格
        空行
            用来分割功能相似、逻辑内聚、意思相近的代码片段
            使用地方：在方法定义之后、属性定义与方法定义之间、不同逻辑、不同语义、不同业务的代码之间
    2.2 换行与高度
        换行
            代码中需要限定每行的字符个数，以便适配显示器的宽度，以及方便CodeReview时进行diff比对。因此约定单行字符数不超过120个，超出换行，换行时规则：
                ·第二行相对于第一行缩进4个空格，从第三行开始，不再继续缩进
                ·运算符与下文一起换行
                ·方法调用的点符号与下文一起换行
                ·方法调用中的多个参数需要换行时，在逗号后换行
                ·在括号前不要换行
        方法行数限制
            不要把不同层次的逻辑写在一个大方法体内，应该将次要的逻辑抽取为独立方法，将共性逻辑抽取成共性方法（如参数校验，权限判断等），便于复用和维护
            高内聚、低耦合（规定单个方法的总行数不超过80行，判定标准如下：）
                ·除注释之外，方法签名、左右大括号、方法内代码、空行、回车及任何不可见字符的总行数不超过80行
                为什么是80行？心理学认为，三屏是人类短期记忆极限。80行一般是2.5屏。阿里代码只有5%不到的代码超过80行，且都有优化空间。
        控制语句
            控制语句是最容易出现BUG的地方，必须遵循以下约定：
                ·在if、else、for、while、do-while等语句中必须使用大括号。即使只有一行代码
                ·在条件表达式中不允许有赋值操作，也不允许在判断表达式中出现复杂的逻辑组合
                    有些控制语句的表达式很复杂，与、或、取反混合运算甚至穿插赋值操作，理解成本很高，甚至有误解。解决这个问题很简单：将复杂的逻辑运算赋值给一个具有逻辑业务含义的布尔变量
                    如：
                    final boolean existed = (file.open(fileName, "w") != null) && (...) || !(...);
                    if (existed) {
                        ...
                    }
                ·多层嵌套不能超过3层。可以用卫语句、策略模式、状态模式等来实现
                ·避免采用取反逻辑运算符

3.代码注释
    3.1 注释三要素
        ·Nothing is strange
            提倡写注释，然后才是写的精简。业务逻辑需要不断的维护更新，而JDK源码不会一直更改。
        ·Less is more
            真正好的代码是自解释的，即准确的变量名，加上合理的代码逻辑，无须过多的文字说明。
            泛滥的注释不需要，如put(elephant, fridge);已经很明确了不要在加注释// put elephant into fridge
        ·Advance with the times
            任何对代码的修改，都应该同时修改注释
    3.2 注释格式
        Javadoc规范
            类、类属性和类方法的注释必须遵循Javadoc规范，使用文档注释（/** *)/的格式。按照Javadoc规范编写的注释，可以生成规范的API文档。
            对枚举的注释是必须的：
                ·枚举实在太特殊了，它的代码极为稳定。如果定义和使用出现错误，通常影响较大
                ·注释的内容不仅限于解释属性的含义，还可以包括注意事项、业务逻辑。如果在原有枚举类上新增、修改属性值，还要加上创建和修改的时间
                ·枚举类的删除或者修改都存在很大的风险。不可直接删除过时属性，需要标注为过时，同时注释说明过时的逻辑考虑和业务背景
        简单注释
            包括单行注释和多行注释。此类注释不允许写在代码后方，必须写在代码上方。双画线注释往往使用在方法内部，此时作用应该为画龙点睛的


 */

public class codeStyle {
    // 常量
    public static final String GLOBAL_CONSTANT = "shared in global";
    private static final String CLASS_CONSTANT = "shared in class";

    public void f(String a) {
        final String methodConstant = "shared in method";
    }

    public void g(final int b) {
        // 编译出错，不允许对常量参数进行重新赋值
        // b = 4;
    }

}
