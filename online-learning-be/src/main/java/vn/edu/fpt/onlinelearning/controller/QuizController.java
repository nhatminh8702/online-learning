package vn.edu.fpt.onlinelearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.fpt.onlinelearning.entity.Quiz;
import vn.edu.fpt.onlinelearning.service.QuizService;

import java.util.List;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping("/list")
    public ResponseEntity<List<Quiz>> getAll() {
        return ResponseEntity.ok(quizService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quiz> get(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(quizService.get(id));
    }

    @PostMapping
    public void add(@RequestBody Quiz quiz) {
        quizService.add(quiz);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable(name = "id") long id, @RequestBody Quiz quiz) {
        quizService.update(id, quiz);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") long id) {
        quizService.delete(id);
    }
}
