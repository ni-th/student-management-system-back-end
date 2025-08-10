package com.icet.sms.controller;

import com.icet.sms.dto.CourseDTO;
import com.icet.sms.entities.Course;
import com.icet.sms.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api/course")
public class CourseController {

    final CourseService  courseService;
    @PostMapping("/add")
    public ResponseEntity<?> addCourse(@RequestBody CourseDTO courseDto) {
        CourseDTO course = courseService.save(courseDto);
        if(course == null){
            return new ResponseEntity<>("Wrong Conditionals", HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(course, HttpStatus.OK);
    }
}
