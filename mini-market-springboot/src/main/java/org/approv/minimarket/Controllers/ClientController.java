package org.approv.minimarket.Controllers;

import java.util.List;

import org.approv.minimarket.metiers.ClientMetier;
import org.approv.minimarket.model.Article;
import org.approv.minimarket.model.Client;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
@CrossOrigin
public class ClientController {
		private final ClientMetier clientMetier;
		public ClientController(ClientMetier clientService) {
			this.clientMetier=clientService;
		}
		@GetMapping("/all")
		public ResponseEntity<List<Client>> getAllClient(){
		
			List<Client> client =clientMetier.listClient() ;
			
			
			return new ResponseEntity<>(client,HttpStatus.OK);	
		}
		@PostMapping("/add")
		public ResponseEntity<Client> addClient(@RequestBody Client client){  
			Client newClient=clientMetier.saveClient(client);
			return new ResponseEntity<>(newClient,HttpStatus.CREATED);	
		}
		
		@GetMapping("/find/{id}")
		public ResponseEntity<Client> getClientById(@PathVariable("id") Long id){
			Client client = clientMetier.findClientById(id);
		return new ResponseEntity<>(client,HttpStatus.OK);	
		}
		@PutMapping("/update")
		public ResponseEntity <Client> updateClient(@RequestBody Client client){  
			Client updateClient=clientMetier.updateClient(client);
			return new ResponseEntity<>(updateClient,HttpStatus.OK);	
		}
		@DeleteMapping("/delete/{id}")
		public ResponseEntity <?> deleteClient(@PathVariable("id") Long id){  
			clientMetier.deleteClient(id);
		return new ResponseEntity<>(HttpStatus.OK);	
		}
}
