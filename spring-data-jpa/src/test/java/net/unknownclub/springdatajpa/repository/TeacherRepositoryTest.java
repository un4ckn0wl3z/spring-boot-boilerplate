package net.unknownclub.springdatajpa.repository;

import net.unknownclub.springdatajpa.entity.Course;
import net.unknownclub.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {

        Course courseHacking = Course.builder()
                .title("Hacking")
                .credit(5)
                .build();

        Course courseNetwork = Course.builder()
                .title("Network")
                .credit(4)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Somsak")
                .lastName("Lanyai")
                //.courses(List.of(courseHacking, courseNetwork))
                .build();

        teacherRepository.save(teacher);
    }

}