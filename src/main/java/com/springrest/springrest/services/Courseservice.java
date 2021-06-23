package com.springrest.springrest.services;
import java.util.List;

import com.springrest.springrest.entity.Course;

public interface Courseservice {
    public List<Course> getCourses();
    public Course getCourse(Long id);
    public Course addCourse(Course course);
    public Course updateCourse(Course course , Long id);
    public Course deleteCourse(Long id);
}
