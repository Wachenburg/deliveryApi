package com.deliveryApi.Delivery.API.Project.Repository;

import com.deliveryApi.Delivery.API.Project.Entity.cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface clienteRepository extends JpaRepository<cliente, Long> {

    Optional<cliente> findByEmail(String email);

    boolean existsByEmail(String email);

    List<cliente> findByAtivoTrue();

    List<cliente> findByNomeContainingIgnoreCase(String nome);

}
