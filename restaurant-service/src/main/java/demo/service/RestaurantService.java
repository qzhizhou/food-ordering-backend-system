package demo.service;

import demo.model.Restaurant;

public interface RestaurantService {

    void saveRestaurantInfomation(Restaurant restaurant);

    Restaurant findRestaurantByName(String name);

}
