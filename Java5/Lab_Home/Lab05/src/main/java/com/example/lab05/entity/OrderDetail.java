package com.example.lab05.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.criteria.Order;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_details")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;


    @ManyToOne@JoinColumn(name = "product_id",referencedColumnName = "id")
    private Product product;

    @ManyToOne@JoinColumn(name = "order_id",referencedColumnName = "id")
    private Orders orders;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private Integer price;


}
