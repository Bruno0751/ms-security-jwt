package com.dev.spring_security.repositories;

import com.dev.spring_security.model.ProductsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<ProductsModel, Long>{
}
