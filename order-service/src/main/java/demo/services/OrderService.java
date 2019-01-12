package demo.service;

import demo.model.OrderInfo;

public interface OrderService {

    OrderInfo saveOrderInfo(OrderInfo orderInfo);

    void deleteById(String id);

    OrderInfo findOrderInfoById(String id);
}
