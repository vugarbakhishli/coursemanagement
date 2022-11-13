package az.bakhishli.courses.ms.service.dto.course;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class CourseRequestDto {
    private String name;
    private String title;
    private String description;
}
