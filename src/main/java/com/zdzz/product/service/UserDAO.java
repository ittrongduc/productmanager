package com.zdzz.product.service;

import com.zdzz.product.model.User;
import com.zdzz.product.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserDAO {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User saveUser(User user){
        if (Objects.isNull(user)){
            return new User();
        }
        return userRepository.insert(user);
    }

    public User updateUser(String _id, User userNew){
        if (Objects.isNull(userNew) && Objects.isNull(userNew.getId())){
            return new User();
        }
        Optional<User> userOld = findById(_id);
        if (Objects.nonNull(userOld)){
            userNew.setId(userOld.get().getId());
            return userRepository.save(userNew);
        }
        return new User();
    }

    public String deleteUser(String _id){
        Optional<User> user = findById(_id);
        if (Objects.nonNull(user.get())){
            userRepository.delete(user.get());
        }
        return String.format("User with id: %s has been removed", _id);
    }

    public Optional<User> findById(String _id){
        return userRepository.findById(_id);
    }
}
