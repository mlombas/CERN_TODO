package ch.cern.todo.controllers;

import ch.cern.todo.controllers.POJO.CategoryPOJO;
import ch.cern.todo.model.TaskCategory;
import ch.cern.todo.services.TaskCategoryService;
import ch.cern.todo.util.Validator;
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
            @RequestBody CategoryPOJO category
    ) {
        if(!Validator.CategoryPOJO(category)) return ResponseEntity.badRequest().build();

        var saved = categoryService.save(category);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/list")
    public ResponseEntity<List<TaskCategory>> getAll() {
        return ResponseEntity.ok(categoryService.getAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTask(
            @PathVariable long id
    ) {
        if(!categoryService.exists(id)) return ResponseEntity.notFound().build();

        categoryService.delete(id);
        return ResponseEntity.ok("Deleted");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TaskCategory> updateTask(
            @PathVariable long id, @RequestBody CategoryPOJO category
    ) {
        if(!categoryService.exists(id)) return ResponseEntity.notFound().build();
        if(!Validator.CategoryPOJO(category)) return ResponseEntity.badRequest().build();

        var saved = categoryService.update(id, category);
        return ResponseEntity.of(saved);
    }
}
