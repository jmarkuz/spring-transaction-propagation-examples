package edu.jmarkuz.minisamples.service.example;

import edu.jmarkuz.minisamples.entity.Student;
import edu.jmarkuz.minisamples.service.SearchService;
import edu.jmarkuz.minisamples.service.StudentService;
import edu.jmarkuz.minisamples.util.EntityUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class Example_4 implements Example {
    private final StudentService studentService;
    private final SearchService searchService;
    private Student student;

    @Override
    public void execute() {
        student = EntityUtil.getStudent(1);

        this.studentService.savePropagationNever(student);
    }

    @Override
    public void showResults() {
        log.info("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        log.info("Search for saved students:");
        this.searchService.findStudentByRegistrationNumber(this.student.getRegistrationNumber());
        log.info("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
    }
}
