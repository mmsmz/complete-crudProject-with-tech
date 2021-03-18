# Complete-crudProject-with-implementing-technologies

**Application Name** : Student Course Registration System 

Note: Implement this crud project using all the standard technologies available. E.g. Spring Boot, Hibernate, MYSQL, Angular 8, Microservice Design Patterns.   

**_Requirement Gethering_**:
	
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
1. **HomeService** 
	- Display Course Details 
	- Display three images of courses

2. **UserService **- Note: only registered users can login to the system
	- getallcourses
	- searchcourse
	- place an order for the course by select "ORDER COURSE" BUTTON

3. **AdminService **
	_1. USERS_
	- addUserDetails
	- getAllUsers
	- serachUsers
	- updateUsers
	- deleteUsers
	- deactivate/activate users which means users cant login to the system

	_A. COURSES_
	- addCourseDetails
	- getAllCourses
	- serachCourses
	- updateCourses
	- deleteCourses
	- Accepted order the course 


Additional Technologies 
------------------------
1. Service Discovery 
2. API Gate way service
3. JWT
4. AUTH2
