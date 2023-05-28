package ch.cern.todo.services;

import ch.cern.todo.controllers.POJO.TaskPOJO;
import ch.cern.todo.model.Task;
import ch.cern.todo.repositories.TaskCategoryRepository;
import ch.cern.todo.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepo;
    @Autowired
    private TaskCategoryRepository categoryRepo;

    @Override
    public Task save(TaskPOJO task) {
        return taskRepo.save(
                Task.builder()
                        .name(task.getName())
                        .description(task.getDescription())
                        .deadline(task.getDeadline())
                        .category(categoryRepo.findById(task.getCategoryId()).orElse(null))
                        .build()
        );
    }

    @Override
    public Optional<Task> get(long id) {
        return taskRepo.findById(id);
    }

    @Override
    public List<Task> getAll() {
        return (List<Task>) taskRepo.findAll();
    }

    @Override
    public void delete(long id) {
        taskRepo.deleteById(id);
    }

    @Override
    public Optional<Task> update(long id, TaskPOJO task) {
        var oToUpdate = taskRepo.findById(id);
        if(oToUpdate.isEmpty()) return oToUpdate;

        var toUpdate = oToUpdate.get();
        if(task.getName() != null) toUpdate.setName(task.getName());
        if(task.getDescription() != null) toUpdate.setDescription(task.getDescription());
        if(task.getDeadline() != null) toUpdate.setDeadline(task.getDeadline());
        if(task.getCategoryId() != null) {
            var category = categoryRepo.findById(task.getCategoryId());
            if(category.isPresent()) toUpdate.setCategory(category.get());
        }
        taskRepo.save(toUpdate);

        return Optional.of(toUpdate);
    }

    @Override
    public boolean exists(long id) {
        return taskRepo.findById(id).isPresent();
    }
}
