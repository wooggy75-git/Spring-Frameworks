package com.sparta.weak02.models;

import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor // 기본생성자를 대신 생성해줍니다.
@Entity // 테이블임을 나타냅니다.
public class Course extends Timestamped{

    @Id // ID 값, Primary Key로 사용하겠다는 뜻입니다.
    @GeneratedValue(strategy = GenerationType.AUTO) // 자동 증가 명령입니다.
    private Long id;

    @Column(nullable = false) // 컬럼 값이고 반드시 값이 존재해야 함을 나타냅니다.
    private String title;

    @Column(nullable = false)
    private String tutor;

    public Course(String title, String tutor) {
        this.title = title;
        this.tutor = tutor;
    }

    public Course(CourseRequestDto courseRequestDto) {
        this.title = courseRequestDto.getTitle();
        this.tutor = courseRequestDto.getTutor();
    }

    //public void update(Course course) { // DTO를 사용하도록 변경
    public void update(CourseRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.tutor = requestDto.getTutor();
    }
}