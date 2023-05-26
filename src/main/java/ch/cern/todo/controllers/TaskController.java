package ch.cern.todo.controllers;

import ch.cern.todo.controllers.POJO.NewTaskPOJO;
import ch.cern.todo.model.Task;
import ch.cern.todo.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/get/{id}")
    public ResponseEntity<Task> getTask(@PathVariable long id) {
        return ResponseEntity.of(taskService.getTask(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<Task>> getAll() {
        return ResponseEntity.ok(taskService.getAll());
    }

    @PostMapping("/new")
    public ResponseEntity<Task> newTask(
            @RequestBody NewTaskPOJO task
    ) {
        var saved = taskService.saveTask(task);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> newTask(
            @PathVariable long id
    ) {
        taskService.deleteTask(id);
        return ResponseEntity.ok("Deleted");
    }
}
