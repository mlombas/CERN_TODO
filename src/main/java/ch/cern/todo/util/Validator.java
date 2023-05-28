package ch.cern.todo.util;

import ch.cern.todo.controllers.POJO.CategoryPOJO;
import ch.cern.todo.controllers.POJO.TaskPOJO;

import java.util.Date;

public class Validator {
    public static boolean taskPOJOAllowNullParameters(TaskPOJO task) {
        return task != null &&
                string(task.getName()) &&
                string(task.getDescription()) &&
                date(task.getDeadline());
    }

    public static boolean taskPOJO(TaskPOJO task) {
        return task != null &&
            task.getCategoryId() != null &&
            task.getName() != null && string(task.getName()) &&
            task.getDescription() != null && string(task.getDescription()) &&
            task.getDeadline() != null && date(task.getDeadline());
    }

    public static boolean CategoryPOJO(CategoryPOJO category) {
        return category != null &&
                category.getName() != null && string(category.getName()) &&
                category.getDescription() != null && string(category.getDescription());
    }

    public static boolean string(String s) {
        return s == null || !s.isBlank();
    }

    public static boolean date(Date d) {
        return d == null || d.after(new Date());
    }

}
