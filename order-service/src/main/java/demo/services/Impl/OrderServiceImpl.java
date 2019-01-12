package demo.service.Impl;

import demo.model.OrderInfo;
import demo.repository.OrderRepository;
import demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderInfo saveOrderInfo(OrderInfo orderInfo) {
        orderInfo.setOrderTime(System.currentTimeMillis());
        orderInfo.setTotalPrice(orderInfo.getFoodItems().stream().mapToInt(e -> e.getPrice() * e.getQuantity()).sum());
        return orderRepository.save(orderInfo);
    }

    @Override
    public void deleteById(String id) {
        orderRepository.deleteById(id);
    }

    @Override
    public OrderInfo findOrderInfoById(String id) {
        return orderRepository.findFirstById(id);
    }
}
