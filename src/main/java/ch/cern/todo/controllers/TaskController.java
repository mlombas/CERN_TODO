package ch.cern.todo.controllers;

import ch.cern.todo.controllers.POJO.NewTaskPOJO;
import ch.cern.todo.model.Task;
import ch.cern.todo.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController(value = "/task")
public class TODOController {

    @Autowired
    TaskService taskService;

    @GetMapping("/get/{id}")
    public ResponseEntity<Task> getTask(@PathVariable long id) {
        return ResponseEntity.of(taskService.getTask(id));
    }

    @PostMapping("/new")
    public ResponseEntity<Task> newTask(
            @RequestBody NewTaskPOJO task
    ) {
        var saved = taskService.saveTask(task);
        return ResponseEntity.ok(saved);
    }
}
