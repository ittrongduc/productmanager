package com.zdzz.product.service;

import com.zdzz.product.model.Tag;
import com.zdzz.product.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TagDAO {

    @Autowired
    private TagRepository tagRepository;

    public List<Tag> getAllTags(){
        return tagRepository.findAll();
    }

    public Tag saveTag(Tag tag){
        if (Objects.isNull(tag)){
            return new Tag();
        }
        return tagRepository.insert(tag);
    }

    public Tag updateTag(String _id, Tag tagNew){
        if (Objects.isNull(tagNew) && Objects.isNull(tagNew.getId())){
            return new Tag();
        }
        Optional<Tag> tagOld = findById(_id);
        if (Objects.nonNull(tagOld)){
            tagNew.setId(tagOld.get().getId());
            return tagRepository.save(tagNew);
        }
        return new Tag();
    }

    public String deleteTag(String _id){
        Optional<Tag> tag = findById(_id);
        if (Objects.nonNull(tag.get())){
            tagRepository.delete(tag.get());
        }
        return String.format("Tag with id: %s has been removed", _id);
    }

    public Optional<Tag> findById(String _id){
        return tagRepository.findById(_id);
    }
}
