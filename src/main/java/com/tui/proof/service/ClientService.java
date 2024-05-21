package com.tui.proof.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.tui.proof.model.Client;

@Component
public interface ClientService {

    // public Role save(RoleDTO roleDTO) throws ResponseStatusException;

    public List<Client> findAllByNameContaining(String name);

    public List<Client> getAll();

}
