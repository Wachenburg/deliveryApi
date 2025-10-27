package com.deliveryApi.Delivery.API.Project.Controller;

import com.deliveryApi.Delivery.API.Project.Entity.cliente;
import com.deliveryApi.Delivery.API.Project.Service.clienteService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "*")
public class clienteController {

    @Autowired
    private clienteService ClienteService;

    @PostMapping
    public ResponseEntity<?> cadastrar(@Validated @RequestBody cliente Cliente) {
        try{
            cliente clienteSalvo = ClienteService.cadastrar(Cliente);
            return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body("Erro: " + e.getMessage());
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("INTERNAL SERVER ERROR");
        }
    };

    @GetMapping
    public ResponseEntity<List<cliente>> listar() {
        List<cliente> clientes = ClienteService.listarAtivos();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Optional<cliente> clienteId = ClienteService.buscarPorId(id);
        if(clienteId.isPresent()){
            return ResponseEntity.ok(clienteId.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar (@PathVariable Long id, @Validated @RequestBody cliente clienteAtt) {
        try{
            cliente clienteAtualizado = ClienteService.atualizar(id, clienteAtt);
            return ResponseEntity.ok(clienteAtualizado);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body("Erro" + e.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("INTERNAL SERVER ERROR");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> inativar(@PathVariable Long id){
        try{
            ClienteService.inativar(id);
            return ResponseEntity.ok().body("Cliente inativado com sucesso");
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body("Erro" + e.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("INTERNAL SERVER ERROR");
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<cliente>> buscarPorNome(@RequestParam String nome) {
        List<cliente> Clientes = ClienteService.buscarPorNome(nome);
        return ResponseEntity.ok(Clientes);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<?> buscarPorEmail(@PathVariable String email) {
        Optional<cliente> cliente = ClienteService.buscarPorEmail(email);
        if(cliente.isPresent()){
            return ResponseEntity.ok(cliente.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
