package org.approv.minimarket.Controllers;

import java.util.List;

import org.approv.minimarket.metiers.LigneCmdMetier;
import org.approv.minimarket.metiers.LigneLivMetier;
import org.approv.minimarket.model.LigneCmd;
import org.approv.minimarket.model.LigneLiv;
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
@RequestMapping("/ligneliv")
@CrossOrigin
public class LigneLivController {
	private final LigneLivMetier LignelivMetier;
	public LigneLivController(LigneLivMetier LignelivService) {
		this.LignelivMetier=LignelivService;
	}
	@GetMapping("/all")
	public ResponseEntity<List<LigneLiv>> getAllLigneLiv(){
	
		List<LigneLiv> Ligneliv=LignelivMetier.listLigneLiv();
		return new ResponseEntity<>(Ligneliv,HttpStatus.OK);	
	}

	@PostMapping("/add")
	public ResponseEntity<LigneLiv> addLigneCmd(@RequestBody LigneLiv Ligneliv){  
		LigneLiv newLigneliv=LignelivMetier.saveLigneLiv(Ligneliv);
		return new ResponseEntity<>(newLigneliv,HttpStatus.CREATED);	
	}
	@GetMapping("/find/{id}") 
	public ResponseEntity<LigneLiv> getLigneLivById(@PathVariable("id") Long id){
		LigneLiv ligneLiv = LignelivMetier.findLigneLivById(id);
	return new ResponseEntity<>(ligneLiv,HttpStatus.OK);	
	}
	
	@PutMapping("/update")
	public ResponseEntity <LigneLiv> updateLigneLiv(@RequestBody LigneLiv ligneLiv){  
		LigneLiv updateLigneliv=LignelivMetier.updateLigneLiv(ligneLiv);
		return new ResponseEntity<>(updateLigneliv,HttpStatus.OK);	
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity <?> deleteLigneCmd(@PathVariable("id") Long id){  
		LignelivMetier.deleteLigneLiv(id);
	return new ResponseEntity<>(HttpStatus.OK);	
	}
}
