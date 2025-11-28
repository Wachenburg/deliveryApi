package com.deliveryApi.Delivery.API.Project.services;

import java.math.BigDecimal;
import java.util.List;

import com.deliveryApi.Delivery.API.Project.dto.request.ItemPedidoRequestDTO;
import com.deliveryApi.Delivery.API.Project.dto.request.PedidoRequestDTO;
import com.deliveryApi.Delivery.API.Project.dto.response.PedidoResponseDTO;
import com.deliveryApi.Delivery.API.Project.enums.StatusPedido;

public interface PedidoService {

    PedidoResponseDTO criarPedido(PedidoRequestDTO dto);

    PedidoResponseDTO buscarPorId(Long id);

    List<PedidoResponseDTO> listarPedidosPorCliente(Long clienteId);

    PedidoResponseDTO atualizarStatusPedido(Long id, StatusPedido status);

    BigDecimal calcularValorTotalPedido(List<ItemPedidoRequestDTO> itens );

    PedidoResponseDTO cancelarPedido(Long id);

}