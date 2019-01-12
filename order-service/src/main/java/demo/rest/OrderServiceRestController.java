package demo.rest;

import demo.model.OrderInfo;
import demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class OrderServiceRestController {
    private OrderService orderService;

    @Autowired
    public OrderServiceRestController(OrderService orderService){
        this.orderService = orderService;
    }

    @RequestMapping(value = "/restaurants/{rid}/orders", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public OrderInfo upload(@RequestBody  OrderInfo orderInfo){
        return this.orderService.saveOrderInfo(orderInfo);
    }

    @RequestMapping(value = "/restaurants/purge/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable String id){
        orderService.deleteById(id);
    }

    @RequestMapping(value = "/restaurants/{id}", method = RequestMethod.GET)
    public OrderInfo getOrderInfoById(@PathVariable String id){
        return orderService.findOrderInfoById(id);
    }
}
