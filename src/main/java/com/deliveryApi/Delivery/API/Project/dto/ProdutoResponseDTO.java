package com.deliveryApi.Delivery.API.Project.dto;

import com.deliveryApi.Delivery.API.Project.entity.Produto;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProdutoResponseDTO {
    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private String categoria;
    private Boolean disponivel;
    private Long restauranteId;

    public ProdutoResponseDTO(Produto save) {
        this.id = save.getId();
        this.nome = save.getNome();
        this.descricao = save.getDescricao();
        this.preco = save.getPreco();
        this.categoria = save.getCategoria();
        this.disponivel = save.getDisponivel();
        this.restauranteId = save.getRestauranteId();
    }
}
