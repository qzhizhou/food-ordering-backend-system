package demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document
public class MenuItem {

    @Id
    private String id;

    private String restaurantId;

    private String name;

    private String description;

    private double price;
}
