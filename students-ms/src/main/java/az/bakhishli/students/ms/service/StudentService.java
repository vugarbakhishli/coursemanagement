package az.bakhishli.students.ms.service;

import az.bakhishli.students.ms.dto.StudentRequestDto;
import az.bakhishli.students.ms.dto.StudentResponseDto;

public interface StudentService {
    StudentResponseDto getStudentById(Long id);
    void create(StudentRequestDto dto);
    StudentResponseDto update(Long id, StudentRequestDto dto);
    void delete(Long id);
}
