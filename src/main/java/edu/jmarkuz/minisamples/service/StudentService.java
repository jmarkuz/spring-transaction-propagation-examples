package edu.jmarkuz.minisamples.service;

import edu.jmarkuz.minisamples.entity.Student;
import edu.jmarkuz.minisamples.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public void save(Student student) {
        studentRepository.save(student);
    }
}
