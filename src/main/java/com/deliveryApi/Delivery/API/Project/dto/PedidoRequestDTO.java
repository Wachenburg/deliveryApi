package com.deliveryApi.Delivery.API.Project.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PedidoRequestDTO {

    private String numeroPedido;

    private String status;

    private BigDecimal valorTotal;

    private String observacoes;
}
