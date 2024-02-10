package edu.jmarkuz.minisamples.service;

import edu.jmarkuz.minisamples.entity.Student;
import edu.jmarkuz.minisamples.exception.FakeErrorException;
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
        studentRepository.save(student);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void savePropagationNotSupported(Student student) {
        studentRepository.save(student);
        throw new FakeErrorException("Error saving student ".concat(student.toString()));
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void savePropagationRequiredNew(Student student) {
        studentRepository.save(student);
    }
}
