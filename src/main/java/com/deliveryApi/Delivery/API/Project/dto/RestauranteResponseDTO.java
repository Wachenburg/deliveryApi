package com.deliveryApi.Delivery.API.Project.dto;

import com.deliveryApi.Delivery.API.Project.entity.Restaurante;
import jakarta.persistence.Column;
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

    public RestauranteResponseDTO(Restaurante save) {
        this.id = save.getId();
        this.nome = save.getNome();
        this.categoria = save.getCategoria();
        this.endereco = save.getEndereco();
        this.telefone = save.getTelefone();
        this.taxaEntrega = save.getTaxaEntrega();
        this.avaliacao = save.getAvaliacao();
    }

}
