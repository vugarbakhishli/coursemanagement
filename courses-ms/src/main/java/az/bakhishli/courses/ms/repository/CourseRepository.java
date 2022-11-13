package az.bakhishli.courses.ms.repository;

import az.bakhishli.courses.ms.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
