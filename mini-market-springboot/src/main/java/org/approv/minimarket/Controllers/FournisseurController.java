package org.approv.minimarket.Controllers;

import java.util.List;

import org.approv.minimarket.metiers.ClientMetier;
import org.approv.minimarket.metiers.FournisseurMetier;
import org.approv.minimarket.model.Client;
import org.approv.minimarket.model.Commande;
import org.approv.minimarket.model.Fournisseur;
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
@RequestMapping("/fournisseur")
@CrossOrigin
public class FournisseurController {
	private final FournisseurMetier fournisseurMetier;
	public FournisseurController(FournisseurMetier fournisseurService) {
		this.fournisseurMetier=fournisseurService;
	}
	@GetMapping("/all")
	public ResponseEntity<List<Fournisseur>> getAllFournisseur(){
	
		List<Fournisseur> fournisseur =fournisseurMetier.listFournisseur() ;
		
		
		return new ResponseEntity<>(fournisseur,HttpStatus.OK);	
	}

	@PostMapping("/add")
	public ResponseEntity<Fournisseur> addFournisseur(@RequestBody Fournisseur fournisseur){  
		Fournisseur newFournisseur=fournisseurMetier.saveFournisseur(fournisseur);
		return new ResponseEntity<>(newFournisseur,HttpStatus.CREATED);	
	}
	@GetMapping("/find/{id}")
	public ResponseEntity<Fournisseur> getFournisseurById(@PathVariable("id") Long id){
		Fournisseur fournisseur = fournisseurMetier.findFournisseurById(id);
	return new ResponseEntity<>(fournisseur,HttpStatus.OK);	
	}
	
	@PutMapping("/update")
	public ResponseEntity <Fournisseur> updateFournisseur(@RequestBody Fournisseur fournisseur){  
		Fournisseur updateFournisseur=fournisseurMetier.updateFournisseur(fournisseur);
		return new ResponseEntity<>(updateFournisseur,HttpStatus.OK);	
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity <?> deleteFournisseur(@PathVariable("id") Long id){  
		fournisseurMetier.deleteFournisseur(id);
	return new ResponseEntity<>(HttpStatus.OK);	
	}
}
