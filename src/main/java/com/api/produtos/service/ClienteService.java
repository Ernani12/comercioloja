package com.api.produtos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.produtos.model.Cliente;
import com.api.produtos.repository.ClienteRepository;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> getClienteById(String id) {
        return clienteRepository.findById(id);
    }

    public Cliente criarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente atualizarCliente(String id, Cliente cliente) {
        if (!clienteRepository.existsById(id)) {
            throw new RuntimeException("Cliente não encontrado");
        }
        cliente.setId(id);
        return clienteRepository.save(cliente);
    }

    public void deletarCliente(String id) {
        clienteRepository.deleteById(id);
    }


    public Cliente registerUser(String email, String password, String nome) {
        if (clienteRepository.findByEmail(email) != null) {
            throw new RuntimeException("E-mail já registrado");
        }
        Cliente user = new Cliente();
        user.setNome(nome);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        return clienteRepository.save(user);
    }

    public Cliente loginUser(String email, String password) {
        Cliente user = clienteRepository.findByEmail(email);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user;
        } else {
            throw new RuntimeException("Credenciais inválidas");
        }
    }
}
