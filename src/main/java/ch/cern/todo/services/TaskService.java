package ch.cern.todo.services;

import ch.cern.todo.controllers.POJO.TaskPOJO;
import ch.cern.todo.model.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TaskService {
    Task save(TaskPOJO task);
    Optional<Task> get(long id);

    List<Task> getAll();

    void delete(long id);

    Optional<Task> update(long id, TaskPOJO task);

    boolean exists(long id);
}
