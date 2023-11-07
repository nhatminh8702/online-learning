package vn.edu.fpt.onlinelearning.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;

    public Lesson(Course course, String title, String content) {
        this.course = course;
        this.title = title;
        this.content = content;
    }
}
