package vn.edu.fpt.onlinelearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.fpt.onlinelearning.entity.Lesson;
import vn.edu.fpt.onlinelearning.service.LessonService;

import java.util.List;

@RestController
@RequestMapping("/api/lessons")
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @GetMapping("/list")
    public ResponseEntity<List<Lesson>> getAll() {
        return ResponseEntity.ok(lessonService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lesson> get(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(lessonService.get(id));
    }

    @PostMapping
    public void add(@RequestBody Lesson lesson) {
        lessonService.add(lesson);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable(name = "id") long id, @RequestBody Lesson lesson) {
        lessonService.update(id, lesson);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") long id) {
        lessonService.delete(id);
    }
}
