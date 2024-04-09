# spring_cloud_sentinel_demo
上课的sentinel demo
## 使用方法：
- 下载后进入项目根目录，执行mvn clean install

- 创建shop表，执行shop.sql

- 修改各个项目的application.yml的MySQL数据库密码，默认是1234

- 启动各个项目，访问 `http://127.0.0.1:9003/order/buy/2`，` http://127.0.0.1:9004/order/buy/2`

- 然后去`http://127.0.0.1:8080/#/dashboard/metric/sentinel-dashboard`

  > 用户名密码都是sentinel

- 因为懒加载，所以必须访问后才能看见新增的项目



## 如何启动sentinel-dashboard-1.6.3？

- 通过这条命令：

  ```cmd
  java -Dserver.port=8080 -Dcsp.sentinel.dashboard.server=localhost:8080 -Dproject.name=sentinel-dashboard -jar sentinel-dashboard-1.6.3.jar
  ```
## 必要jar包下载
[sentinel-dashboard-1.6.3.zip](https://github.com/reigadegr/spring_cloud_sentinel_demo/files/14914414/sentinel-dashboard-1.6.3.zip)

把zip后缀改jar，放到项目根目录，双击`启动管理端.bat`

然后访问`http://127.0.0.1:8080/#/dashboard/metric/sentinel-dashboard`
