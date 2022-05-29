package net.unknownclub.springdatajpa.repository;

import net.unknownclub.springdatajpa.entity.Course;
import net.unknownclub.springdatajpa.entity.Student;
import net.unknownclub.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses() {
        List<Course> courseList = courseRepository.findAll();
        System.out.println("courseList = " + courseList);
    }

    @Test
    public void saveCourseWithTeacher() {

        Teacher teacher = Teacher.builder()
                .firstName("John")
                .lastName("Sakyz")
                .build();

        Course course = Course.builder()
                .title("Python")
                .credit(6)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void findAllPagination() {
        Pageable firstPagewithThreeRecords = PageRequest.of(0, 3);
        Pageable secondPagewithTwoRecords = PageRequest.of(1, 2);
        List<Course> courses = courseRepository.findAll(secondPagewithTwoRecords).getContent();

        long totalElements = courseRepository.findAll(secondPagewithTwoRecords).getTotalElements();
        long totalPages = courseRepository.findAll(secondPagewithTwoRecords).getTotalPages();

        System.out.println("totalElements = " + totalElements);

        System.out.println("totalPages = " + totalPages);

        System.out.println("courses = " + courses);

    }

    @Test
    public void findAllSorting() {
        Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("title"));
        Pageable sortbyCreditDesc = PageRequest.of(0, 2, Sort.by("credit").descending());
        Pageable sortbyTitleAndCreditDesc = PageRequest.of(0, 2, Sort.by("title").descending().and(Sort.by("credit")));


        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();
        System.out.println("courses = " + courses);

    }

    @Test
    public void printFindByTitleContaining() {
        Pageable firstPageTenRecords = PageRequest.of(0, 10);
        List<Course> courses = courseRepository.findByTitleContaining("H", firstPageTenRecords).getContent();

        System.out.println("courses = " + courses);
    }


    @Test
    public void saveCourseWithStudentAndTeacher() {

        Teacher teacher = Teacher.builder()
                .firstName("Jack")
                .lastName("Stone")
                .build();

        Course course = Course.builder()
                .title("AI")
                .credit(12)
                .teacher(teacher)
                .build();

        Student student = Student.builder()
                .firstName("Anuwat")
                .lastName("Kk")
                .emailId("abnj@gmail.com")
                .build();

        course.addStudents(student);

        courseRepository.save(course);
    }

}