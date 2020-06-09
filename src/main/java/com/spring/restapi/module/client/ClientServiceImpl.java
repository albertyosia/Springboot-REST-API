package com.spring.restapi.module.client;

import com.spring.restapi.exceptions.DepartmentNotFoundException;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service("clientService")
public class ClientServiceImpl implements ClientService {
  private ClientRepository clientRepository;

  public ClientServiceImpl(ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }

  @Override
  public Client getGeneratedClient(Client newClient) {
    return clientRepository.saveAndFlush(newClient);
  }

  @Override
  public void deleteClient(Long id) {
    Optional<Client> foundClient = clientRepository.findByClientId(id);
    if (foundClient.isEmpty()) {
      throw new DepartmentNotFoundException("Client with id " + id + " not found");
    }
    clientRepository.delete(foundClient.get());
  }
}
