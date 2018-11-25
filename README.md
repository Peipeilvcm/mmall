
### project init
新建数据库，与其中的表文件

先生成maven，web项目

配置pom.xml
配置main.java文件夹，和它下面的com.mmall代码文件夹，再新建
dao、controller、pojo、service、util、vo、common文件夹

新建resources下的generatorConfig.xml和datasource.properties

### mybatis 三剑客
1. mybatis-generator配置
根据数据库，生成pojo、dao、xml文件，
修改mappers下XXXMapper.xml中createtime和updatetime为now(),让数据库做时间戳的处理
2. mybatis-plugin安装
3. mybatis-pagehelper分页器
https://github.com/pagehelper/Mybatis-PageHelper
分页插件，实现排序功能
pom.xml mybatispager引入

#### spring配置
github:spring-mvc-showcase、spring-petclinic、greenhouse、spring-boot
resources下 applicationContext.xml、applicationContext-datasource.xml、mmall.properties
webapp/WEB-INF下 dispatcher-serverlet.xml、web.xml配置、datasource.properties更新
resources下 logback

### 模块开发
#### 用户模块
功能：登入、注册、用户名验证、忘记密码、提交问题答案、重置密码、用户信息管理、退出登录
1. 横向越权、纵向越权安全漏洞
    攻击者访问其它拥有相同权限(横)、更高级权限(纵)的用户资源
2. MD5明文加密及salt使用
3. Guava缓存
4. 高复用服务响应对象设计思想及抽象封装
5. mybatis-plugin使用技巧
6. Session使用
7. 用户接口设计
每一个功能一个接口，
先UserController，再IUserService接口再接口实现，然后dao层UserMapper，编辑UserMapper.xml

### some errors
1. mysql-connector使用5.1.37，使用8+会只生成insert