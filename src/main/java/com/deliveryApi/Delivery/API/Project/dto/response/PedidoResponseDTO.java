package com.deliveryApi.Delivery.API.Project.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.deliveryApi.Delivery.API.Project.dto.request.ItemPedidoRequestDTO;
import com.deliveryApi.Delivery.API.Project.entity.Cliente;
import com.deliveryApi.Delivery.API.Project.entity.Restaurante;
import lombok.Data;


@Data
public class PedidoResponseDTO {
    private Long id;
    private String numeroPedido;
    private LocalDateTime dataPedido;
    private String status;
    private BigDecimal valorTotal;
    private String observacoes;
    private Cliente cliente;
    private Restaurante restaurante;
    private String enderecoEntrega;
    private BigDecimal taxaEntrega;
    List<ItemPedidoRequestDTO> itens;
}
