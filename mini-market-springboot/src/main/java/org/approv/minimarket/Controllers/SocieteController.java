package org.approv.minimarket.Controllers;

import java.util.List;

import org.approv.minimarket.metiers.FournisseurMetier;
import org.approv.minimarket.metiers.SocieteMetier;
import org.approv.minimarket.model.Fournisseur;
import org.approv.minimarket.model.Livraison;
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
@RequestMapping("/societe")
@CrossOrigin
public class SocieteController {
	private final SocieteMetier societeMetier;
	public SocieteController(SocieteMetier societeService) {
		this.societeMetier=societeService;
	}
	@GetMapping("/all")
	public ResponseEntity<List<Societe>> getAllSociete(){
	
		List<Societe> societe =societeMetier.listSociete() ;
		return new ResponseEntity<>(societe,HttpStatus.OK);	
	}

	@PostMapping("/add")
	public ResponseEntity<Societe> addSociete(@RequestBody Societe societe){  
		Societe newSociete=societeMetier.saveSociete(societe);
		return new ResponseEntity<>(newSociete,HttpStatus.CREATED);	
	}
	@GetMapping("/find/{id}")
	public ResponseEntity<Societe> getSocieteById(@PathVariable("id") Long id){
		Societe societe = societeMetier.findSocieteById(id);
	return new ResponseEntity<>(societe,HttpStatus.OK);	
	}
	@GetMapping("/find")
	public ResponseEntity<String> getSocieteById(){
		//Societe societe = societeMetier.findSocieteById(id);
	return new ResponseEntity<>("azertyu",HttpStatus.OK);	
	}
	@PutMapping("/update")
	public ResponseEntity <Societe> updateSociete(@RequestBody Societe societe){  
		Societe updateSociete=societeMetier.updateSociete(societe);
		return new ResponseEntity<>(updateSociete,HttpStatus.OK);	
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity <?> deleteSociete(@PathVariable("id") Long id){  
		societeMetier.deleteSociete(id);
	return new ResponseEntity<>(HttpStatus.OK);	
	}
}
