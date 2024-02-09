package edu.jmarkuz.minisamples.service;

import edu.jmarkuz.minisamples.entity.Grade;
import edu.jmarkuz.minisamples.entity.Student;
import edu.jmarkuz.minisamples.repository.GradeRepository;
import edu.jmarkuz.minisamples.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.lang.String.format;

@Slf4j
@Service
@RequiredArgsConstructor
public class SearchService {

    private final StudentRepository studentRepository;

    private final GradeRepository gradeRepository;

    /**
     * Show all students saved. This method has no defined propagation and isolation.
     */
    public void listAllStudents() {

        List<Student> students = this.studentRepository.findAll();

        for (Student student : students) {
            log.info(format("Name: %s %s", student.getFirstName(), student.getLastName()));
            log.info("Registration Number: ".concat(student.getRegistrationNumber()));
        }
    }

    /**
     * Returns all students saved. This method has no defined propagation and isolation.
     */
    public List<Student> findAllStudents() {
        return this.studentRepository.findAll();
    }

    /**
     * Show a students by your registration number.
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void findStudentByRegistrationNumber(String registrationNumber) {

        Student student = this.studentRepository.findByRegistrationNumber(registrationNumber);

        if (student == null) {
            log.info("Student not found for registration number ".concat(registrationNumber));
            return;
        }

        log.info(format("Name: %s %s", student.getFirstName(), student.getLastName()));
        log.info("Registration Number: ".concat(student.getRegistrationNumber()));
    }

    /**
     * Show the student's grades.
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void listAllStudentsGrade(Student student) {

        List<Grade> grades = this.gradeRepository.findByStudent(student);

        if (grades.isEmpty()) {
            log.info("No grades for the student ".concat(student.toString()));
            return;
        }

        for (Grade grade : grades) {
            log.info("Grade: ".concat(String.valueOf(grade.getGrade())));
            log.info("Discipline: ".concat(grade.getDiscipline()));
            log.info("Student: ".concat(grade.getStudent().getFirstName()).concat(" ").concat(grade.getStudent().getLastName()));
        }
    }

    /**
     * Show a students by your registration number. This method has no defined propagation and isolation.
     */
    public void findStudentByRegistrationNumberWithoutTransaction(String registrationNumber) {

        var student = this.studentRepository.findByRegistrationNumber(registrationNumber);

        if (student == null) {
            log.info("Student not found for registration number ".concat(registrationNumber));
            return;
        }

        log.info(format("Name: %s %s", student.getFirstName(), student.getLastName()));
        log.info("Registration Number: ".concat(student.getRegistrationNumber()));
    }

}
