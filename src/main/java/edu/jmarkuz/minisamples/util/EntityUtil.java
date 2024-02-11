package edu.jmarkuz.minisamples.util;

import edu.jmarkuz.minisamples.entity.Grade;
import edu.jmarkuz.minisamples.entity.Student;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@Component
public class EntityUtil {

    private static final AtomicLong studentId = new AtomicLong(0);
    private static final AtomicLong gradeId = new AtomicLong(0);

    private static final Map<Long, Pair<String, String>> names = new HashMap<>();
    static {
        names.put(1L, Pair.of("John", "Doe"));
        names.put(2L, Pair.of("Bob", "Marly"));
        names.put(3L, Pair.of("Barack", "Obama"));
        names.put(4L, Pair.of("Elon", "Mask"));
        names.put(5L, Pair.of("Leonardo", "Dicaprio"));
        names.put(6L, Pair.of("Serena", "Williams"));
        names.put(7L, Pair.of("Bill", "Gates"));
        names.put(8L, Pair.of("Emma", "Watson"));
        names.put(9L, Pair.of("Jeff", "Bezos"));
        names.put(10L, Pair.of("Oprah", "Winfrey"));
    }

    private static final Map<Long, Student> students = new HashMap<>();
    private static final Map<Long, List<Grade>> grades = new HashMap<>();

    @Value("${log.init.data:false}")
    private boolean logInitData;

    @PostConstruct
    public void init() {
        for (int i = 0; i < 10; i++) {
            long id = studentId.incrementAndGet();

            var student = Student.builder()
                    .id(id)
                    .firstName(names.get(id).getFirst())
                    .lastName(names.get(id).getSecond())
                    .registrationNumber("reg-num-" + id)
                    .registrationDate(Date.from(Instant.now().minus(id, ChronoUnit.DAYS)))
                    .build();

            students.put(id, student);

            // adding students grades
            List<Grade> gradeList = new ArrayList<>();
            for (var discipline : Discipline.values()) {
                var gradeId = EntityUtil.gradeId.incrementAndGet();

                var grade = Grade.builder()
                        .id(gradeId)
                        .discipline(discipline.name())
                        .grade(getRandomNumber(1, 12))
                        .student(students.get(id))
                        .build();

                gradeList.add(grade);
            }
            grades.put(id, gradeList);
        }
        if (logInitData) {
            logInitData();
        }
    }

    private static int getRandomNumber(final int min, final int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static Student getStudent(long id) {
        return students.get(id);
    }

    public static List<Grade> getGrades(long studentId) {
        return grades.get(studentId);
    }

    enum Discipline {
        COMPUTER_SCIENCE("Computer Science"),
        ENGINEERING("Engineering"),
        PSYCHOLOGY("Psychology"),
        BIOLOGY("Biology"),
        MATHEMATICS("Mathematics");

        Discipline(String value) {
        }
    }

    private static void logInitData() {
        log.info("Students:");
        students.forEach((aLong, student) -> log.info(student.toString()));
        log.info("Grades:");
        grades.forEach((aLong, grade) -> log.info(grade.toString()));
    }
}
