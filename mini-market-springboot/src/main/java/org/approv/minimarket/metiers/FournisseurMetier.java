package org.approv.minimarket.metiers;

import java.util.List;

import org.approv.minimarket.model.Commande;
import org.approv.minimarket.model.Fournisseur;
import org.approv.minimarket.repo.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class FournisseurMetier {
	@Autowired
	private FournisseurRepository fournisseurRepository;
	//@Override
	public Fournisseur  saveFournisseur(Fournisseur c) {
	// TODO Auto-generated method stub
	return fournisseurRepository.save(c);
	}
	//@Override
	public List<Fournisseur> listFournisseur() {
	// TODO Auto-generated method stub
	return fournisseurRepository.findAll();
	}
	public Fournisseur findFournisseurById(Long id) {
		// TODO Auto-generated method stub
		return fournisseurRepository.findFournisseurById(id);
	}
	public void deleteFournisseur(Long id) {
		// TODO Auto-generated method stub
		fournisseurRepository.delete(findFournisseurById(id));
	}
	public Fournisseur updateFournisseur(Fournisseur fournisseur) {
		// TODO Auto-generated method stub
		return fournisseurRepository.save(fournisseur);
	}
}
