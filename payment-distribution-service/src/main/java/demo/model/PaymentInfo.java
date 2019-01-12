package demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentInfo {
    @Id
    private String id;

    private CreditCardInfo creditCardInfo;

    //private String restaurantId;
    private long timestamp;
    private int amount;
    private String orderId;

    @JsonIgnore
    public CreditCardInfo getCreditCardInfo(){
        return this.creditCardInfo;
    }
}
