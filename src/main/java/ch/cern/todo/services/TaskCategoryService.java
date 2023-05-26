package ch.cern.todo.services;

import ch.cern.todo.controllers.POJO.NewCategoryPOJO;
import ch.cern.todo.model.TaskCategory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskCategoryService {
    TaskCategory save(NewCategoryPOJO category);

    List<TaskCategory> getAll();
}
