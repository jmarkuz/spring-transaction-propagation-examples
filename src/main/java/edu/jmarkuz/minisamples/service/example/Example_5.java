package edu.jmarkuz.minisamples.service.example;

import edu.jmarkuz.minisamples.exception.FakeErrorException;
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

    @Transactional
    @Override
    public void execute() {
        var student1 = EntityUtil.getStudent(1);
        var student2 = EntityUtil.getStudent(2);

        try {
            log.info("Saving the student ".concat(student1.toString()));
            this.studentService.save(student1);

            log.info("Saving the student ".concat(student2.toString()));
            this.studentService.savePropagationNotSupported(student2);
        } catch (FakeErrorException e) {
            log.info(e.getMessage(), e);
        }
    }

}
