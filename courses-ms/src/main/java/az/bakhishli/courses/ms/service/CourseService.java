package az.bakhishli.courses.ms.service;

import az.bakhishli.courses.ms.service.dto.course.CourseRequestDto;
import az.bakhishli.courses.ms.service.dto.course.CourseResponseDto;
import az.bakhishli.courses.ms.service.dto.AddStudentDto;

public interface CourseService {
    CourseResponseDto getById(Long id);
    void create(CourseRequestDto dto);
    CourseResponseDto update(Long id, CourseRequestDto dto);
    void delete(Long id);
    CourseResponseDto addStudent(AddStudentDto dto);
}
