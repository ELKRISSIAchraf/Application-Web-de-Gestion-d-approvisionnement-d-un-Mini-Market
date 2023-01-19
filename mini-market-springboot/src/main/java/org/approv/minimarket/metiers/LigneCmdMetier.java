package org.approv.minimarket.metiers;

import java.util.List;

import org.approv.minimarket.model.LigneCmd;
import org.approv.minimarket.repo.LigneCmdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class LigneCmdMetier {
	@Autowired
	private LigneCmdRepository ligneCmdRepository;
	//@Override
	public LigneCmd  saveLigneCmd(LigneCmd c) {
	// TODO Auto-generated method stub
	return ligneCmdRepository.save(c);
	}
	//@Override
	public List<LigneCmd> listLigneCmd() {
	// TODO Auto-generated method stub
	return ligneCmdRepository.findAll();
	}
	public LigneCmd findLigneCmdById(Long id) {
		// TODO Auto-generated method stub
		return ligneCmdRepository.findLigneCmdById(id);
	}
	public LigneCmd updateLigneCmd(LigneCmd ligneCmd) {
		// TODO Auto-generated method stub
		return ligneCmdRepository.save(ligneCmd);
	}
	public void deleteLigneCmd(Long id) {
		// TODO Auto-generated method stub
		ligneCmdRepository.delete(findLigneCmdById(id));
	}
}
