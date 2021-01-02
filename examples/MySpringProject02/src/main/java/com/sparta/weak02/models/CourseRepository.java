package com.sparta.weak02.models;

import com.sparta.weak02.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}