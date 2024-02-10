package edu.jmarkuz.minisamples.service.example;

import edu.jmarkuz.minisamples.entity.Student;
import edu.jmarkuz.minisamples.exception.FakeErrorException;
import edu.jmarkuz.minisamples.service.SearchService;
import edu.jmarkuz.minisamples.service.StudentService;
import edu.jmarkuz.minisamples.util.EntityUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class Example_5 implements Example {
    private final StudentService studentService;
    private final SearchService searchService;

    private Student student1;
    private Student student2;

    @Transactional
    @Override
    public void execute() {
        student1 = EntityUtil.getStudent(1);
        student2 = EntityUtil.getStudent(2);

        try {
            log.info("Saving the student ".concat(student1.toString()));
            this.studentService.save(student1);

            log.info("Saving the student ".concat(student2.toString()));
            this.studentService.savePropagationNotSupported(student2);
        } catch (FakeErrorException e) {
            log.info(e.getMessage(), e);
        }
    }

    @Override
    public void showResults() {
        log.info("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        log.info("Search for saved students:");
        this.searchService.findStudentByRegistrationNumber(this.student1.getRegistrationNumber());
        this.searchService.findStudentByRegistrationNumber(this.student2.getRegistrationNumber());
        log.info("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
    }
}
