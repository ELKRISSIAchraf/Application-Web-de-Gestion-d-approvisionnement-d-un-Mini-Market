package org.approv.minimarket.metiers;

import java.util.List;

import org.approv.minimarket.model.Livraison;
import org.approv.minimarket.repo.LivraisonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class LivraisonMetier {
	@Autowired
	private LivraisonRepository livraisonRepository;
	//@Override
	public Livraison  saveLivraison(Livraison c) {
	// TODO Auto-generated method stub
	return livraisonRepository.save(c);
	}
	//@Override
	public List<Livraison> listLivraison() {
	// TODO Auto-generated method stub
	return livraisonRepository.findAll();
	}
	public Livraison findLivraisonById(Long id) {
		// TODO Auto-generated method stub
		return livraisonRepository.findLivraisonById(id);
	}
	public Livraison updateLivraison(Livraison livraison) {
		// TODO Auto-generated method stub
		return livraisonRepository.save(livraison);
	}
	public void deleteLivraison(Long id) {
		// TODO Auto-generated method stub
		livraisonRepository.delete(findLivraisonById(id));
	}
}
