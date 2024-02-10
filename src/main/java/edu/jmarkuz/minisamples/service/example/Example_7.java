package edu.jmarkuz.minisamples.service.example;

import edu.jmarkuz.minisamples.service.StudentService;
import edu.jmarkuz.minisamples.util.EntityUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class Example_7 implements Example {
    private final StudentService studentService;

    @Transactional
    @Override
    public void execute() {
        executeWithoutTransaction();
        executeWithTransaction();
    }

    protected void executeWithoutTransaction() {
        var student = EntityUtil.getStudent(1);

        log.info("Saving the student ".concat(student.toString()));
        studentService.savePropagationSupports(student);
    }

    @Transactional
    public void executeWithTransaction() {
        var student = EntityUtil.getStudent(2);

        log.info("Saving the student ".concat(student.toString()));
        this.studentService.savePropagationSupports(student);
    }

}
