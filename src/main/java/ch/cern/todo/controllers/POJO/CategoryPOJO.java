package ch.cern.todo.controllers.POJO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Value;

@JsonIgnoreProperties(ignoreUnknown = true)
@Value
public class CategoryPOJO {
    private String name;
    private String description;
}
