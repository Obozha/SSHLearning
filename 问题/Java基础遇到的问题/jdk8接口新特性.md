# 接口中的default和static

文件目录

```txt
.
├── Main.java
├── MyInterface1.java
└── MyInterface2.java
```

`MyInterface1.java`

```java
public interface MyInterface1 {
}
```

`MyInterface2.java`

```java
/**
 *
 * @author Administrator
 * jdk8中为了加强接口的能力，使得接口可以存在具体的方法，前提是方法需要被default和static关键字所修饰
 *
 * 这样做的好处是接口的每个实现类如果都要想实现相同的功能，就不需要重复代码，而是在接口进行定义即可。
 * 默认方法在子类也可以被重写
 */
public interface MyInterface2 extends MyInterface1{


    default void helloDefault() {
        System.out.println("helloDefault");
    }

    static void helloStatic() {
        System.out.println("helloStatic");
    }
}
```

`Main.java`

```java
public class Main {

    public static void main(String[] args) {
        MyInterface2 mInterface2=new MyInterface2() {
        };
        mInterface2.helloDefault();
        MyInterface2.helloStatic();
    }
}
```
