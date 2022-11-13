package az.bakhishli.students.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class StudentsMsApplication {
    public static void main(String[] args) {
        SpringApplication.run(StudentsMsApplication.class, args);
    }
}
