# complete-crudProject-with-tech
Implement this crud project using all the standard technologies available. E.g. Spring Boot, Hibernate, MYSQL, Angular 8, Microservice Patterns.   

Application For : Student Course Registration System 

Requirement:
	
List of Microservices 
---------------------
1. HomeService 
2. UserService 
3. AdminService 
4. HomeService 

5. GatewayService 
6. EurekaSerivce 
7. ConfigService 

TABLE
-----
student->> userid, fullname, mobileno, email, userType, active
course->> crsid, crsname, crstype, crsprice, active
studentcoursedetails->> studcrsid, userid, crsid
imagelocation>> imgid, imageLocation

	
Requirements of Functionality
-----------------------------
>> HomeService 
	- Display Course Details 
	- Display three images of courses

>> UserService 	- only registered users can login to the system***
	- getallcourses
	- searchcourse
	- place an order for the course by select "ORDER COURSE" BUTTON

>> AdminService 
	USERS>>>>>>>>>>>>>>>>
	- addUserDetails
	- getAllUsers
	- serachUsers
	- updateUsers
	- deleteUsers
	- deactivate/activate users which means users cant login to the system

	COURSES>>>>>>>>>>>>>>>>
	- addCourseDetails
	- getAllCourses
	- serachCourses
	- updateCourses
	- deleteCourses
	- Accepted order the course 


Implentation
-------------
1. Service Discovery 
2. API Gate way service
3. JWT
4. AUTH2
