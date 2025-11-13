package com.deliveryApi.Delivery.API.Project.dto.request;

import lombok.Data;

@Data
public class RestauranteRequestDTO {
    private String nome;

    private String categoria;

    private String endereco;

    private String telefone;
}
