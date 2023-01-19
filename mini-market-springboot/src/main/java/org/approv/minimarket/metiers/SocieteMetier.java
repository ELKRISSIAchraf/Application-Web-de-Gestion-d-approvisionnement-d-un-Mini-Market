package org.approv.minimarket.metiers;

import java.util.List;

import org.approv.minimarket.model.Societe;
import org.approv.minimarket.repo.SocieteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SocieteMetier {
	@Autowired
	private SocieteRepository societeRepository;
	//@Override
	public Societe saveSociete(Societe c) {
	// TODO Auto-generated method stub
	return societeRepository.save(c);
	}
	//@Override
	public List<Societe> listSociete() {
	// TODO Auto-generated method stub
	return societeRepository.findAll();
	}
	public  Societe findSocieteById(Long id) {
		// TODO Auto-generated method stub
		return societeRepository.findSocieteById(id);
	}
	public Societe updateSociete(Societe societe) {
		// TODO Auto-generated method stub
		return societeRepository.save(societe);
	}
	public void deleteSociete(Long id) {
		// TODO Auto-generated method stub
		societeRepository.delete(findSocieteById(id));
	}
}
