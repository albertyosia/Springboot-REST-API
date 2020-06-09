package com.spring.restapi.module.client;

public interface ClientService {
  Client getGeneratedClient(Client client);

  void deleteClient(Long id);
}
