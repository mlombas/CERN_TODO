package ch.cern.todo.services;

import ch.cern.todo.controllers.POJO.CategoryPOJO;
import ch.cern.todo.model.TaskCategory;
import ch.cern.todo.repositories.TaskCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class TaskCategoryServiceImpl implements TaskCategoryService {
    @Autowired
    private TaskCategoryRepository categoryRepo;

    @Override
    public TaskCategory save(CategoryPOJO category) {
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
    public void delete(long id) {
        categoryRepo.deleteById(id);
    }

    @Override
    public Optional<TaskCategory> update(long id, CategoryPOJO task) {
        var oToUpdate = categoryRepo.findById(id);
        if(oToUpdate.isEmpty()) return oToUpdate;

        var toUpdate = oToUpdate.get();
        if(task.getName() != null) toUpdate.setName(task.getName());
        if(task.getDescription() != null) toUpdate.setDescription(task.getDescription());
        categoryRepo.save(toUpdate);

        return Optional.of(toUpdate);
    }

    @Override
    public boolean exists(long id) {
        return categoryRepo.findById(id).isPresent();
    }
}
