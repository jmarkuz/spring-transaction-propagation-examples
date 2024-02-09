package edu.jmarkuz.minisamples.repository;

import edu.jmarkuz.minisamples.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findByRegistrationNumber(String registrationNumber);

}
