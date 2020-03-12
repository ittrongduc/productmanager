package com.zdzz.product.controller;

import com.zdzz.product.model.Tag;
import com.zdzz.product.service.TagDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TagController {

    @Autowired
    private TagDAO tagDAO;

    @RequestMapping(value = "/tags", method = RequestMethod.GET)
    public List<Tag> getAllTags(){
        return tagDAO.getAllTags();
    }

    @RequestMapping(value = "/tag/{_id}", method = RequestMethod.GET)
    public Optional<Tag> getTagById(@PathVariable("_id") String _id){
        return tagDAO.findById(_id);
    }

    @RequestMapping(value = "/tag/insert", method = RequestMethod.POST)
    public Tag insertTag(@RequestBody Tag tag){
        return tagDAO.saveTag(tag);
    }

    @RequestMapping(value = "/tag/delete/{_id}", method = RequestMethod.GET)
    public String removeTag(@PathVariable("_id") String _id){
        return tagDAO.deleteTag(_id);
    }

    @RequestMapping(value = "/tag/update/{_id}", method = RequestMethod.POST)
    public Tag updateTag(@PathVariable("_id") String _id, @RequestBody Tag tag){
        return tagDAO.updateTag(_id, tag);
    }

}
