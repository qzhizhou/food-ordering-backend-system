package demo.rest;

import demo.model.PaymentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableBinding(Source.class)
@RequestMapping("/api")
public class PaymentDistributionServiceRestController {

    //@Qualifier("nullChannel")
    @Autowired
    //@Qualifier("output")
    private MessageChannel output;


    @RequestMapping(value = "/payments", method = RequestMethod.POST)
    public void pay(@RequestBody PaymentInfo paymentInfo){
        output.send(MessageBuilder.withPayload(paymentInfo).build());
    }


}
