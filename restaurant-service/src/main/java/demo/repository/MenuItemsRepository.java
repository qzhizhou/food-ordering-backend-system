package demo.repository;

import demo.model.MenuItem;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.Description;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "menuitems")
public interface MenuItemsRepository extends PagingAndSortingRepository<MenuItem, String> {

    @RestResource(rel = "by-rid", description = @Description("find all menus by restaurant id"))
    List<MenuItem> findAllByRestaurantId(@Param("restaurantId") String rid);

    @RestResource(rel = "by-name", description = @Description("find menu by menu name"))
    MenuItem findByName(@Param("name") String name);
}
