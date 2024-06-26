package com.example.thymeleaf_demo.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
    private String imageUrl;
    private String brand;
    private int stock;
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<Review>();
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    /*@ManyToMany
    @JoinTable(name = "product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories;*/

    public Product() {
    }

    public Product(String name, String description, BigDecimal price, String imageUrl,
                    Category category,String brand) {
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.description = description;
        this.imageUrl = imageUrl;
        this.category = category;
    }

}























