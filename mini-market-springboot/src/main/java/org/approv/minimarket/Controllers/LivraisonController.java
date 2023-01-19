package org.approv.minimarket.Controllers;

import java.util.List;

import org.approv.minimarket.metiers.LivraisonMetier;
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
@RequestMapping("/livraison")
@CrossOrigin
public class LivraisonController {
	private final LivraisonMetier livraisonMetier;
	public LivraisonController(LivraisonMetier livraisonService) {
		this.livraisonMetier=livraisonService;
	}
	@GetMapping("/all")
	public ResponseEntity<List<Livraison>> getAllLivraison(){
	
		List<Livraison> livraison =livraisonMetier.listLivraison() ;
		return new ResponseEntity<>(livraison,HttpStatus.OK);	
	}

	@PostMapping("/add")
	public ResponseEntity<Livraison> addLivraison(@RequestBody Livraison livraison){  
		Livraison newLivraison=livraisonMetier.saveLivraison(livraison);
		return new ResponseEntity<>(newLivraison,HttpStatus.CREATED);	
	}
	@GetMapping("/find/{id}")
	public ResponseEntity<Livraison> getLivraisonById(@PathVariable("id") Long id){
		Livraison livraison = livraisonMetier.findLivraisonById(id);
	return new ResponseEntity<>(livraison,HttpStatus.OK);	
	}
	
	
	@PutMapping("/update")
	public ResponseEntity <Livraison> updateLivraison(@RequestBody Livraison livraison){  
		Livraison updateLivraison=livraisonMetier.updateLivraison(livraison);
		return new ResponseEntity<>(updateLivraison,HttpStatus.OK);	
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity <?> deleteLivraison(@PathVariable("id") Long id){  
		livraisonMetier.deleteLivraison(id);
	return new ResponseEntity<>(HttpStatus.OK);	
	}
}
