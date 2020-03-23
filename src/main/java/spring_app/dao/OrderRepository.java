package spring_app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring_app.entity.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {


}