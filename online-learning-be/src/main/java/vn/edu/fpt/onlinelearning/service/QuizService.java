package vn.edu.fpt.onlinelearning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.fpt.onlinelearning.entity.Quiz;
import vn.edu.fpt.onlinelearning.repository.QuizRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class QuizService {
    @Autowired
    private QuizRepository quizRepository;

    public Quiz find(long id) {
        return quizRepository.findById(id).orElse(null);
    }

    public Quiz get(long id) {
        Quiz quiz = find(id);
        if (quiz == null)
            throw new EntityNotFoundException("Quiz with id " + id + " not found.");
        return quiz;
    }

    public List<Quiz> getAll() {
        return quizRepository.findAll();
    }

    public void add(Quiz quiz) {
        quiz.setId(null);
        quizRepository.save(quiz);
    }

    public void update(long id, Quiz quiz) {
        if (find(id) == null)
            throw new EntityNotFoundException("Quiz with id " + id + " not found.");
        quiz.setId(id);
        quizRepository.save(quiz);
    }

    public void delete(long id) {
        if (find(id) == null)
            throw new EntityNotFoundException("Quiz with id " + id + " not found.");
        quizRepository.deleteById(id);
    }
}
