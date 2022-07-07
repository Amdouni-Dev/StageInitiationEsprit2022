package com.server.server.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.server.server.Entity.Review;
import com.server.server.Entity.Order;
import com.server.server.Entity.ShoppingCart;
import com.server.server.Entity.Promotion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDto {
    private long id;
    private int manufacturer;
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
    //private PriceLargeQuantities priceLargeQuantities;
    //private PriceLargeQuantities priceLargeQuantities;
    private transient Promotion promotion;
    private transient List<Review> reviews;
    private transient ShoppingCart shoppingCart;

    private transient Order order;


}