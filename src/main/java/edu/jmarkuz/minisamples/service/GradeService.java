package edu.jmarkuz.minisamples.service;

import edu.jmarkuz.minisamples.entity.Grade;
import edu.jmarkuz.minisamples.exception.FakeErrorException;
import edu.jmarkuz.minisamples.repository.GradeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GradeService {
    private final GradeRepository gradeRepository;

    @Transactional
    public void saveGrades(List<Grade> grades) {
        gradeRepository.saveAll(grades);

        throw new FakeErrorException("Error occurred");
    }

    @Transactional
    public void saveGradesSuccessfully(List<Grade> grades) {
        gradeRepository.saveAll(grades);
    }
}
