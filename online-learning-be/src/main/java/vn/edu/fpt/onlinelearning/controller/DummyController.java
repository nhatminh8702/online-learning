package vn.edu.fpt.onlinelearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.fpt.onlinelearning.entity.Dummy;
import vn.edu.fpt.onlinelearning.repository.DummyRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DummyController {
    @Autowired
    DummyRepository dummyRepository;

    @GetMapping("/dummy/{id}")
    public ResponseEntity<Dummy> getById(@PathVariable(name = "id") Integer id) {
        Dummy dummy = dummyRepository.findById(id).get();
        return new ResponseEntity<>(dummy, HttpStatus.OK);
    }

    @GetMapping("/dummy")
    public ResponseEntity<List<Dummy>> getAll() {
        return new ResponseEntity<>(dummyRepository.findAll(), HttpStatus.OK);
    }
}
