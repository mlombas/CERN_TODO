package ch.cern.todo.services;

import ch.cern.todo.controllers.POJO.NewTaskPOJO;
import ch.cern.todo.model.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TaskService {
    Task saveTask(NewTaskPOJO task);
    Optional<Task> getTask(long id);

    List<Task> getAll();

    void deleteTask(long id);
}
