# Redis&nosql

## NoSQL

NoSQL(NoSQL = Not Only SQL) 全新db理念，泛指非关系型数据库

### 为什么需要

因为

* high performance - 对数据库高并发和读写需求
* huge storage - 海量数据的高效率存储和访问
* high scalability&&high availability - 对数据库的高可扩展性和高可用性需求

### 主流NoSQL

* 键值对（Key-value）
  * 相关产品：tokyo cabinet/tyrant、redis、voldemort
  * 典型应用：内容缓冲，主要用于处理大量数据的高访问负载
  * 数据模型：一系列键值对
  * 优势：快速查询
  * 劣势：存储的数据结构缺少结构化
* 列存数据库
  * 相关产品：cassandra，hbase，riak
  * 典型应用：分布式的文件系统
  * 数据模型：以列簇式存储，更容易进行分布式扩展
  * 劣势：功能相对局限
* 文档型数据库
  * 相关产品：couchDB、mongoDB
  * 典型应用：web应用（与key-value类似，value是结构化的）
  * 数据模型：一系列键值对
  * 优势：数据结构要求不严格
  * 劣势：查询性能不高，缺少统一的查询语法
* 图形（graph）数据库
  * 相关数据库：neo4j，infoGrid，infinite graph
  * 典型应用：社交网络
  * 数据模型：图结构
  * 优势：利用图结构算法。
  * 劣势：需要对整个图做计算才得到结果，不容易做分布式的集群方案。

### nosql特点

* 易扩展
* 大数据量，高性能
* 灵活的数据模式
* 高可用

## Redis

redis是c开发开源高性能键值对数据库，支持的key-value类型为

* 字符串模式
* 散列类型
* 列表类型
* 集合类型
* 有序集合类型

### redis应用场景

* 缓存（ 数据查询 | 短链接 | 新闻内容 | 商品内容等）（最多使用）
* 聊天室在线好友列表
* 任务队列（秒杀 | 抢购 | 12306等）
* 应用排行榜
* 网站访问统计
* 数据过期处理（可以精确到毫秒）
* 分布式集群架构中的session分离

### redis安装

见Linux安装软件

#### 向redis服务器发送命令

* ping 测试客户端与redis连接是否正常，正常会收到pong

    ```txt
    192.168.80.10:6379> ping
    PONG
    ```

* set/get 使用set和get可以向redis设置数据，获取数据
  
    ```txt
    192.168.80.10:6379> set name tom
    OK
    192.168.80.10:6379> get name
    "tom"
    ```

* del 删除指定key

    ```txt
    192.168.80.10:6379> del name
    (integer) 1
    192.168.80.10:6379> get name
    (nil)
    ```

## jedis

redis不仅用命令操作，基本主流语言都有客户端支持，例如java c c++ c# php node.js go

官方有很多java客户端，jedis redisson jredis jdbc-redis，官方推荐jedis redisson，企业最多jedis

## jedis使用

* 导入jar `jedis-2.7.0.jar` `commons-pool2-2.3.jar`

### 单实例连接

```java
public static void main(String[] args) {
        // 1.设置ip地址和端口
        Jedis jedis = new Jedis("192.168.80.10", 6379);
        // 2.设置密码
        jedis.auth("helloworld");
        // 3.设置数据
        jedis.set("name", "zhangsan");

        // 4. 获得数据
        String hello = jedis.get("name");

        System.out.println(hello);

        // 5. 释放资源
        jedis.close();
    }
```

注意：如果抛出连接超时异常，检查防火墙开了没

### 连接池连接

```java
public class TestJedisPool {
    /**
    * @param args
    */
    /**
    * @param args
    */
    public static void main(String[] args) {
        // 1.获得连接池配置对象，设置配置项
        JedisPoolConfig config = new JedisPoolConfig();

        // 2. 设置最大连接数
        config.setMaxTotal(30);
        // 3. 设置最大空闲连接数
        config.setMaxIdle(10);

        // 4. 获得连接池
        JedisPool jedisPool = new JedisPool(config, "192.168.80.10", 6379);

        // 5. 获得核心对象
        Jedis jedis = null;

        try {
            jedis = jedisPool.getResource();
            jedis.auth("helloworld");

            // 6. 设置数据
            jedis.set("name", "tom");

            // 7. 获得对象
            String name = jedis.get("name");
            System.out.println(name);

        } catch (Exception e) {
        } finally {
            if (jedis != null) {
                jedis.close();
            }
            // 虚拟机关闭时候，释放pool资源
            if (jedisPool != null) {
                jedisPool.close();
            }
        }
    }
}
```

## Redis的数据结构

redis是一种高级的key-value的存储系统，其中value支持五种数据类型。

* string - 字符串
* hash - 哈希
* list - 字符串列表
* set - 字符串集合
* sorted set - 有序字符串集合

关于key，需要注意

1. key不要太长，最好不要操作1024个字节，这不仅消耗内存还会降低查找效率
2. key不要太短，如果太短降低key的可读性
3. 在项目中，key最好有一个统一的命名规则

### 存储string

字符串类型是redis中最为基础的数据存储类型，它在redis中是二进制安全的，这便意味着该类型存入和获取的数据相同，在redis中字符串类型的value最多可以容纳的长度是512M

> 二进制安全的意思是：只关心二进制化的字符串,不关心具体格式.只会严格的按照二进制的数据存取。不会妄图已某种特殊格式解析数据。

#### 赋值

* set key value - 设定key持有特定的字符串value，如果该key存在则进行附改操作，总是返回OK

    ```txt
    192.168.80.10:6379> set key name
    OK
    ```

#### 取值

* get key - 获取key的value值，如果与该key关联的value不是string，redis将会返回错误信息，因为get命令只能回去string value，如果不存在，返回nil

    ```txt
    192.168.80.10:6379> get name
    "tom"
    192.168.80.10:6379> get name2
    (nil)
    ```

* getset key value - 先获取该key的值，在设置

    ```txt
    192.168.80.10:6379> getset name aa
    "tom"
    192.168.80.10:6379> get name
    "aa"
    ```

#### 删除

* del key - 删除key

    ```txt
    192.168.80.10:6379> set person tom
    OK
    192.168.80.10:6379> get person
    "tom"
    192.168.80.10:6379> del person
    (integer) 1
    192.168.80.10:6379> get person
    (nil
    ```

#### 数值增减

* incr key - 将指定的key的value原子性的递增1 如果该key不存在，其初始值为0，在incr之后其值为1，如果该value不能转成整形，如hello，该操作将执行失败并返回相应的错误信息。

    ```txt
    192.168.80.10:6379> incr num
    (integer) 1
    192.168.80.10:6379> incr num
    (integer) 2
    192.168.80.10:6379> incr num
    (integer) 3
    192.168.80.10:6379> incr num
    (integer) 4
    192.168.80.10:6379> get num
    "4"
    192.168.80.10:6379> del num
    (integer) 1
    192.168.80.10:6379> get num
    (nil)
    ```

* decr key - 将指定的key的value原子性-1，如果该value不能转成整形，如hello，该操作将执行失败并返回相应的错误信息。

    ```txt
    192.168.80.10:6379> decr n
    (integer) -1
    ```

#### 扩展命令

* incrby key increment key的value原子性增加increment

    ```txt

    ```

* decrby key decrement key的value原子性减少decrement
* append key value 拼凑字符串，如果key存在，追加其值