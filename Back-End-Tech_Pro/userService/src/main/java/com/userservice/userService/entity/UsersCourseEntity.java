package com.userservice.userService.entity;

import javax.persistence.*;

@Entity
@Table(name = "usercoursedetails")
public class UsersCourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "urscrsid")
    private Integer userCourseId;

    @Column(name = "userid")
    private Integer UserId;

    @Column(name = "courseid")
    private Integer courseId;

    public Integer getUserCourseId() {
        return userCourseId;
    }

    public void setUserCourseId(Integer userCourseId) {
        this.userCourseId = userCourseId;
    }

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        UserId = userId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
}
