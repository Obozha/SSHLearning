# log4j

## 入门

* 新建maven工程
* pom.xml加入依赖

    ```xml
    <dependencies>
        <dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <version>1.2.15</version>
        </dependency>
    </dependencies>
    ```

* src新建资源文件夹config
* 在config中建立log4j.properties

    ```txt
    ### 设置
    log4j.rootLogger = debug,stdout,D,E

    ### 输出信息到控制台 ###
    log4j.appender.stdout = org.apache.log4j.ConsoleAppender
    log4j.appender.stdout.Target = System.out
    log4j.appender.stdout.layout = org.apache.log4j.PatternLayout
    log4j.appender.stdout.layout.ConversionPattern = [%-5p] %d{yyyy-MM-dd HH:mm:ss,SSS} method:%l%n%m%n

    ### 输出DEBUG级别以上的日志到=E://logs/error.log ###
    log4j.appender.D = org.apache.log4j.DailyRollingFileAppender
    log4j.appender.D.File = E://logs/log.log
    log4j.appender.D.Append = true
    log4j.appender.D.Threshold = DEBUG
    log4j.appender.D.layout = org.apache.log4j.PatternLayout
    log4j.appender.D.layout.ConversionPattern = %-d{yyyy-MM-dd HH:mm:ss}  [ %t:%r ] - [ %p ]  %m%n

    ### 输出ERROR级别以上的日志到E://logs/error.log ###
    log4j.appender.E = org.apache.log4j.DailyRollingFileAppender
    log4j.appender.E.File =E://logs/error.log
    log4j.appender.E.Append = true
    log4j.appender.E.Threshold = ERROR
    log4j.appender.E.layout = org.apache.log4j.PatternLayout
    log4j.appender.E.layout.ConversionPattern = %-d{yyyy-MM-dd HH:mm:ss}  [ %t:%r ] - [ %p ]  %m%n
    ```

* main函数

    ```java
    public class Log4JTest {

        private static Logger logger = Logger.getLogger(Log4JTest.class);

        public static void main(String[] args) {
            // 记录debug级别的信息
            logger.debug("This is debug message");

            // 记录info级别的信息
            logger.info("This is debug message");

            // 记录error级别的信息
            logger.error("This is debug message");
        }
    }
    ```

## Log4j的基本用法

Log4j由三个重要的组件构成

* 日志信息的优先级
    > 日志优先级从高到低ERROR-->WARN-->INFO-->DEBUG，分别指定这条日志信息的重要程度

* 日志信息的输出目的地
    > 日志信息的输出目的地指定了日志将打印到控制台还是文件中

* 日志信息的输出格式
    > 输出格式则控制了日志信息的显示内容。

### 定义配置文件

Log4j支持两种配置方法

* 使用Log4j实例直接配置
* 使用文件配置 - XML |  log4j.properties

这里只说log4j.properties配置方法

### 配置根Logger

* 语法是

    ```txt
    log4j.rootLogger = [ level ] , appenderName, appenderName, …
    ```

其中，level是日志记录的优先级，分别是分为OFF、FATAL、ERROR、WARN、INFO、DEBUG、ALL或者您定义的级别。
Log4j建议用这四个ERROR、WARN、INFO、DEBUG

定义了INFO，那么DEBUG打不出来，appenderName指日志输出位置，可以输出多个输出地址

### 配置日志信息输出目的地Appender

* 其语法为：

    ```txt
    log4j.appender.appenderName = fully.qualified.name.of.appender.class  
    log4j.appender.appenderName.option1 = value1  
    …  
    log4j.appender.appenderName.option = valueN
    ```

* 其中Log4j提供的appender有以下几种

    ```txt
    org.apache.log4j.ConsoleAppender（控制台），  
    org.apache.log4j.FileAppender（文件），  
    org.apache.log4j.DailyRollingFileAppender（每天产生一个日志文件），  
    org.apache.log4j.RollingFileAppender（文件大小到达指定尺寸的时候产生一个新的文件），  
    org.apache.log4j.WriterAppender（将日志信息以流格式发送到任意指定的地方）
    ```

### 配置日志信息格式（布局）

* 其语法为

    ```txt
    log4j.appender.appenderName.layout = fully.qualified.name.of.layout.class  
    log4j.appender.appenderName.layout.option1 = value1  
    …  
    log4j.appender.appenderName.layout.option = valueN
    ```

* 其中log4j提供的layout有以下几种

    ```txt
    org.apache.log4j.HTMLLayout（以HTML表格形式布局），  
    org.apache.log4j.PatternLayout（可以灵活地指定布局模式），  
    org.apache.log4j.SimpleLayout（包含日志信息的级别和信息字符串），  
    org.apache.log4j.TTCCLayout（包含日志产生的时间、线程、类别等等信息）
    ```

* Log4j采用类似C语言中的printf函数的打印格式化日志信息，打印参数如下

    ```txt
    %p 输出优先级，即DEBUG，INFO，WARN，ERROR，FATAL  
    %r 输出自应用启动到输出该log信息耗费的毫秒数  
    %c 输出所属的类目，通常就是所在类的全名  
    %t 输出产生该日志事件的线程名  
    %n 输出一个回车换行符，Windows平台为“rn”，Unix平台为“n”  
    %d 输出日志时间点的日期或时间，默认格式为ISO8601，也可以在其后指定格式，比如：%d{yyy MMM dd HH:mm:ss,SSS}，输出类似：2002年10月18日 22：10：28，921  
    %l 输出日志事件的发生位置，包括类目名、发生的线程，以及在代码中的行数。举例：Testlog4.main(TestLog4.java:10)
    %m 输出log信息
    ```
