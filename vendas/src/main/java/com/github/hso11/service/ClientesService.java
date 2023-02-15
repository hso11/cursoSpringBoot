package com.github.hso11.service;

import com.github.hso11.model.Cliente;
import com.github.hso11.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientesService {

    private ClientesRepository repository;

    @Autowired
    public ClientesService(ClientesRepository repository){
        this.repository = repository;
    }

    public void Salvar(Cliente cliente){
        validarCliente(cliente);
        repository.salvar(cliente);
    }
    private void validarCliente(Cliente cliente) {
        //...
    }

}
