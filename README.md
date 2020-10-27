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
<b>mvn clean install</b><br/>
<b>Run as Spring Boot App</b> (mvn spring-boot:run)<br/>
<br/>
Option 2 - run in batch mode by copying jar file <br/>
<b>cp /Users/dimitretcharaktchiev/.m2/repository/com/musala/gateway/0.0.1-SNAPSHOT/gateway-0.0.1-SNAPSHOT.jar .</b><br/>
<b>java -jar  gateway-0.0.1-SNAPSHOT.jar</b><br/>
&nbsp;

Note: Hibernate will automatically create the Gateways database upon run, refer to Gateways.sql for database setup, if required.

**4. API Testing samples**

<b>Create a Gateway</b> <br>
POST /api/v1/gateways HTTP/1.1<br/>
Host: localhost:8080<br/>
Content-Type: application/json<br/>
Cache-Control: no-cache<br/>
Postman-Token: fdd4d26f-bc4a-3af1-e3df-4eaf6f1ee95d<br/>

{<br/>
	"serialnum": "Gateway1",<br/>
	"name": "Musala1",<br/>
	"ipv4": "255.255.255.1",<br/>
	"devices":<br/>
	[
		{ "id": "1",<br/>
		  "vendor": "Sysco 1",<br/>
		  "datecreated": "2020-10-25",<br/>
		  "status": "online"<br/>
		},<br/>
		{ "id": "2",<br/>
		  "vendor": "Sysco 2",<br/>
		  "datecreated": "2020-10-25",<br/>
		  "status": "offline"<br/>
		}<br/>
	]<br/>
}<br/>

<br>
<b>Create a Peripheral device</b> <br>
POST /api/v1/gateways/peripheral HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
Postman-Token: f9c96b38-ab2b-3488-0b7a-1ee6cf113e1d

{
                "id": "7",
                "vendor": "Nysco 1",
                "datecreated": "2020-10-27",
                "status": "online",
                "serialnum": "Gateway1"
}


