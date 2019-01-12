package demo.rest;

import demo.model.MenuItem;
import demo.model.Restaurant;
import demo.service.impl.MenuItemServiceImpl;
import demo.service.impl.RestaurantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestaurantServiceRestController {
    private MenuItemServiceImpl menuItemService;
    private RestaurantServiceImpl restaurantService;

    @Autowired
    public RestaurantServiceRestController(
            MenuItemServiceImpl menuItemService,
            RestaurantServiceImpl restaurantService
    ){
        this.menuItemService = menuItemService;
        this.restaurantService = restaurantService;
    }

    @RequestMapping(value = "/restaurants", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void uploadRestaurantInfo(@RequestBody Restaurant restaurant){
        restaurantService.saveRestaurantInfomation(restaurant);
    }

    @RequestMapping(value = "/restaurants", method = RequestMethod.GET)
    public Restaurant getRestaurantByName(@RequestParam(value = "name") String name){
        return restaurantService.findRestaurantByName(name);
    }

    @RequestMapping(value = "/restaurants/{rid}/menuItem", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void uploadMenuItem(@RequestBody MenuItem menuItem){
        menuItemService.saveMenuItem(menuItem);
    }

    @RequestMapping(value = "/restaurants/bulk/menuItem", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void uploadMenuItemList(@RequestBody List<MenuItem> menuItemList){
        menuItemService.saveMenuItemList(menuItemList);
    }

    @RequestMapping(value = "restaurants/{rid}/menuItem", method = RequestMethod.GET)
    public List<MenuItem> getAllMenusByRestaurantId(@PathVariable String rid){
        return menuItemService.getAllMenuItemsByRestaurantId(rid);
    }

//    @RequestMapping(value = "restaurants/{rid}/menuItem", method = RequestMethod.GET)
//    public MenuItem getMenuItemByName(@RequestBody String name){
//        return menuItemService.getMenuItemByName(name);
//    }
}
