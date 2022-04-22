# qainyu-shop
具有隐私保护的网络购物平台

## 项目配置

### 1. vue前端项目安装部署

1. 安装node.js

    **node.js官网下载安装：**https://nodejs.org/zh-cn/

2. 安装vue-cli

    **vue官网地址：**https://v3.cn.vuejs.org/guide/installation.html#%E5%91%BD%E4%BB%A4%E8%A1%8C%E5%B7%A5%E5%85%B7-cli

    **下载安装vue-cli**

    ```
    npm install -g @vue/cli
    ```

3. 创建前端基础项目

    ```
    vue create shop-client(前端项目名)
    ```

    选择好配置创建完成

4. 安装element-ui plus

    ```
    npm install element-plus --save
    ```

5. 项目结构

    ![image-20220110122950626](https://gitee.com/vvwhyyy/pic/raw/master/img/202201101230324.png)

6. 项目启动测试

    ![image-20220110124652216](https://gitee.com/vvwhyyy/pic/raw/master/img/202201101246664.png)

### 2. springboot后端项目安装部署

1. 创建springboot项目

    **spring官网：**https://start.spring.io/

2. 引入依赖

    ```xml
    <dependencies>
    		<dependency>
    			<groupId>org.springframework.boot</groupId>
    			<artifactId>spring-boot-starter-web</artifactId>
    		</dependency>
    		<dependency>
    			<groupId>org.mybatis.spring.boot</groupId>
    			<artifactId>mybatis-spring-boot-starter</artifactId>
    			<version>2.2.0</version>
    		</dependency>
    
    		<dependency>
    			<groupId>mysql</groupId>
    			<artifactId>mysql-connector-java</artifactId>
    			<scope>runtime</scope>
    		</dependency>
    		<dependency>
    			<groupId>com.baomidou</groupId>
    			<artifactId>mybatis-plus-boot-starter</artifactId>
    			<version>3.4.3.4</version>
    		</dependency>
    		<dependency>
    			<groupId>org.projectlombok</groupId>
    			<artifactId>lombok</artifactId>
    			<optional>true</optional>
    		</dependency>
    		<dependency>
    			<groupId>org.springframework.boot</groupId>
    			<artifactId>spring-boot-starter-test</artifactId>
    			<scope>test</scope>
    		</dependency>
    		<dependency>
    			<groupId>cn.hutool</groupId>
    			<artifactId>hutool-all</artifactId>
    			<version>5.7.17</version>
    		</dependency>
    	</dependencies>
    ```

3. 配置数据源，设置相关配置

    ```properties
    # 端口
    server.port=8081
    
    # 数据源
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.url=jdbc:mysql://127.0.0.1:3306/anonymous-vote?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&autoReconnect=true
    spring.datasource.username=root
    spring.datasource.password=root
    ```

4. 项目结构

    

5. 启动启动类，配置成功

    ![image-20211224153055022](https://gitee.com/vvwhyyy/pic/raw/master/img/202112241530149.png)

### 3. Redis 安装

**下载源文件**

```
wget https://download.redis.io/redis-stable.tar.gz
```

**编译源文件**

要编译 Redis，首先是 tarball，切换到根目录，然后运行`make`：

```
tar -xzvf redis-stable.tar.gz
cd redis-stable
make
```

如果编译成功，你会在`src`目录中找到几个 Redis 二进制文件，包括：

- **redis-server** : Redis 服务器本身
- **redis-cli**是与 Redis 对话的命令行界面实用程序。

要在 中安装这些二进制文件`/usr/local/bin`，请运行：

```
make install
```

**启动和停止redis**

安装后，您可以通过运行启动 Redis

```
redis-server ./redis.conf
```

如果成功，您将看到 Redis 的启动日志，并且 Redis 将在前台运行。

要停止 Redis，请输入`Ctrl-C`。

**如图即为redis启动成功：**

<img src="https://gitee.com/vvwhyyy/pic/raw/master/img/202204201723714.png" alt="image-20220420172319911" style="zoom:50%;" />

## 
