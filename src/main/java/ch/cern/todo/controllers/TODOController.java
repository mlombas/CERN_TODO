package ch.cern.todo.controllers;

import ch.cern.todo.model.Task;
import ch.cern.todo.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class TODOController {

    @Autowired
    private TaskRepository taskRepo;

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return new ResponseEntity<>("Test", HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<Task> newTask() {
        return ResponseEntity.of(Optional.empty());
    }
}
