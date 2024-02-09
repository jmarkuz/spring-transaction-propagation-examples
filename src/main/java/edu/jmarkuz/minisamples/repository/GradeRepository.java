package edu.jmarkuz.minisamples.repository;

import edu.jmarkuz.minisamples.entity.Grade;
import edu.jmarkuz.minisamples.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GradeRepository extends JpaRepository<Grade, Long> {

    List<Grade> findByStudent(Student student);

}
