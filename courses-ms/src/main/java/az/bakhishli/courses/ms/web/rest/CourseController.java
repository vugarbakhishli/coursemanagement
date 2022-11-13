package az.bakhishli.courses.ms.web.rest;

import az.bakhishli.courses.ms.service.dto.course.CourseRequestDto;
import az.bakhishli.courses.ms.service.dto.course.CourseResponseDto;
import az.bakhishli.courses.ms.service.dto.AddStudentDto;
import az.bakhishli.courses.ms.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService courseService;

    @GetMapping("/{id}")
    public ResponseEntity<CourseResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(courseService.getById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody CourseRequestDto dto) {
        courseService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CourseResponseDto> update(@PathVariable Long id, @RequestBody CourseRequestDto dto){
        return ResponseEntity.ok(courseService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        courseService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/add-student")
    public ResponseEntity<Void> addStudent(@RequestBody AddStudentDto dto){
        courseService.addStudent(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
