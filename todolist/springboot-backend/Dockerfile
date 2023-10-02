FROM maven:3.6.3-openjdk-8 AS builder
 #  AS builder 起别名

RUN mkdir /build
# 创建临时文件

ADD src /build/src
#将 src目录复制到临时目录

ADD pom.xml /build
# 将 pom文件复制到临时目录

RUN cd /build && mvn -B -ntp package
# 打包

FROM eclipse-temurin:8

COPY --from=builder /build/target/springboot-backend-0.0.1-SNAPSHOT.jar /app.jar

CMD ["--server.port=8080"]

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]

