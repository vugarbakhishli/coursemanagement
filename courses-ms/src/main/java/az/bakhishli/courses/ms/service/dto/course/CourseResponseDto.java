package az.bakhishli.courses.ms.service.dto.course;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CourseResponseDto {
    private Long id;
    private String name;
    private String title;
    private String description;
    private Long studentId;
}
