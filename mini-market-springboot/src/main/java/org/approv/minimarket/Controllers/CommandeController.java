package org.approv.minimarket.Controllers;

import java.util.List;

import org.approv.minimarket.metiers.CommandeMetier;
import org.approv.minimarket.metiers.SocieteMetier;
import org.approv.minimarket.model.Client;
import org.approv.minimarket.model.Commande;
import org.approv.minimarket.model.Societe;
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
@RequestMapping("/commande")
@CrossOrigin
public class CommandeController {
	private final CommandeMetier commandeMetier;
	public CommandeController(CommandeMetier commandeService) {
		this.commandeMetier=commandeService;
	}
	@GetMapping("/all")
	public ResponseEntity<List<Commande>> getAllCommande(){
	
		List<Commande> commande =commandeMetier.listCommande() ;
		return new ResponseEntity<>(commande,HttpStatus.OK);	
	}
	@PostMapping("/add")
	public ResponseEntity<Commande> addCommande(@RequestBody Commande commande){  
		Commande newCommande=commandeMetier.saveCommande(commande);
		return new ResponseEntity<>(newCommande,HttpStatus.CREATED);	
	}
	@GetMapping("/find/{id}")
	public ResponseEntity<Commande> getCommandeById(@PathVariable("id") Long id){
		Commande commande = commandeMetier.findCommandeById(id);
	return new ResponseEntity<>(commande,HttpStatus.OK);	
	}
	@PutMapping("/update")
	public ResponseEntity <Commande> updateClient(@RequestBody Commande commande){  
		Commande updateCommande=commandeMetier.updateCommande(commande);
		return new ResponseEntity<>(updateCommande,HttpStatus.OK);	
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity <?> deleteClient(@PathVariable("id") Long id){  
		commandeMetier.deleteCommande(id);
	return new ResponseEntity<>(HttpStatus.OK);	
	}
}
