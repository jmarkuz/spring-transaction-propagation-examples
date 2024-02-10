package edu.jmarkuz.minisamples.service.example;

import edu.jmarkuz.minisamples.entity.Grade;
import edu.jmarkuz.minisamples.entity.Student;
import edu.jmarkuz.minisamples.exception.FakeErrorException;
import edu.jmarkuz.minisamples.service.GradeService;
import edu.jmarkuz.minisamples.service.StudentService;
import edu.jmarkuz.minisamples.util.EntityUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class Example_6 implements Example {
    private final StudentService studentService;
    private final GradeService gradeService;

    private Student student;

    @Transactional
    @Override
    public void execute() {
        student = EntityUtil.getStudent(1);
        List<Grade> grades = EntityUtil.getGrades(1);

        try {
            log.info("Saving the student ".concat(student.toString()));
            this.studentService.savePropagationRequiredNew(student);

            log.info("Saving the graves ".concat(student.toString()));
            this.gradeService.saveGrades(grades);
        } catch (FakeErrorException e) {
            log.info(e.getMessage(), e);
        }
    }

    @Override
    public void showResults() {
    }
}
