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

mysql-connector使用5.1.37，使用8+会只生成insert