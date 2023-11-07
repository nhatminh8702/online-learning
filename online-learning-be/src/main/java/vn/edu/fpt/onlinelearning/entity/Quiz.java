package vn.edu.fpt.onlinelearning.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    private String title;
    private String description;
    private int passingScore;

    public Quiz(Course course, String title, String description, int passingScore) {
        this.course = course;
        this.title = title;
        this.description = description;
        this.passingScore = passingScore;
    }
}
