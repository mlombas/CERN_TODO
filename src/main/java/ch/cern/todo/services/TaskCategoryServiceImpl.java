package ch.cern.todo.services;

import ch.cern.todo.controllers.POJO.NewCategoryPOJO;
import ch.cern.todo.model.TaskCategory;
import ch.cern.todo.repositories.TaskCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;

public class TaskCategoryServiceImpl implements TaskCategoryService {
    @Autowired
    private TaskCategoryRepository categoryRepo;

    @Override
    public TaskCategory save(NewCategoryPOJO category) {
        return categoryRepo.save(
                TaskCategory.builder()
                        .name(category.getName())
                        .description(category.getDescription())
                        .build()
        );
    }

    @Override
    public List<TaskCategory> getAll() {
        return (List<TaskCategory>) categoryRepo.findAll();
    }

    @Override
    public void deleteCategory(long id) {
        categoryRepo.deleteById(id);
    }
}
