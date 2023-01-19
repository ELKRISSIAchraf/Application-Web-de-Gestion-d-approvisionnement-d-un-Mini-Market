package org.approv.minimarket.repo;

import org.approv.minimarket.model.LigneCmd;
import org.approv.minimarket.model.Societe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SocieteRepository extends JpaRepository<Societe,Long>{
	@Query("select e from Societe e where  e.codeSte = :id")
	Societe findSocieteById(@Param("id") Long id);
}
