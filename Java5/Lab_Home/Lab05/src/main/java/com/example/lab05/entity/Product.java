package com.example.lab05.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String image;

    @Column(name = "price")
    private Integer price;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "available")
    private Integer available;


    @ManyToOne
    @JoinColumn(
            name = "category_id",
            referencedColumnName = "id"
    )
     private Category category;

    @OneToMany(mappedBy = "product")
    List<OrderDetail> orderDetails;



}
