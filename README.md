# hzauSpeaking

华农说叭hzauSpeaking

## 华农说叭终稿

- 由于可运行代码的密码也存在于源代码中，安全起见，本代码已将密码相关的内容删除，所以无法在没有配置的情况下正常运行！

- 该版本基于`2021.6.11`日晚展示软件工程项目用的版本进行了优化升级

- 后端请求方式修改

### 1. 主要功能

- 发帖

- 收藏

- 转发

- 帖子 CRUD

- 消息提醒

- 匿名发布

- 管理权限(在`user`表中`user_is_admin`为`2`是`管理员`、`user_allow`为`1`是`正常使用`，其他为`禁用`)

### 2. 使用方式

#### 2.1 front

- 配置好`注意点`中的注意项

- 在微信开发者工具运行即可

#### 2.2 end

- 配置好`注意点`中的注意项

- 在 IDEA 中运行即可

- 若无法运行，可以尝试删除`end/target`文件夹，重新下载依赖项

### 3. 注意点

重要的一点！！！一定要保证前后端用的是同一个appid！！！

#### 3.1 前端

##### 3.1.1 appid 的配置(`front/project.config.json`)

- 相关ID请自行申请

##### 3.1.2 服务器地址、阿里云 oss 地址(展示图片用)配置(`front/app.js`)

- url：可用`网云穿`做内网穿透

- imageUrl：阿里云 oss 注册后得到的地址

##### 3.1.3 阿里云 oss 的配置(`front/utils/config.js`)

- fileHost：阿里云 oss 地址；小程序 uploadFile 也需要配置该域名

- AccessKeySecret：见阿里云控制台

- OSSAccessKeyId：见阿里云控制台

#### 3.2 后端

##### 3.2.1 数据库

- 新建一个数据库`tieba`

- 导入数据库文件`end/tieba.sql`

- 在`end/src/main/resources/application.yml`配置`url`、`username`、`password`

##### 3.2.2 配置小程序`appid`和`密钥`

- 进入`end/src/main/java/com/hzauSpeaking/controller/LoginController.java`

- 修改`appid`和`secret`

##### 3.2.3 添加 oss 信息(`end/src/main/java/com/hzauSpeaking/util/isDelete/IsDelete.java`)

- 修改`endpoint`、`accessKeyId`、`accessKeySecret`、`bucketName`

##### 3.2.4 `Maven`相关(`others\apache-maven-3.6.0-bin.zip`)

- 使用`Maven`下载依赖项

#### 3.3 oss 配置注意项

- bucket 默认权限要为公共读写

#### 3.4 数据库注意项

- `MySql`版本要大于 5.5，否则可能无法导入 sql 文件
