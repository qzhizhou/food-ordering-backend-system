package demo.service.impl;

import demo.model.MenuItem;
import demo.repository.MenuItemsRepository;
import demo.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemServiceImpl implements MenuItemService {

    private MenuItemsRepository menuItemsRepository;

    @Autowired
    public MenuItemServiceImpl(MenuItemsRepository menuItemsRepository){
        this.menuItemsRepository = menuItemsRepository;
    }

    @Override
    public void saveMenuItem(MenuItem menuItem) {
        menuItemsRepository.save(menuItem);
    }

    @Override
    public void saveMenuItemList(List<MenuItem> menuItemList) {
        menuItemsRepository.save(menuItemList);
    }

    @Override
    public MenuItem getMenuItemByName(String name) {
        return menuItemsRepository.findByName(name);
    }

    @Override
    public List<MenuItem> getAllMenuItemsByRestaurantId(String rid) {
        return menuItemsRepository.findAllByRestaurantId(rid);
    }
}
