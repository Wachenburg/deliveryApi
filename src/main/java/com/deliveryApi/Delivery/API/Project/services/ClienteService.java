package com.deliveryApi.Delivery.API.Project.services;


import com.deliveryApi.Delivery.API.Project.dto.request.ClienteRequestDTO;
import com.deliveryApi.Delivery.API.Project.dto.response.ClienteResponseDTO;

import java.util.List;

public interface ClienteService {
    ClienteResponseDTO cadastrar(ClienteRequestDTO dto);
    ClienteResponseDTO buscarPorId(Long id);
    ClienteResponseDTO atualizar(Long id, ClienteRequestDTO dto);
    ClienteResponseDTO ativarDesativar(Long id);
    List<ClienteResponseDTO> listarAtivos();
    List<ClienteResponseDTO> buscarPorNomes(String nome);
}
