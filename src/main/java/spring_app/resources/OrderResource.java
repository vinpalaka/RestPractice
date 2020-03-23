package spring_app.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring_app.dao.OrderRepository;
import spring_app.dto.OrderRequest;
import spring_app.entity.Order;

@RestController
@RequestMapping(path = "/api/v1/order")
public class OrderResource {

    private OrderRepository orderRepository;

    @Autowired
    public OrderResource(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping(path = "/{orderId}")
    public Order getByOrderId(@PathVariable Long orderId) {
        return orderRepository.findById(orderId).orElse(new Order());
    }

    @PutMapping(path = "/{orderId}")
    public Order updateOrder(@PathVariable Long orderId, @RequestBody OrderRequest orderRequest) {
        Order order = getByOrderId(orderId);
        order.setName(orderRequest.getName());
        order.setUpdatedBy(orderRequest.getUpdatedBy());
        orderRepository.save(order);
        return order;
    }

    @PostMapping
    public Order createOrder(@RequestBody OrderRequest orderRequest) {
        Order order = new Order();
        order.setUpdatedBy(orderRequest.getUpdatedBy());
        order.setName(orderRequest.getName());
        return orderRepository.save(order);
    }

    @DeleteMapping(path = "/{orderId}")
    public void deleteByOrderId(@PathVariable Long orderId) {
        orderRepository.deleteById(orderId);
    }
}
