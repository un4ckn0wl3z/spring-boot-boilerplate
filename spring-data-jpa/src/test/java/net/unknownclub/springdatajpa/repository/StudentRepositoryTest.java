package net.unknownclub.springdatajpa.repository;

import net.unknownclub.springdatajpa.entity.Guardian;
import net.unknownclub.springdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("anuwat@gmail.com")
                .firstName("anuwat")
                .lastName("Kh")
                //.guardianName("Uthai")
                //.guardianEmail("uth@gmail.com")
                //.guardianMobile("9999999999")
                .build();
        studentRepository.save(student);
    }


    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void saveStudentWithGuardian() {

        Guardian guardian = Guardian.builder()
                .name("Neo")
                .email("neo@matrix.net")
                .mobile("9999999991")
                .build();

        Student student = Student.builder()
                .firstName("John")
                .lastName("Wick")
                .emailId("jw@hunters.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printStudentByFirstName() {
        List<Student> students = studentRepository.findByFirstName("john");
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> students = studentRepository.findByFirstNameContaining("a");
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentBasedOnGuardianName() {
        List<Student> students = studentRepository.findByGuardianName("Uthai");
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentEmailAddress() {
        Student students = studentRepository.getStudentByEmailAddress("jw@hunters.com");
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentFirstNameEmailAddress() {
        String studentFirstName= studentRepository.getStudentFirstNameByEmailAddress("jw@hunters.com");
        System.out.println("studentFirstName = " + studentFirstName);
    }


    @Test
    public void printStudentEmailAddressNative() {
        Student students = studentRepository.getStudentByEmailAddressNative("jw@hunters.com");
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentEmailAddressNativeNamedParam() {
        Student students = studentRepository.getStudentByEmailAddressNativeNamedParam("jw@hunters.com");
        System.out.println("students = " + students);
    }

    @Test
    public void updateStudentNameByEmailId() {
        studentRepository.updateStudentNameByEmailId("neojohn", "jw@hunters.com");
    }


    }