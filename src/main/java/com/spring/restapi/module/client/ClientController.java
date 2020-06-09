package com.spring.restapi.module.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientController {

  @Autowired private ClientService clientService;

  @PostMapping("/")
  public Client getGeneratedClient(@RequestBody Client client) {
    return clientService.getGeneratedClient(client);
  }

  @DeleteMapping("/{id}")
  public void deleteClient(@PathVariable("id") Long id) {
    clientService.deleteClient(id);
  }
}
