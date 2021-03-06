##api微服务template

###description
- 用spring-boot + mysql + jersey 实现的rest api web服务
- controller层由jersey实现，相应配置在JerseyConfig类中 (如果要用spring boot实现controller层，将JerseyConfig注释)
- 将服务docker化，build成相应image(DockerFile)
- 可以用docker compose启动web服务以及它所依赖的mysql服务
- 作为eureka client注册到服务发现列表上（eureka server地址为http://localhost:8761/eureka）

###useage
- export STAGE=dev 设置环境
- dev环境下用 `gradle fC fM` 初始化数据库
- 修改代码后，

    `gradle clean build` 打包代码 -> 
    
    `docker build 镜像名` build 新的docker镜像 ->
    
    `docker-compose up` 启动服务(docker-compose.yml文件中，web服务的镜像名要修改成build镜像时指定的镜像名)

