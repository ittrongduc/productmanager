package com.zdzz.product.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Locale;

@Document(collection = "tProduct")
public class Product {

    @Id
    private String id;
    private String name;
    private BigDecimal listPrice;
    private BigDecimal salePrice;
    private long expiredSale;
    private String image;
    private String description;
    private long createdDate;

    private String categoryId;
    private String tagId;
    private String attributesId;



    public Product() {
    }

    public BigDecimal getListPrice() {
        return listPrice;
    }

    public void setListPrice(BigDecimal listPrice) {
        this.listPrice = listPrice;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public long getExpiredSale() {
        return expiredSale;
    }

    public void setExpiredSale(long expiredSale) {
        this.expiredSale = expiredSale;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(long createdDate) {
        this.createdDate = createdDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getAttributesId() {
        return attributesId;
    }

    public void setAttributesId(String attributesId) {
        this.attributesId = attributesId;
    }
}
