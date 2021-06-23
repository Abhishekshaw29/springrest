package com.springrest.springrest.services;
import com.springrest.springrest.entity.Course;

import org.springframework.stereotype.Service;

import java.util.*; 

@Service
public class CourseServiceimpl implements Courseservice {

    List<Course> list;
    public CourseServiceimpl(){
        list = new ArrayList<>();
        list.add(new Course(123,"java","the book to master java"));
        list.add(new Course(124,"Python","the book to master Python"));

    }

    @Override
    public List<Course> getCourses() {
        // TODO Auto-generated method stub
        return list;
    }


    public Course getCourse(Long id){
        Course c = null;
        for(Course course : list){
            if(course.getId() == id){
                c=course;
                break;
            }
        }
        return c;
    }

    public Course addCourse(Course course){
        list.add(course);
        return course;
    }

    public Course updateCourse(Course course ,Long id){
        Course c = null;
        int index=0;
        for(Course courses : list){
            index++;
            if(courses.getId() == id){
                list.set(index-1, course);
                c=course;
                break;
            }
        }
        return c;
    }

    public Course deleteCourse(Long id){
        Course c = null;
        for(Course course : list){
            if(course.getId() == id){
                c = course;
                list.remove(course);
                break;
            }
        }
        return c;
    }
    
}
