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
	- findByCourseId 
	- orderCoursesByUser ->> place an order for the course by select "Order Course" **Button**
	- orderStatus ->>  books that are available and not available (**can use the update API**)

3. **AdminService**

	A. USERS
	- addUserDetails
	- getAllUsers
	- findByUserId
	- updateUser
	- deleteUser
	- updateLoginStatus ->> deactivate/activate users which means users cant login to the system

	B. COURSES
	- addCourseDetails
	- getAllCourses
	- findByCourseId
	- updateCourse ->> update course details 
	- deleteCourse
	- orderStatus 
	- orderCoursesByUser


Additional Technologies 
------------------------
1. Service Discovery 
2. API Gate way service
3. JWT
4. AUTH2
