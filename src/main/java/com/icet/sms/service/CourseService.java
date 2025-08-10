package com.icet.sms.service;

import com.icet.sms.dto.CourseDTO;
import com.icet.sms.entities.Course;
import com.icet.sms.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CourseService {
    final CourseRepository courseRepository;

    public CourseDTO save(CourseDTO course) {

        Course course1 = courseRepository.save(new Course(
                course.getId(),
                course.getName(),
                course.getDescription()
        ));
        return course1.getDto();
    }
}
