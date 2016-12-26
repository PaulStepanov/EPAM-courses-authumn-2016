# EPAM-courses-authumn-2016
##Final project 
###How to run
1. create DB with custom name, execute create.sql than addFakeInf.sql
2. in META-INF\context.xml set db name in connection, user and password
3. compile classes from src to \web\WEB-INF\classes
4. add dependencies jar's to  WEB-INF\lib
5. deploy

***Dependencies in pom.xml***
###Dependencies list:
* mysql-connector-java [5.1.6]   (https://mvnrepository.com/artifact/mysql/mysql-connector-java/5.1.6)
* joda-time [2.9.6] (https://mvnrepository.com/artifact/joda-time/joda-time/2.9.6)
* log4j [1.2.17] (https://mvnrepository.com/artifact/log4j/log4j/1.2.17)
* javax.servlet [3.0.1] (https://mvnrepository.com/artifact/javax.servlet/servlet-api/3.0.1)
* javax.servlet.jsp.jstl-api [1.2.1] (https://mvnrepository.com/artifact/javax.servlet.jsp.jstl/javax.servlet.jsp.jstl-api/1.2.1)
