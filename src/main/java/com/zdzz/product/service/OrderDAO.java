package com.zdzz.product.service;

import com.zdzz.product.model.Order;
import com.zdzz.product.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class OrderDAO {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public Order saveOrder(Order order){
        if (Objects.isNull(order)){
            return new Order();
        }
        return orderRepository.insert(order);
    }

    public Order updateOrder(String _id, Order orderNew){
        if (Objects.isNull(orderNew) && Objects.isNull(orderNew.getId())){
            return new Order();
        }
        Optional<Order> orderOld = findById(_id);
        if (Objects.nonNull(orderOld)){
            orderNew.setId(orderOld.get().getId());
            return orderRepository.save(orderNew);
        }
        return new Order();
    }

    public String deleteOrder(String _id){
        Optional<Order> order = findById(_id);
        if (Objects.nonNull(order.get())){
            orderRepository.delete(order.get());
        }
        return String.format("Order with id: %s has been removed", _id);
    }

    public Optional<Order> findById(String _id){
        return orderRepository.findById(_id);
    }
}
