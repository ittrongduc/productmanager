package com.zdzz.product.service;

import com.zdzz.product.model.OrderDetails;
import com.zdzz.product.repository.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class OrderDetailsDAO {

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    public List<OrderDetails> getAllOrderDetailss(){
        return orderDetailsRepository.findAll();
    }

    public OrderDetails saveOrderDetails(OrderDetails orderDetails){
        if (Objects.isNull(orderDetails)){
            return new OrderDetails();
        }
        return orderDetailsRepository.insert(orderDetails);
    }

    public OrderDetails updateOrderDetails(String _id, OrderDetails orderDetailsNew){
        if (Objects.isNull(orderDetailsNew) && Objects.isNull(orderDetailsNew.get_id())){
            return new OrderDetails();
        }
        Optional<OrderDetails> orderDetailsOld = findById(_id);
        if (Objects.nonNull(orderDetailsOld)){
            orderDetailsNew.set_id(orderDetailsOld.get().get_id());
            return orderDetailsRepository.save(orderDetailsNew);
        }
        return new OrderDetails();
    }

    public String deleteOrderDetails(String _id){
        Optional<OrderDetails> orderDetails = findById(_id);
        if (Objects.nonNull(orderDetails.get())){
            orderDetailsRepository.delete(orderDetails.get());
        }
        return String.format("OrderDetails with id: %s has been removed", _id);
    }

    public Optional<OrderDetails> findById(String _id){
        return orderDetailsRepository.findById(_id);
    }
}
