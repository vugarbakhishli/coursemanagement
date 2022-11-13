package az.bakhishli.students.ms.repository;

import az.bakhishli.students.ms.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT s FROM Student s WHERE s.id IN(:idList)")
    List<Student> findAllById(@Param("idList") List<Long> idList);
}
