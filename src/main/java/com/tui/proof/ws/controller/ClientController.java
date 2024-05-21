package com.tui.proof.ws.controller;

import org.springframework.web.bind.annotation.RestController;

import com.tui.proof.model.Client;
import com.tui.proof.service.ClientService;

import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;


@Log4j2
@RestController
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping("/client")
    public List<Client> getMethodName(@RequestParam String name) {
        
        log.info("ClientController: getMethodName");
        return service.findAllByNameContaining(name);

    }
}
