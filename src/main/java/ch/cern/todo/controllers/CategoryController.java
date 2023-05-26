package ch.cern.todo.controllers;

import ch.cern.todo.controllers.POJO.NewCategoryPOJO;
import ch.cern.todo.model.Task;
import ch.cern.todo.model.TaskCategory;
import ch.cern.todo.services.TaskCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private TaskCategoryService categoryService;

    @PostMapping("/new")
    public ResponseEntity<TaskCategory> newCategory(
            @RequestBody NewCategoryPOJO category
    ) {
        var saved = categoryService.save(category);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/list")
    public ResponseEntity<List<TaskCategory>> getAll() {
        return ResponseEntity.ok(categoryService.getAll());
    }
}
