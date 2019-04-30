/*日志

1.日志规范
    推荐的日志命名方式：appName_logType_logName.log
    其中logType分类建议：stats（统计数据）、monitor（监控）、visit等

    保存时间：至少存放15天

    日志级别：
        ·DEBUG级别日志：记录对调试程序有帮助的信息
        ·INFO级别日志：用来记录程序运行现场，虽然此处并未发生错误，但是排查其他错误有指导意义
        ·WARN级别日志：也可以用来纪律程序运行现场，但是更偏向于表名此处有出现潜在的错误的可能
        ·ERROR级别日志：表明当前程序运行发生了错误，需要被关注。但是当权发生的错误，没有影响系统的继续运行
        ·FATAL级别日志：表明当前的程序运行出现了严重的错误事件，并且将会导致应用程序中断

    1）预先判断日志级别
        在某个配置了打印日志级别为WARN的应用中，如果针对DEBUG级别的日志，仅仅在程序中写出logger.debug("xxxxx"+id+"and"+symbol);那么该日志不会被打印，但是会执行字符串凭借操作，浪费资源
        //使用条件判断形式
            if (logger.isDebugEnabled()) {
                logger.debug("....." + id + "and" + symbol);
            }
        //使用占位符形式
        logger.debug("....: {} and {}", id, symbol);
    2）避免无效日志打印
        生产环境禁止输出DEBUG日志，且有选择的输出INFO日志
        使用INFO、WARN级别的时候，需要注意控制输出量，避免空间不足，还有日志生命周期
        避免重复打印，务必在日志配置文件中设置additivity=false,如：
            <logger name = "com.taobao.ecrm.member.config" additivity="false">
    3）区别对待错误日志
        ERROR级别只记录系统逻辑错误、异常或违反重要的业务规则，其他错误都可以归为WARN级别。
    4）保证记录内容完整
        ·记录异常时一定要输出异常堆栈，例如logger.error("xxx"+e.getMessage(),e)
        ·日志中如果输出对象实例，要确保实例类重写了toString方法，否则只会输出对象的hashCode值，没有实际意义

    综上要确定：
        ·日志是否有人看
        ·看到这条日志能做什么
        ·能不能提升问题排查效率


2.日志框架
    ·日志门面
    ·日志库
    ·日志适配器

    推荐使用slf4j+logback模式
    新Maven工程：
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-api</artifactId>
        <version>${slf4j-api.version}</version>
    </dependency>
    <dependency>
        <groupId>ch.qos.logback</groupId>
        <artifactId>logback-classic</artifactId>
        <version>${logback-classic.version}</version>
    </dependency>
    <dependency>
        <groupId>ch.qos.logback</groupId>
        <artifactId>logback-core</artifactId>
        <version>${logback-core.version}</version>
    </dependency>

    老工程：
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-api</artifactId>
        <version>${slf4j-api.version}</version>
    </dependency>
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-log4j12</artifactId>
        <version>${slf4j-log4j12.version}</version>
    </dependency>
    <dependency>
        <groupId>log4j</groupId>
        <artifactId>log4j</artifactId>
        <version>${log4j.version}</version>
    </dependency>

    如果老工程中直接使用了log4j日志库提供的接口来打印日志，还需要引入日志库适配器，配置实例如下：
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>log4j-over-slf4j</artifactId>
        <version>${log4j-over-slf4j.version}</version>
    </dependency>

    最后再加一个一个日志配置文件（如 logback.xml、log4j.xml等），并在工程启动时加载，然后就可以进行日志打印了，实例：
        private static final Logger logger = LoggerFactory.getLogger(Abc.class);
        注意这里的static
        另外在使用slf4+ 日志库模式时，要防止日志库冲突（比如使用了Log4j日志库但是间接的引入了一个logback日志库），否则可能引起打印失效。


 */

public class Log {
}
