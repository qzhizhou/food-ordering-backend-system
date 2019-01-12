package demo.service;

import demo.model.MenuItem;

import java.util.List;

public interface MenuItemService {

    void saveMenuItem(MenuItem menuItem);

    void saveMenuItemList(List<MenuItem> menuItemList);

    MenuItem getMenuItemByName(String name);

    List<MenuItem> getAllMenuItemsByRestaurantId(String rid);
}
