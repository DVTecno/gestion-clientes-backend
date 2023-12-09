package com.gestion.clientes.controller;

import com.gestion.clientes.exception.ResourceNotFoundException;
import com.gestion.clientes.model.Cliente;
import com.gestion.clientes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "https://gestion-clientes-frontend-dvtecno.vercel.app")
public class ClienteController {
    final
    ClienteService clienteService;
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    //Consultar todos los clientes
    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> getAllClientes() {
        try {
            List<Cliente> clientes = clienteService.getAllClientes();
            if (clientes != null && !clientes.isEmpty()) {
                return ResponseEntity.ok(clientes);
            } else {
                return ResponseEntity.noContent().build();
            }
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    //Consultar un cliente por id
    @GetMapping("/clientes/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
        try {
            Cliente cliente = clienteService.getClienteById(id);
            if (cliente != null) {
                return ResponseEntity.ok(cliente);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.badRequest().build();
        }

    }
    //Crear un cliente
    @PostMapping("/clientes")
    public ResponseEntity<Cliente> saveCliente(@RequestBody Cliente cliente) {
        try {
            Cliente clienteCreado = clienteService.saveCliente(cliente);
            return ResponseEntity.created(new URI("/clientes/" + clienteCreado.getId())).body(clienteCreado);
        } catch (ResourceNotFoundException | URISyntaxException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    //Actualizar un cliente
    @PutMapping("/clientes/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        System.out.println(cliente);
        try {
            Cliente clienteExistente = clienteService.getClienteById(id);
            if (clienteExistente != null) {
                cliente.setId(id);
                clienteService.saveCliente(cliente);
                return ResponseEntity.ok(cliente);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.badRequest().build();
        }
    }
    //Borrar un cliente
    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<Cliente> deleteCliente(@PathVariable Long id) {
        try {
            Cliente clienteExistente = clienteService.getClienteById(id);
            if (clienteExistente != null) {
                clienteService.deleteCliente(id);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}