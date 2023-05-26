package ch.cern.todo.controllers.POJO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Value;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@Value
public class NewTaskPOJO {
    private String name;
    private String description;
    private Date deadline;
    private long categoryId;
}
