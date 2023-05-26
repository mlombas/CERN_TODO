package ch.cern.todo.configurations;

import ch.cern.todo.model.TaskCategory;
import ch.cern.todo.repositories.TaskRepository;
import ch.cern.todo.services.TaskCategoryService;
import ch.cern.todo.services.TaskCategoryServiceImpl;
import ch.cern.todo.services.TaskService;
import ch.cern.todo.services.TaskServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.config.Task;

@Configuration
public class Services {
    @Bean
    public TaskService getTaskService() {
        return new TaskServiceImpl();
    }

    @Bean
    public TaskCategoryService getTaskCategoryService() {
        return new TaskCategoryServiceImpl();
    }
}
