package az.bakhishli.courses.ms.repository;

import az.bakhishli.courses.ms.domain.CoursesStudents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesStudentsRepository extends JpaRepository<CoursesStudents, Long> {
}
