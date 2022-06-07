package com.example.lab34.repository;

import com.example.lab34.model.OrderDetail;
import com.example.lab34.model.OrderDetailId;
import org.springframework.data.jpa.repository.JpaRepository;



public interface IOrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailId> {

}
