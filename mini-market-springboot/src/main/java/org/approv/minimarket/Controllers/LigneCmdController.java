package org.approv.minimarket.Controllers;

import java.util.List;

import org.approv.minimarket.metiers.LigneCmdMetier;
import org.approv.minimarket.metiers.LivraisonMetier;
import org.approv.minimarket.model.Fournisseur;
import org.approv.minimarket.model.LigneCmd;
import org.approv.minimarket.model.Livraison;
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
@RequestMapping("/lignecmd")
@CrossOrigin
public class LigneCmdController {
	private final LigneCmdMetier LignecmdMetier;
	public LigneCmdController(LigneCmdMetier LignecmdService) {
		this.LignecmdMetier=LignecmdService;
	}
	@GetMapping("/all")
	public ResponseEntity<List<LigneCmd>> getAllLigneCmd(){
	
		List<LigneCmd> Lignecmd =LignecmdMetier.listLigneCmd() ;
		return new ResponseEntity<>(Lignecmd,HttpStatus.OK);	
	}

	@PostMapping("/add")
	public ResponseEntity<LigneCmd> addLigneCmd(@RequestBody LigneCmd Lignecmd){  
		LigneCmd newLigneCmd=LignecmdMetier.saveLigneCmd(Lignecmd);
		return new ResponseEntity<>(newLigneCmd,HttpStatus.CREATED);	
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<LigneCmd> getLigneCmdById(@PathVariable("id") Long id){
		LigneCmd ligneCmd = LignecmdMetier.findLigneCmdById(id);
	return new ResponseEntity<>(ligneCmd,HttpStatus.OK);	
	}
	
	@PutMapping("/update")
	public ResponseEntity <LigneCmd> updateLigneCmd(@RequestBody LigneCmd ligneCmd){  
		LigneCmd updateLignecmd=LignecmdMetier.updateLigneCmd(ligneCmd);
		return new ResponseEntity<>(updateLignecmd,HttpStatus.OK);	
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity <?> deleteLigneCmd(@PathVariable("id") Long id){  
		LignecmdMetier.deleteLigneCmd(id);
	return new ResponseEntity<>(HttpStatus.OK);	
	}
}
