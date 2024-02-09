package edu.jmarkuz.minisamples.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "grades")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "grades_id_seq")
    @SequenceGenerator(name = "grades_id_seq", sequenceName = "grades_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "grade", nullable = false)
    private int grade;

    @Column(name = "discipline", nullable = false, length = 100)
    private String discipline;

    @ManyToOne
    @JoinColumn(name = "id_student"/*, nullable = false*/)
    private Student student;

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", grade=" + grade +
                ", discipline='" + discipline + '\'' +
                '}';
    }
}
