package net.unknownclub.springdatajpa.repository;

import net.unknownclub.springdatajpa.entity.Student;
import net.unknownclub.springdatajpa.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
