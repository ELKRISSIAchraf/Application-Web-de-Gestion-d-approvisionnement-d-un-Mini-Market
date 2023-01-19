package org.approv.minimarket.metiers;

import java.util.List;

import org.approv.minimarket.model.Client;
import org.approv.minimarket.repo.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ClientMetier {
	@Autowired
	private ClientRepository clientRepository;
	//@Override
	public Client saveClient(Client c) {
	// TODO Auto-generated method stub
	return clientRepository.save(c);
	}
	//@Override
	public List<Client> listClient() {
	// TODO Auto-generated method stub
	return clientRepository.findAll();
	}
	public Client findClientById(Long id) {
		
		return clientRepository.findClientById(id);
	}
	public Client updateClient(Client client) {
		// TODO Auto-generated method stub
		return clientRepository.save(client);
	}
	public void deleteClient(Long id) {
		// TODO Auto-generated method stub
		clientRepository.delete(findClientById(id));
	}
}
