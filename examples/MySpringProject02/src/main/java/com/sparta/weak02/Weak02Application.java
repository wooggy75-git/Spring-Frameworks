package com.sparta.weak02;

import com.sparta.weak02.models.Course;
import com.sparta.weak02.models.CourseRepository;
import com.sparta.weak02.models.CourseRequestDto;
import com.sparta.weak02.service.CourseService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@EnableJpaAuditing
@SpringBootApplication
public class Weak02Application {

    public static void main(String[] args) {
        SpringApplication.run(Weak02Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(CourseRepository courseRepository, CourseService courseService) {
        return (args) -> {
            courseRepository.save(new Course("프론트엔드의 꽃, 리액트", "임민영"));
            courseRepository.save(new Course("멋진 학생", "김해욱"));
            courseRepository.save(new Course("멋진 아이", "김주원"));
            courseRepository.save(new Course("멋진 딸래미", "김서영"));

            System.out.println("데이터 인쇄");
            List<Course> courseList = courseRepository.findAll();
            for (Course item : courseList) {
                System.out.println(item.getId());
                System.out.println(item.getTitle());
                System.out.println(item.getTutor());
            }
// DTO를 이용하여 변경...
//            Course new_course = new Course("웹개발의 봄, 스프링", "남병관");
//            courseService.update(1L, new_course);
//            courseList = courseRepository.findAll();
//            for (Course item : courseList) {
//                System.out.println(item.getId());
//                System.out.println(item.getTitle());
//                System.out.println(item.getTutor());
//            }

            CourseRequestDto requestDto = new CourseRequestDto("웹개발의 봄, 스프링", "남병관");

            courseService.update(1L, requestDto);
            courseList = courseRepository.findAll();
            for (Course item : courseList) {
                System.out.println(item.getId());
                System.out.println(item.getTitle());
                System.out.println(item.getTutor());
            }

            courseRepository.deleteById(2L);
        };
    }
}
