package az.bakhishli.students.ms.service.impl;

import az.bakhishli.students.ms.domain.Student;
import az.bakhishli.students.ms.dto.StudentRequestDto;
import az.bakhishli.students.ms.dto.StudentResponseDto;
import az.bakhishli.students.ms.repository.StudentRepository;
import az.bakhishli.students.ms.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository repository;
    private final ModelMapper mapper;

    @Override
    public StudentResponseDto getStudentById(Long id) {
        var student = repository.findById(id);
        return mapper.map(student, StudentResponseDto.class);
    }

    @Override
    public void create(StudentRequestDto dto) {
        Student student = mapper.map(dto, Student.class);
        repository.save(student);
    }

    @Override
    public StudentResponseDto update(Long id, StudentRequestDto dto) {
        var student = repository.findById(id);
        Optional<Student> optional = student.map(s -> {
            s.setDisplayName(dto.getDisplayName());
            s.setAge(dto.getAge());
            return repository.save(s);
        });
        return mapper.map(optional, StudentResponseDto.class);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
