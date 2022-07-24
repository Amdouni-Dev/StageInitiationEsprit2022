package com.server.server.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.server.server.Entity.Attributes;
import com.server.server.Entity.Category;
import com.server.server.Entity.Images;
import com.server.server.Entity.Review;
import com.server.server.Entity.Orders;
import com.server.server.Entity.ShoppingCart;
import com.server.server.Entity.Promotion;
import com.server.server.Entity.Tags;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDto implements Serializable {

    private long id;
    private String sku;
    private String name;
    private String description;
    private String url;
    private String isoCode;
    private  float weight;
    private  float height;
    private  float width;
    private  float depth;
    private Date dateUpd;
    private String categories;
    private Date dateUpdDescription;
    private Date dateUpdImages;
    private Date dateUpdStock;
    //private boolean active;
    private float wholesalePrice;
    private float retailPrice;
    private float inShopsPrice;
    /*private int manufacturer;
    private String  sku;
    private  int ean13;
    private  int weight;
    private  int height;
    private  int width;
    private  int depth;
    private Date dateUpd;
    private long category;
    private Date dateUpdDescription;
    private Date dateUpdImages;
    private Date dateUpdStock;
    private float wholesalePrice;
    private float retailPrice;
    private Date dateAdd;
    private int video;
    private boolean active;
    //private Attributes attributes;
    //private Categories categories;
    //private Images images;
    private float taxRate;
    private int taxId;
    private float inShopsPrice;
    private String condition;
    private String logisticClass;
    //private Tags tags;
    private Date dateUpdProperties;
    private Date dateUpdCategories;
    //private PriceLargeQuantities priceLargeQuantities;*/

    private transient Promotion promotion;
    private transient List<Review> reviews;
    private transient ShoppingCart shoppingCart;
    private transient Orders orders;
    private transient Category category;
    private transient List<Images> images;
    private transient List<Tags> tags;
    private transient List<Attributes> attributes;
}