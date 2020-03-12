package com.zdzz.product.controller;

import com.zdzz.product.model.User;
import com.zdzz.product.service.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getAllUsers(){
        return userDAO.getAllUsers();
    }

    @RequestMapping(value = "/user/{_id}", method = RequestMethod.GET)
    public Optional<User> getUserById(@PathVariable("_id") String _id){
        return userDAO.findById(_id);
    }

    @RequestMapping(value = "/user/insert", method = RequestMethod.POST)
    public User insertUser(@RequestBody User user){
        return userDAO.saveUser(user);
    }

    @RequestMapping(value = "/user/delete/{_id}", method = RequestMethod.GET)
    public String removeUser(@PathVariable("_id") String _id){
        return userDAO.deleteUser(_id);
    }

    @RequestMapping(value = "/user/update/{_id}", method = RequestMethod.POST)
    public User updateUser(@PathVariable("_id") String _id, @RequestBody User user){
        return userDAO.updateUser(_id, user);
    }

}
