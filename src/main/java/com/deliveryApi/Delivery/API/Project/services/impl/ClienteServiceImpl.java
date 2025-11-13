package com.deliveryApi.Delivery.API.Project.services.impl;

import com.deliveryApi.Delivery.API.Project.dto.request.ClienteRequestDTO;
import com.deliveryApi.Delivery.API.Project.dto.response.ClienteResponseDTO;
import com.deliveryApi.Delivery.API.Project.entity.Cliente;
import com.deliveryApi.Delivery.API.Project.exceptions.BusinessException;
import com.deliveryApi.Delivery.API.Project.repository.ClienteRepository;
import com.deliveryApi.Delivery.API.Project.services.ClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ClienteResponseDTO cadastrar(ClienteRequestDTO dto) {
        if(clienteRepository.existsByEmail(dto.getEmail())){
            throw new BusinessException("Email já cadastrado" + dto.getEmail());
        }
        Cliente cliente = modelMapper.map(dto, Cliente.class);
        cliente.setAtivo(true);
        Cliente saveSalvo = clienteRepository.save(cliente);
        return modelMapper.map(saveSalvo, ClienteResponseDTO.class);
    }

    @Override
    public ClienteResponseDTO buscarPorId(Long id) {
        return null;
    }

    @Override
    public ClienteResponseDTO atualizar(Long id, ClienteRequestDTO dto) {
        Cliente clienteExistente = clienteRepository.findById(id).orElseThrow(() -> new BusinessException("Cliente não encontrado: " + id));
        if(clienteRepository.existsByEmail(dto.getEmail())){
            throw new BusinessException("Email já cadastrado" + dto.getEmail());
        }
        if(dto.getNome() == null || dto.getNome().isEmpty()){
            throw new BusinessException("Nome não pode ser vazio");
        }
        if(dto.getEmail() == null || dto.getEmail().isEmpty()){
            throw new BusinessException("Email não pode ser vazio");
        }
        clienteExistente.setNome(dto.getNome());
        clienteExistente.setTelefone(dto.getTelefone());
        clienteExistente.setEmail(dto.getEmail());
        clienteExistente.setEndereco(dto.getEndereco());
        Cliente saveAtualizado = clienteRepository.save(clienteExistente);
        return modelMapper.map(saveAtualizado, ClienteResponseDTO.class);
    }

    @Override
    public ClienteResponseDTO ativarDesativar(Long id) {
        return null;
    }

    @Override
    public List<ClienteResponseDTO> listarAtivos() {
        return List.of();
    }

    @Override
    public List<ClienteResponseDTO> buscarPorNomes(String nome) {
        return List.of();
    }
}
