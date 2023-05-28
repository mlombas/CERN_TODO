package ch.cern.todo.controllers;

import ch.cern.todo.controllers.POJO.TaskPOJO;
import ch.cern.todo.model.Task;
import ch.cern.todo.services.TaskCategoryService;
import ch.cern.todo.services.TaskService;
import ch.cern.todo.util.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("task")
public class TaskController {

    @Autowired
    TaskService taskService;
    @Autowired
    TaskCategoryService categoryService;

    @GetMapping("/get/{id}")
    public ResponseEntity<Task> getTask(@PathVariable long id) {
        return ResponseEntity.of(taskService.get(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<Task>> getAll() {
        return ResponseEntity.ok(taskService.getAll());
    }

    @PostMapping("/new")
    public ResponseEntity<Task> newTask(
            @RequestBody TaskPOJO task
    ) {
        if(!Validator.taskPOJO(task)) return ResponseEntity.badRequest().build();
        if(!categoryService.exists(task.getCategoryId())) return ResponseEntity.notFound().build();

        var saved = taskService.save(task);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTask(
            @PathVariable long id
    ) {
        if(!taskService.exists(id)) return ResponseEntity.notFound().build();

        taskService.delete(id);
        return ResponseEntity.ok("Deleted");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Task> updateTask(
            @PathVariable long id, @RequestBody TaskPOJO task
    ) {
        if(!taskService.exists(id)) return ResponseEntity.notFound().build();
        if(!Validator.taskPOJOAllowNullParameters(task)) return ResponseEntity.badRequest().build();
        if(
                task.getCategoryId() != null &&
                !categoryService.exists(task.getCategoryId())
        ) return ResponseEntity.notFound().build();

        var saved = taskService.update(id, task);
        return ResponseEntity.of(saved);
    }
}
