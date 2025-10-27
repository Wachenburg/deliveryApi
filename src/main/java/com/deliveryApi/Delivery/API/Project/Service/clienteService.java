package com.deliveryApi.Delivery.API.Project.Service;

import com.deliveryApi.Delivery.API.Project.Entity.cliente;
import com.deliveryApi.Delivery.API.Project.Repository.clienteRepository;

import jakarta.websocket.ClientEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class clienteService {
    @Autowired
    private clienteRepository ClienteRepository;

    public cliente cadastrar(cliente Cliente) {
        if (ClienteRepository.existsByEmail(Cliente.getEmail())){
            throw new IllegalArgumentException("Email já cadastrado: "+Cliente.getEmail());
        }
        //validarDadosCLiente(Cliente);
        Cliente.setAtivo(true);
        return ClienteRepository.save(Cliente);
    }

    public List<cliente> listarAtivos() {

        return new ArrayList<>();
    }

    public Optional<cliente> buscarPorId(Long id) {
        return ClienteRepository.findById(id);
    }

    public cliente atualizar(Long id, cliente clienteAtt) {
        cliente Cliente = buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado: "+id));
        if(!Cliente.getEmail().equals(clienteAtt.getEmail()) && ClienteRepository.existsByEmail(clienteAtt.getEmail())){
            throw new IllegalArgumentException("Email já cadastrado: "+clienteAtt.getEmail());
        }
        Cliente.setNome(clienteAtt.getNome());
        Cliente.setEmail(clienteAtt.getEmail());
        Cliente.setTelefone(clienteAtt.getTelefone());
        Cliente.setEndereco(clienteAtt.getEndereco());
        return ClienteRepository.save(Cliente);
    }

    public void inativar(Long id) {
    }

    public List<cliente> buscarPorNome(String nome) {
        return new ArrayList<>();
    }

    public Optional<cliente> buscarPorEmail(String email) {
        return Optional.of(new cliente());
    }
}
