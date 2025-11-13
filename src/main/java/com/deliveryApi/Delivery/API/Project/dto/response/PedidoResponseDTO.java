package com.deliveryApi.Delivery.API.Project.dto.response;

import com.deliveryApi.Delivery.API.Project.entity.Pedido;
import com.deliveryApi.Delivery.API.Project.entity.Restaurante;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PedidoResponseDTO {

    private Long id;

    private String numeroPedido;

    private LocalDateTime dataPedido;

    private String status;

    private BigDecimal valorTotal;

    private String observacoes;

    private Long clienteId;

    private Restaurante restaurante;

    public PedidoResponseDTO(Pedido save) {
        this.id = save.getId();
        this.numeroPedido = save.getNumeroPedido();
        this.dataPedido = save.getDataPedido();
        this.status = save.getStatus();
        this.valorTotal = save.getValorTotal();
        this.observacoes = save.getObservacoes();
        this.clienteId = save.getClienteId();
        this.restaurante = save.getRestaurante();
    }
}
