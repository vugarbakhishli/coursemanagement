package az.bakhishli.courses.ms.service.impl;

import az.bakhishli.common.dto.StudentIdContainerDto;
import az.bakhishli.courses.ms.client.MsStudentClient;
import az.bakhishli.courses.ms.domain.Course;
import az.bakhishli.courses.ms.domain.CoursesStudents;
import az.bakhishli.courses.ms.repository.CoursesStudentsRepository;
import az.bakhishli.courses.ms.service.dto.course.CourseRequestDto;
import az.bakhishli.courses.ms.service.dto.course.CourseResponseDto;
import az.bakhishli.courses.ms.service.dto.AddStudentDto;
import az.bakhishli.courses.ms.repository.CourseRepository;
import az.bakhishli.courses.ms.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseServiceImplementation implements CourseService {

    private final CourseRepository courseRepository;
    private final CoursesStudentsRepository coursesStudentsRepository;
    private final ModelMapper mapper;
    private final MsStudentClient msStudentClient;

    @Override
    public CourseResponseDto getById(Long id) {
        var course = courseRepository.findById(id);
        return mapper.map(course, CourseResponseDto.class);
    }

    @Override
    public void create(CourseRequestDto dto) {
        Course course = mapper.map(dto, Course.class);
        courseRepository.save(course);
    }

    @Override
    public CourseResponseDto update(Long id, CourseRequestDto dto) {
        var course = courseRepository.findById(id);
        Optional<Course> optional = course.map(c -> {
            c.setName(dto.getName());
            c.setDescription(dto.getDescription());
            c.setTitle(dto.getTitle());
            return courseRepository.save(c);
        });
        return mapper.map(optional, CourseResponseDto.class);
    }

    @Override
    public void delete(Long id) {
        courseRepository.deleteById(id);
    }

//    @Override
//    public void enrollStudent(EnrollCourseDto dto) {
//        StudentIdContainerDto studentIdContainer = msStudentClient.getById(dto.getStudentId());
//        repository.findById(dto.getCourseId())
//                .map(course -> {
//                    course.setStudentId(studentIdContainer.getId());
//                    return repository.save(course);
//                });
//    }
    @Override
    //@Transactional
    public CourseResponseDto addStudent(AddStudentDto dto) {
        var studentIdContainerDto = msStudentClient.getById(dto.getStudentId());
        var course = courseRepository.findById(dto.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found!"));
        var coursesStudents = CoursesStudents.builder().
                courseId(course.getId())
                .studentId(studentIdContainerDto.getId()).build();
        return mapper.map(coursesStudentsRepository.save(coursesStudents),
                CourseResponseDto.class);
    }


}
