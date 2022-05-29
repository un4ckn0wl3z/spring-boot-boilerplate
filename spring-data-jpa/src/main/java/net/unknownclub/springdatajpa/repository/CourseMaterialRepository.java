package net.unknownclub.springdatajpa.repository;

import net.unknownclub.springdatajpa.entity.Course;
import net.unknownclub.springdatajpa.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {
}
