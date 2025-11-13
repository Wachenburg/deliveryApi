package com.deliveryApi.Delivery.API.Project.dto.response;

import com.deliveryApi.Delivery.API.Project.entity.Cliente;
import lombok.Data;

@Data
public class ClienteResponseDTO {
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String endereco;
    private Boolean ativo;

}
