# 中文编码修正工具
[http://char.dxbtech.cn](http://char.dxbtech.cn)

### RUN
1.Create Database In MySQL
```sql
CREATE SCHEMA `charset_corrector` DEFAULT CHARACTER SET utf8 ; 
```
2.application.properties
```properties
spring.profiles.active=release
```
3.run
```
mvn package -DskipTests
jar charset-corrector-*.*.jar
```
4.nginx
```
...
```