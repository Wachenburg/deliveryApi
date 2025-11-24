package com.deliveryApi.Delivery.API.Project.dto.response;

import com.deliveryApi.Delivery.API.Project.entity.Restaurante;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class RestauranteResponseDTO {
    private Long id;
    private String nome;
    private String categoria;
    private String endereco;
    private String telefone;
    private BigDecimal taxaEntrega;
    private BigDecimal avaliacao;
    private Boolean ativo;
}
