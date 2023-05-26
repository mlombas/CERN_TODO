package ch.cern.todo.services;

import ch.cern.todo.controllers.POJO.NewTaskPOJO;
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
    public Task saveTask(NewTaskPOJO task) {
        return taskRepo.save(
                Task.builder()
                        .name(task.getName())
                        .description(task.getDescription())
                        .deadline(task.getDeadline())
                        //We use get as it will always have a category
                        .category(categoryRepo.findById(task.getCategoryId()).get())
                        .build()
        );
    }

    @Override
    public Optional<Task> getTask(long id) {
        return taskRepo.findById(id);
    }

    @Override
    public List<Task> getAll() {
        return (List<Task>) taskRepo.findAll();
    }

    @Override
    public void deleteTask(long id) {
        taskRepo.deleteById(id);
    }
}
