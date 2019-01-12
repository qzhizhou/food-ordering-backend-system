package demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderInfo {

    @Id
    private String id;

    private String restaurantId;

    private List<FoodItem> foodItems;

    private int totalPrice;

    private long orderTime;
    private long deliveryTime;

    private String specialNote;

    private String paymentId;

    private UserInfo userInfo;

    public UserInfo getUserInfo(){
        return this.userInfo;
    }

}
