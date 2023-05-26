package ch.cern.todo.services;

import ch.cern.todo.controllers.POJO.CategoryPOJO;
import ch.cern.todo.model.TaskCategory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TaskCategoryService {
    TaskCategory save(CategoryPOJO category);

    List<TaskCategory> getAll();

    void delete(long id);

    Optional<TaskCategory> update(long id, CategoryPOJO category);
}
