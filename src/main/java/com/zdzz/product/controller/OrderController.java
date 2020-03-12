package com.zdzz.product.controller;

import com.zdzz.product.model.Order;
import com.zdzz.product.service.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {

    @Autowired
    private OrderDAO orderDAO;

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public List<Order> getAllOrders(){
        return orderDAO.getAllOrders();
    }

    @RequestMapping(value = "/order/{_id}", method = RequestMethod.GET)
    public Optional<Order> getOrderById(@PathVariable("_id") String _id){
        return orderDAO.findById(_id);
    }

    @RequestMapping(value = "/order/insert", method = RequestMethod.POST)
    public Order insertOrder(@RequestBody Order order){
        return orderDAO.saveOrder(order);
    }

    @RequestMapping(value = "/order/delete/{_id}", method = RequestMethod.GET)
    public String removeOrder(@PathVariable("_id") String _id){
        return orderDAO.deleteOrder(_id);
    }

    @RequestMapping(value = "/order/update/{_id}", method = RequestMethod.POST)
    public Order updateOrder(@PathVariable("_id") String _id, @RequestBody Order order){
        return orderDAO.updateOrder(_id, order);
    }

}
