package com.deliveryApi.Delivery.API.Project.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ClienteRequestDTO {
    @NotBlank(message = "O nome é obrigatório")
    private String nome;
    @NotBlank(message = "O email é obrigatório")
    @Email(message = "O email precisa ser válido")
    private String email;
    @NotBlank(message = "O telefone é obrigatório")
    private String telefone;
    @NotBlank(message = "O endereço é obrigatório")
    private String endereco;
}
