# 详解xml头部问题

下面的片段

```xml
xmlns="http://www.w3school.com.cn"
```

规定了默认命名空间的声明。此声明会告知 schema 验证器，在此 XML 文档中使用的所有元素都被声明于 `"http://www.w3school.com.cn"` 这个命名空间。

一旦您拥有了可用的 XML Schema 实例命名空间：

```xml
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
```

您就可以使用 schemaLocation 属性了。此属性有两个值。第一个值是需要使用的命名空间。第二个值是供命名空间使用的 XML schema 的位置：

```xml
xsi:schemaLocation="http://www.w3school.com.cn note.xsd"
```
