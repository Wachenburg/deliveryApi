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

    /**
     * Cadastrar novo cliente
     */
    public cliente cadastrar(cliente Cliente) {
        // Validar email único
        if (ClienteRepository.existsByEmail(Cliente.getEmail())) {
            throw new IllegalArgumentException("Email já cadastrado: " + Cliente.getEmail());
        }
        // Validações de negócio
        validarDadosCliente(Cliente);
        // Definir como ativo por padrão
        Cliente.setAtivo(true);
        return ClienteRepository.save(Cliente);
    }

    /**
     * Buscar cliente por ID
     */
    @Transactional(readOnly = true)
    public Optional<cliente> buscarPorId(Long id) {
        return ClienteRepository.findById(id);
    }

    /**
     * Buscar cliente por email
     */
    @Transactional(readOnly = true)
    public Optional<cliente> buscarPorEmail(String email) {
        return ClienteRepository.findByEmail(email);
    }

    /**
     * Listar todos os clientes ativos
     */
    @Transactional(readOnly = true)
    public List<cliente> listarAtivos() {
        return ClienteRepository.findByAtivoTrue();
    }

    /**
     * Atualizar dados do cliente
     */
    public cliente atualizar(Long id, cliente clienteAtt) {
        cliente Cliente = buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado: " + id));
        // Verificar se email não está sendo usado por outro cliente
        if (!Cliente.getEmail().equals(clienteAtt.getEmail()) &&
                ClienteRepository.existsByEmail(clienteAtt.getEmail())) {
            throw new IllegalArgumentException("Email já cadastrado: " + clienteAtt.getEmail());
        }

        // Atualizar campos
        Cliente.setNome(clienteAtt.getNome());
        Cliente.setEmail(clienteAtt.getEmail());
        Cliente.setTelefone(clienteAtt.getTelefone());
        Cliente.setEndereco(clienteAtt.getEndereco());

        return ClienteRepository.save(Cliente);
    }

    /**
     * Inativar cliente (soft delete)
     */
    public void inativar(Long id) {
        cliente Cliente = buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado: " + id));
        Cliente.inativar();
        ClienteRepository.save(Cliente);
    }

    /**
     * Buscar clientes por nome
     */
    @Transactional(readOnly = true)
    public List<cliente> buscarPorNome(String nome) {
        return ClienteRepository.findByNomeContainingIgnoreCase(nome);
    }

    /**
     * Validações de negócio
     */
    private void validarDadosCliente(cliente Cliente) {
        if (Cliente.getNome() == null || Cliente.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome é obrigatório");
        }
        if (Cliente.getEmail() == null || Cliente.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("Email é obrigatório");
        }
        if (Cliente.getNome().length() < 2) {
            throw new IllegalArgumentException("Nome deve ter pelo menos 2 caracteres");
        }
    }
}