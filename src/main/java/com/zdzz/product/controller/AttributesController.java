package com.zdzz.product.controller;

import com.zdzz.product.model.Attributes;
import com.zdzz.product.service.AttributesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AttributesController {

    @Autowired
    private AttributesDAO attributesDAO;

    @RequestMapping(value = "/attributess", method = RequestMethod.GET)
    public List<Attributes> getAllAttributess(){
        return attributesDAO.getAllAttributes();
    }

    @RequestMapping(value = "/attributes/{_id}", method = RequestMethod.GET)
    public Optional<Attributes> getAttributesById(@PathVariable("_id") String _id){
        return attributesDAO.findById(_id);
    }

    @RequestMapping(value = "/attributes/insert", method = RequestMethod.POST)
    public Attributes insertAttributes(@RequestBody Attributes attributes){
        return attributesDAO.saveAttributes(attributes);
    }

    @RequestMapping(value = "/attributes/delete/{_id}", method = RequestMethod.GET)
    public String removeAttributes(@PathVariable("_id") String _id){
        return attributesDAO.deleteAttributes(_id);
    }

    @RequestMapping(value = "/attributes/update/{_id}", method = RequestMethod.POST)
    public Attributes updateAttributes(@PathVariable("_id") String _id, @RequestBody Attributes attributes){
        return attributesDAO.updateAttributes(_id, attributes);
    }

}
