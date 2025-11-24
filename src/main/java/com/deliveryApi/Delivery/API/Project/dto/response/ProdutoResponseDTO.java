package com.deliveryApi.Delivery.API.Project.dto.response;

import com.deliveryApi.Delivery.API.Project.entity.Produto;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProdutoResponseDTO {
    private Long id;
    private String nome;
    private String descricao;
    private String categoria;
    private Boolean disponivel;
    private BigDecimal preco;
    private boolean ativo;
}
