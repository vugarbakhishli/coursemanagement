package az.bakhishli.courses.ms.client;

import az.bakhishli.common.dto.StudentIdContainerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "${client.students-ms.name}",
        url = "${client.students-ms.host}${client.students-ms.path}")
public interface MsStudentClient {

    @GetMapping("/students/{id}")
    StudentIdContainerDto getById(@PathVariable Long id);
}
