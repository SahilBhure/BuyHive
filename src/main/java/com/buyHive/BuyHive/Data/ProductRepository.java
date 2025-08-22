package com.buyHive.BuyHive.Data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p.sellerId FROM Product p WHERE p.id = :id")
    UserDetails findSellerByProductId(@Param("id") int id);
}
