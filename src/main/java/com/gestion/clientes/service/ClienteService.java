package com.gestion.clientes.service;

import com.gestion.clientes.exception.ResourceNotFoundException;
import com.gestion.clientes.model.Cliente;
import com.gestion.clientes.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteService {
    final
    ClienteRepository clienteRepository;
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> getAllClientes() {

        return clienteRepository.findAll();
    }

    public Cliente getClienteById(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if (cliente == null) {
            throw new ResourceNotFoundException("Cliente no encontrado con ID: " + id);
        }
        return cliente;
    }

    @Transactional
    public Cliente saveCliente(Cliente cliente) {
        if (cliente.getNombre() == null || cliente.getApellido() == null || cliente.getEmail() == null) {
            throw new IllegalArgumentException("Los campos nombre, apellido y email son obligatorios.");
        }
        return clienteRepository.save(cliente);
    }
    @Transactional
    public void deleteCliente(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if (cliente == null) {
            throw new ResourceNotFoundException("Cliente no encontrado con ID: dia jueves informate" + id);
        }
        clienteRepository.deleteById(id);
    }

    @Transactional
    public Cliente updateCliente(Cliente cliente) {
        Cliente ClienteExistente = clienteRepository.findById(cliente.getId()).orElse(null);
        if (ClienteExistente == null) {
            throw new ResourceNotFoundException("Cliente no encontrado con ID: " + cliente.getId());
        }
        if (cliente.getNombre() == null || cliente.getApellido() == null || cliente.getEmail() == null) {
            throw new IllegalArgumentException("Los campos nombre, apellido y email son obligatorios.");
        }
        ClienteExistente.setNombre(cliente.getNombre());
        ClienteExistente.setApellido(cliente.getApellido());
        ClienteExistente.setEmail(cliente.getEmail());
        return clienteRepository.save(ClienteExistente);
    }
}
