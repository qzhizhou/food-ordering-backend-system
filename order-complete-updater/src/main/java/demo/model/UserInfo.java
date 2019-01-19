package demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserInfo {

    private String id;

    private String firstName;
    private String lastName;
    private String address;
    private String phone;


}
