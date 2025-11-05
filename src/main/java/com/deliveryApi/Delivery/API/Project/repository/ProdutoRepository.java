package com.deliveryApi.Delivery.API.Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deliveryApi.Delivery.API.Project.entity.Produto;

import java.util.List;


@Repository
public interface ProdutoRepository extends JpaRepository <Produto, Long> {
    // buscar produto por restaurante ID
    List<Produto> findByRestauranteId(Long restauranteId);

}
