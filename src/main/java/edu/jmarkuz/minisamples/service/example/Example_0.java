package edu.jmarkuz.minisamples.service.example;

import edu.jmarkuz.minisamples.entity.Student;
import edu.jmarkuz.minisamples.service.GradeService;
import edu.jmarkuz.minisamples.service.SearchService;
import edu.jmarkuz.minisamples.service.StudentService;
import edu.jmarkuz.minisamples.util.EntityUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class Example_0 implements Example {
    private final StudentService studentService;
    private final GradeService gradeService;
    private final SearchService searchService;
    private Student student;

    @Transactional
    @Override
    public void execute() {
        for (int i = 1; i <= 10; i++) {
            var student = EntityUtil.getStudent(i);
            studentService.save(student);

            var grades = EntityUtil.getGrades(student.getId());
            gradeService.saveGradesSuccessfully(grades);
        }
    }

    @Override
    public void showResults() {
    }
}
