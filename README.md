# Public API

This project was created for testing of RESTful API  [https://api.publicapis.org/]( https://api.publicapis.org/).

The technology stack that is used in the testing framework:

 * JAVA
 * Maven   
 * RestAssured
 * Extent Reports
 
 ### Prerequisites
 
 In order to use these tests you need to install following software:
 
 
 * [Maven](https://maven.apache.org/)
 * [Java Development Kit](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) (JDK)
 

### Installation

After cloning the project from Githab, you can either build it in your IDE (IntelliJ IDEA or Eclipse) or just go to the project folder and type in command line "mvn clean install".


### How to Run Tests

You can execute tests either in IDE or just go to the project folder and type in command line "mvn test"  
  
### Results and Reports

After every execution a folder named with timestamp is created in the Reports folder where you can find HTML reports along with statistics and logs. 

### Tests Descriptions

###### randomNoAuthTest

This test checks request and response to /random endpoint in order to get some API without authentication. 

Checkings:
* Response code 200
* Presense of required fields in responses jsons.
* Only one entry is returned.
* Count value is correct. 

###### entriesTest

This test checks request and response to /entries endpoint. 

Checkings:
* Response code 200
* Presense of required fields in responses jsons for every entry returned.
* Count value is correct.  

### Author
 **Alexander Ognev** 

  