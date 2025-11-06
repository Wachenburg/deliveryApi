package com.deliveryApi.Delivery.API.Project.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProdutoRequestDTO {
    @NotBlank(message = "Nome é obrigatório")
    private String nome;
    @NotBlank(message = "A descrição é obrigatória")
    private String descricao;
    @NotBlank(message = "O preço é obrigatório")
    private BigDecimal preco;
    @NotBlank(message = "A categoria é obrigatória")
    private String categoria;
}
