package com.springrest.springrest.controller;

import java.nio.file.Path;
import java.util.List;

import com.springrest.springrest.entity.Course;
import com.springrest.springrest.services.Courseservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    private Courseservice courseservice;
    
    @GetMapping("/")
        public String home(){
            return "HELLO WORLD";
        }

    // @GetMapping("/home")
    // public String demo(){
    //     return "Welcome to home";
    // }

    //get all the courses
    @GetMapping("/Courses")
    public List<Course> getCourses(){
        
        return this.courseservice.getCourses();
        
    }
    
    //get course by id
    @GetMapping("/Courses/{Course_id}")
    public Course getCourse(@PathVariable String Course_id){
        return this.courseservice.getCourse(Long.parseLong(Course_id));
    }

    //add new courses by sending json
    //can write consumes json.application.
    @PostMapping("/Courses")
    public Course addCourse(@RequestBody Course course){
        return this.courseservice.addCourse(course);
    }

    //update all the course
    @PutMapping("/Courses/{Course_id}")
    public Course updateCourse(@RequestBody Course course , @PathVariable String Course_id){
        
        this.courseservice.updateCourse(course , Long.parseLong(Course_id));
        return course;
    }
    
    //delete the course
    @DeleteMapping("/Courses/{Course_id}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String Course_id){
        //send https status using response entity
        try {
            this.courseservice.deleteCourse(Long.parseLong (Course_id));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            //TODO: handle exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


       
    } 

}
