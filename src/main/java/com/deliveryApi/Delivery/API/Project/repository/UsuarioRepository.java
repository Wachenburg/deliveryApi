package com.deliveryApi.Delivery.API.Project.repository;

import com.deliveryApi.Delivery.API.Project.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

    boolean existsByEmail(String email);

    Optional<Usuario> findByEmailAndAtivo(String email, boolean ativo);
}
