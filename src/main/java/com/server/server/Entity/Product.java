package com.server.server.Entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity

public class Product {
    @Id
    private long id;

    private String sku;

    private  float weight;

    private  float height;

    private  int width;

    private  float depth;

    private Date dateUpd;

    private String categories;


    private Date dateUpdDescription;

    private Date dateUpdImages;

    private Date dateUpdStock;

    private boolean active;

    private float wholesalePrice;

    private float retailPrice;

    private float inShopsPrice;


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
    private Category category;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<Images> images;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<Tags> tags;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<Attributes> attributes;


}


