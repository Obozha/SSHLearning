# tomcat

## 设置用户名+密码

/conf/tomcat-users.xml修改

```xml
<user username="tomcat" password="1234" roles="admin-gui,admin-script,manager-gui,manager-script,manager-jmx,manager-status"/>
```

## 运行时候弹出

需要写一个web项目

## tomcat关于eclipse同步问题

问题描述

> tomcat在eclipse一启动，就把在tomcat目录下的tomcat-users文件修改

解决办法

直接在eclipse修改tomcat-users文件