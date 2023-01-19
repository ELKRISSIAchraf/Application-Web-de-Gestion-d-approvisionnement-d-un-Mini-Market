package org.approv.minimarket.metiers;

import java.util.List;

import org.approv.minimarket.model.Commande;
import org.approv.minimarket.repo.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CommandeMetier {
	@Autowired
	private CommandeRepository commandeRepository;
	//@Override
	public Commande saveCommande(Commande c) {
	// TODO Auto-generated method stub
	return commandeRepository.save(c);
	}
	//@Override
	public List<Commande> listCommande() {
	// TODO Auto-generated method stub
	return commandeRepository.findAll();
	}
	public Commande findCommandeById(Long id) {
		// TODO Auto-generated method stub
		return commandeRepository.findCommandeById(id);
	}
	public Commande updateCommande(Commande commande) {
		// TODO Auto-generated method stub
		return commandeRepository.save(commande);
	}
	public void deleteCommande(Long id) {
		// TODO Auto-generated method stub
		commandeRepository.delete(findCommandeById(id));
	}
	
}
