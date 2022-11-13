package az.bakhishli.students.ms.web.rest;

import az.bakhishli.students.ms.dto.StudentRequestDto;
import az.bakhishli.students.ms.dto.StudentResponseDto;
import az.bakhishli.students.ms.service.StudentService;
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
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    //TODO: delete create path
    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody StudentRequestDto dto) {
        studentService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    //TODO: delete update path
    @PutMapping("/update/{id}")
    public ResponseEntity<StudentResponseDto> update(@PathVariable Long id, @RequestBody StudentRequestDto dto){
        return ResponseEntity.ok(studentService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        studentService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
