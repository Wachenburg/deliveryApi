package com.deliveryApi.Delivery.API.Project.controller;


import com.deliveryApi.Delivery.API.Project.entity.*;
import com.deliveryApi.Delivery.API.Project.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.deliveryApi.Delivery.API.Project.enums.Role.CLIENTE;

@TestConfiguration
public class TestDataConfiguration {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @BeforeTestMethod
    public void setupTestData() {
        // Limpar dados existentes
        clienteRepository.deleteAll();
        pedidoRepository.deleteAll();
        produtoRepository.deleteAll();
        restauranteRepository.deleteAll();
        usuarioRepository.deleteAll();

        // Criar dados de teste
        Cliente cliente = new Cliente();
        cliente.setNome("João Teste");
        cliente.setEmail("joao.teste@email.com");
        cliente.setTelefone("11999999999");
        clienteRepository.save(cliente);

        Usuario usuario = new Usuario();
        usuario.setDataCriacao(LocalDateTime.now());
        usuario.setEmail(cliente.getEmail());
        usuario.setNome(cliente.getNome());
        usuario.setSenha("senhaTeste123");
        usuario.setRole(CLIENTE);
        usuarioRepository.save(usuario);

        Restaurante restaurante = new Restaurante();
        restaurante.setNome("Restaurante Teste");
        restaurante.setCategoria("Categoria Teste");
        restaurante.setEndereco("Add-res teste");
        restaurante.setCep("99999-999");
        restaurante.setTelefone("51999999999");
        restaurante.setTaxaEntrega(BigDecimal.valueOf(40.0));
        restauranteRepository.save(restaurante);

        Produto produto = new Produto();
        produto.setNome("Pizza Teste");
        produto.setDescricao("Pizza para testes");
        produto.setPreco(BigDecimal.valueOf(29.90));
        produto.setRestaurante(restaurante);
        produtoRepository.save(produto);

        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setQuantidade(1);
        itemPedido.setPrecoUnitario(BigDecimal.valueOf(29.90));
        itemPedido.setSubtotal(BigDecimal.valueOf(29.90));
        itemPedido.setProduto(produto);
        List<ItemPedido>itensPedido = new ArrayList<>();
        itensPedido.add(itemPedido);

        Pedido pedido = new Pedido();
        pedido.setNumeroPedido("01");
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setStatus("Em Preparo");
        pedido.setValorTotal(BigDecimal.valueOf(29.90));
        pedido.setItens(itensPedido);
        pedidoRepository.save(pedido);

    }
}
