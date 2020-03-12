package com.zdzz.product.controller;

import com.zdzz.product.model.OrderDetails;
import com.zdzz.product.service.OrderDetailsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderDetailsController {

    @Autowired
    private OrderDetailsDAO orderDetailsDAO;

    @RequestMapping(value = "/orderDetailss", method = RequestMethod.GET)
    public List<OrderDetails> getAllOrderDetailss(){
        return orderDetailsDAO.getAllOrderDetailss();
    }

    @RequestMapping(value = "/orderDetails/{_id}", method = RequestMethod.GET)
    public Optional<OrderDetails> getOrderDetailsById(@PathVariable("_id") String _id){
        return orderDetailsDAO.findById(_id);
    }

    @RequestMapping(value = "/orderDetails/insert", method = RequestMethod.POST)
    public OrderDetails insertOrderDetails(@RequestBody OrderDetails orderDetails){
        return orderDetailsDAO.saveOrderDetails(orderDetails);
    }

    @RequestMapping(value = "/orderDetails/delete/{_id}", method = RequestMethod.GET)
    public String removeOrderDetails(@PathVariable("_id") String _id){
        return orderDetailsDAO.deleteOrderDetails(_id);
    }

    @RequestMapping(value = "/orderDetails/update/{_id}", method = RequestMethod.POST)
    public OrderDetails updateOrderDetails(@PathVariable("_id") String _id, @RequestBody OrderDetails orderDetails){
        return orderDetailsDAO.updateOrderDetails(_id, orderDetails);
    }

}
