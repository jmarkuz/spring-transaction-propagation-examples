package edu.jmarkuz.minisamples.service.example;

import edu.jmarkuz.minisamples.service.StudentService;
import edu.jmarkuz.minisamples.util.EntityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;

@Service
@RequiredArgsConstructor
public class Example_2 implements Example {
    private final StudentService studentService;
    @Override
    public void execute() {
        var student = EntityUtil.getStudent(1);

        try {
            studentService.savePropagationMandatory(student);
        } catch (TransactionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showResults() {

    }
}
