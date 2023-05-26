package ch.cern.todo.controllers.POJO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Value;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@Value
public class TaskPOJO {
    private String name;
    private String description;
    private Date deadline;
    private Long categoryId;
}
