package com.deliveryApi.Delivery.API.Project.exceptions;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class BusinessException extends RuntimeException{

    public BusinessException(@NotBlank(message = "O email é obrigatório") @Email(message = "O email precisa ser válido") String s) {
    }
}
