package ch.cern.todo.repositories;

import ch.cern.todo.model.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {
    List<Task> getAll();
    Task findById();
}
