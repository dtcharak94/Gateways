# Gateways
Sample API for managing gateways and up to 10 peripheral devices per gateway

Programming language: Java; <br/>
Framework: Spring Boot 2.3.4.RELEASE <br/>
Database: MySQL 5.6.15 64-bit <br/>
Automated build: Apache Maven <br/>


## RESTful API Server ##

&nbsp;
**1. API Description for Project**

Sample calls:<br/>
http://localhost:8080/api/v1/gateways/Gateway1 <br/>
http://localhost:8080/api/v1/gateways <br/>

http://localhost:8080/api/v1/gateways/peripheral<br/>
http://localhost:8080/api/v1/gateways/peripheral/8 <br/>


METHOD | PATH | DESCRIPTION 
------------|-----|------------
GET | /api/v1/gateways/{Gateway Id} | Get Gateway info
GET | /api/v1/gateways | Get all Gateways info
POST | /api/v1/gateways | Create Gateway
DELETE | /api/v1/gateways/peripheral/{Peripheral ID} | Delete Peripheral device
POST | /api/v1/gateways/peripheral | Create Peripheral device

&nbsp;


**2. MySQL settings** <br/>
Update <b>/src/main/resources/application.properties</b> to MySQL testing environment as follows:

## Spring DATASOURCE (DataSourceAutoConfiguration & DataSourceProperties)
spring.datasource.url = jdbc:mysql://localhost:3306/Gateways?useSSL=false&zeroDateTimeBehavior=convertToNull<br/>
spring.datasource.username = root<br/>
spring.datasource.password = MySecret<br/>
&nbsp;



**3. API installation and running**

Option 1 - run from Spring Tool Suite <br/>
Import Gateways and create new SpringBoot project in STS. Run build with Apache Maven on pom.xml as follows:<br/>
mvn clean install<br/>
Run as Spring Boot App -  mvn spring-boot:run<br/>
<br/>
Option 2 - run in batch mode by copying jar file <br/>
cp /Users/dimitretcharaktchiev/.m2/repository/com/musala/gateway/0.0.1-SNAPSHOT/gateway-0.0.1-SNAPSHOT.jar .<br/>
java -jar  gateway-0.0.1-SNAPSHOT.jar<br/>
&nbsp;


