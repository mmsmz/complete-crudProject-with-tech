# Complete-crudProject-with-implementing-technologies

**Application Name** : Student Course Registration System 

Note: Implement this crud project using all the standard technologies available. E.g. Spring Boot, Hibernate, MYSQL, Angular 8, Microservice Design Patterns.   

**_Requirement Gethering_**:
	
List of Microservices 
---------------------

A. Microservices 
   -  HomeService 
   -  UserService 
   -  AdminService 
   -  HomeService 
   
B. Common Services
   -  GatewayService 
   -  EurekaSerivce 
   -  ConfigService 

**Front-end ** : Angular

TABLE
-----
1. student->> userId, userName, mobileNo, email, userType, loginStatus
2. course->> crsid, crsname, crstype, crsprice, orderStatus
3. studentcoursedetails->> studcrsid, userid, crsid
4. imagelocation>> imgid, imageLocation

	
Requirements of Functionality
-----------------------------
1. **HomeService**
	- Display Course Details 
	- Display three images of courses

2. **UserService** - Note: only registered users can login to the system
	- getallcourses
	- searchcourse
	- place an order for the course by select "Order Course" **Button**

3. **AdminService**

	A. USERS
	- addUserDetails
	- getAllUsers
	- findByUserId
	- updateUser
	- deleteUser
	- updateLoginStatus - deactivate/activate users which means users cant login to the system

	B. COURSES
	- addCourseDetails
	- getAllCourses
	- findByCourseId
	- updateCourse
	- deleteCourse
	- Accepted order the course 


Additional Technologies 
------------------------
1. Service Discovery 
2. API Gate way service
3. JWT
4. AUTH2
