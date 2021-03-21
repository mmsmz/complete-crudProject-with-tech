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
1. user->> userId, userName, mobileNo, email, userType, password, loginStatus
2. course->> crsid, crsname, crstype, crsprice, orderStatus
3. usercoursedetails->> usercrsid, userid, crsid
4. imagelocation>> imgid, imageLocation

	
Requirements of Functionality
-----------------------------
1. **HomeService**
	- Display Course Details 
	- Display three images of courses

2. **UserService** - Note: only registered users can login to the system
	- addUserDetails
	- getAllCourses
	- findByCourseId
	- userSelectsMultipleCourse ->> user can add multiple course into the table at once
	- checkCourseAlreadyPurchasedByUser 
	- orderStatus 
	
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
	- getAllCourses - if orderStatus is 1 then >> books are available else not available (**can use the update API to update**)
	- findByCourseId
	- updateCourse ->> update course details 
	- deleteCourse
	- userSelectsMultipleCourse
	
	C. UserCourseDetails 
	- getCoursesListByUserId ->> hibernate relationship 
	


Additional Technologies 
------------------------
1. Service Discovery 
2. API Gate way service
3. JWT
4. AUTH2
