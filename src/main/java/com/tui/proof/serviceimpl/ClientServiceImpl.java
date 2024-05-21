package com.tui.proof.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tui.proof.model.Client;
import com.tui.proof.repository.ClientRepository;
import com.tui.proof.service.ClientService;

import java.util.List;


@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository repository;

    public List<Client> findAllByNameContaining(String name) {
        return repository.findAllByNameContaining(name);
    }

    public List<Client> getAll() {
        System.out.println("ClientServiceImpl: getAll");
        return repository.findAll();
    }
    
}
