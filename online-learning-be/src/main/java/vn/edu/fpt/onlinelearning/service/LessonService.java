package vn.edu.fpt.onlinelearning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.fpt.onlinelearning.entity.Lesson;
import vn.edu.fpt.onlinelearning.repository.LessonRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    private Lesson find(long id) {
        return lessonRepository.findById(id).orElse(null);
    }

    public Lesson get(long id) {
        Lesson lesson = find(id);
        if (lesson == null)
            throw new EntityNotFoundException("Lesson with id " + id + " not found.");
        return lesson;
    }

    public List<Lesson> getAll() {
        return lessonRepository.findAll();
    }

    public void add(Lesson lesson) {
        lesson.setId(null);
        lessonRepository.save(lesson);
    }

    public void update(long id, Lesson lesson) {
        if (find(id) == null)
            throw new EntityNotFoundException("Lesson with id " + id + " not found.");
        lesson.setId(id);
        lessonRepository.save(lesson);
    }

    public void delete(long id) {
        if (find(id) == null)
            throw new EntityNotFoundException("Lesson with id " + id + " not found.");
        lessonRepository.deleteById(id);
    }
}
