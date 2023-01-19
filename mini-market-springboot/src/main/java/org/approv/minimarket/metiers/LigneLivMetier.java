package org.approv.minimarket.metiers;

import java.util.List;

import org.approv.minimarket.model.Fournisseur;
import org.approv.minimarket.model.LigneLiv;
import org.approv.minimarket.repo.LigneLivRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class LigneLivMetier {
	@Autowired
	private LigneLivRepository LignelivRepository;
	//@Override
	public LigneLiv  saveLigneLiv(LigneLiv c) {
	// TODO Auto-generated method stub
	return LignelivRepository.save(c);
	}
	//@Override
	public List<LigneLiv> listLigneLiv() {
	// TODO Auto-generated method stub
	return LignelivRepository.findAll();
	}
	public LigneLiv findLigneLivById(Long id) {
		// TODO Auto-generated method stub
		return LignelivRepository.findLigneLivById(id);
	}
	public LigneLiv updateLigneLiv(LigneLiv ligneLiv) {
		// TODO Auto-generated method stub
		return LignelivRepository.save(ligneLiv);
	}
	public void deleteLigneLiv(Long id) {
		// TODO Auto-generated method stub
		LignelivRepository.delete(findLigneLivById(id));
	}
}
