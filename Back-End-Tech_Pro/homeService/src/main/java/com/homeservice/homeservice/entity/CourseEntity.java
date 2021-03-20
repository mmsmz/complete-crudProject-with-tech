package com.homeservice.homeservice.entity;



import javax.persistence.*;

@Entity
@Table(name="course")
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="courseid")
    private Integer courseId;

    @Column(name="coursename")
    private String courseName;

    @Column(name="coursetype")
    private String courseType;

    @Column(name="courseprice")
    private double coursePrice;

    @Column(name="active")
    private byte active;


    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public double getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(double coursePrice) {
        this.coursePrice = coursePrice;
    }

    public byte getActive() {
        return active;
    }

    public void setActive(byte active) {
        this.active = active;
    }
}
