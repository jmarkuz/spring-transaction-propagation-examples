package edu.jmarkuz.minisamples.service;

import edu.jmarkuz.minisamples.entity.Student;
import edu.jmarkuz.minisamples.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public void save(Student student) {
        studentRepository.save(student);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void savePropagationMandatory(Student student) {
        studentRepository.save(student);
    }

    @Transactional(propagation = Propagation.NEVER)
    public void savePropagationNever(Student student) {
        this.studentRepository.save(student);
    }
}
