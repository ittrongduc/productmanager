package com.zdzz.product.service;

import com.zdzz.product.model.Attributes;
import com.zdzz.product.repository.AttributesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AttributesDAO {

    @Autowired
    private AttributesRepository attributesRepository;

    public List<Attributes> getAllAttributes(){
        return attributesRepository.findAll();
    }

    public Attributes saveAttributes(Attributes attributes){
        if (Objects.isNull(attributes)){
            return new Attributes();
        }
        return attributesRepository.insert(attributes);
    }

    public Attributes updateAttributes(String _id, Attributes attributesNew){
        if (Objects.isNull(attributesNew) && Objects.isNull(attributesNew.getId())){
            return new Attributes();
        }
        Optional<Attributes> attributesOld = findById(_id);
        if (Objects.nonNull(attributesOld)){
            attributesNew.setId(attributesOld.get().getId());
            return attributesRepository.save(attributesNew);
        }
        return new Attributes();
    }

    public String deleteAttributes(String _id){
        Optional<Attributes> attributes = findById(_id);
        if (Objects.nonNull(attributes.get())){
            attributesRepository.delete(attributes.get());
        }
        return String.format("Attributes with id: %s has been removed", _id);
    }

    public Optional<Attributes> findById(String _id){
        return attributesRepository.findById(_id);
    }
}
