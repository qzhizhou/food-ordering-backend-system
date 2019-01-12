package demo.service.impl;

import demo.model.FoodItem;
import demo.model.OrderInfo;
import demo.model.UserInfo;
import demo.repository.OrderRepository;
import demo.service.Impl.OrderServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OrderServiceImplTest {
    private OrderRepository orderRepository;
    private OrderServiceImpl orderService;
    private final String restaurantId = "11111111-1111-1111-11111111111111111";
    private UserInfo userInfo;

    @Before
    public void setupMock() {
        orderRepository = mock(OrderRepository.class);
        orderService = new OrderServiceImpl(orderRepository);
        userInfo = new UserInfo();
        userInfo.setFirstName("First1");
        userInfo.setLastName("Last1");
        userInfo.setPhone("14081234567");
    }

    @Test
    public void whenCreateOrder_returnCreatedOrder() {
        List<FoodItem> foodItems = new ArrayList<>();
        foodItems.add(generateFoodItem("Menu item 1", 11, 2));
        foodItems.add(generateFoodItem("Menu item 2", 12, 3));
        OrderInfo order = generateOrder(restaurantId, foodItems, "Special", userInfo);
        when(orderRepository.save(order)).thenReturn(order);

        OrderInfo savedOrder = orderService.saveOrderInfo(order);
        assertThat(savedOrder.getTotalPrice()).isEqualTo(2 * 11 + 3 * 12);
        assertThat(savedOrder.getOrderTime()).isGreaterThan(0);
    }

    private OrderInfo generateOrder(String restaurantId, List<FoodItem> items, String specialNote, UserInfo userInfo) {
        OrderInfo order = new OrderInfo();
        order.setRestaurantId(restaurantId);
        order.setFoodItems(items);
        order.setSpecialNote(specialNote);
        order.setUserInfo(userInfo);
        return order;
    }


    private FoodItem generateFoodItem(String name, int price, int quantity) {
        FoodItem foodItem = new FoodItem();
        foodItem.setName(name);
        foodItem.setPrice(price);
        foodItem.setQuantity(quantity);
        return foodItem;
    }
}
