package edu.jmarkuz.minisamples.service.example;

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

    @Override
    public void execute() {
        var student = EntityUtil.getStudent(1);

        this.studentService.savePropagationNever(student);
    }

}
