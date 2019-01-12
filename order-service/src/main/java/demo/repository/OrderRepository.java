package demo.repository;

import demo.model.OrderInfo;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.Description;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "orders")
public interface OrderRepository extends PagingAndSortingRepository<OrderInfo, String> {

    @RestResource(rel = "find-by-id", description = @Description("Find-by-id"))
    OrderInfo findFirstById(@Param("id") String id);

    @RestResource(rel = "delete-by-id", description = @Description("Delete-by-id"))
    void deleteById(@Param("id") String id);

}
