package com.server.server.Entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String sku;
    private  float weight;
    private  float height;
    private  float width;
    private  float depth;
    private Date dateUpd;
    private Date dateUpdDescription;
    private Date dateUpdImages;
    private Date dateUpdStock;
    private boolean active;
    /*
    private  int ean13;


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

    @JsonIgnore
    @OneToOne(cascade = CascadeType.MERGE,mappedBy = "product")
    private Promotion promotion;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<Review> reviews;

    @ManyToOne()
    private ShoppingCart shoppingCart;

    @ManyToOne()
    private Orders orders;

    @ManyToOne()
    private Categories categories;

}


