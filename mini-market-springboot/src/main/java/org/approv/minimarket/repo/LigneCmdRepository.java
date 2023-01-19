package org.approv.minimarket.repo;

import org.approv.minimarket.model.Article;
import org.approv.minimarket.model.LigneCmd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LigneCmdRepository extends JpaRepository<LigneCmd, Long>{
	@Query("select e from LigneCmd e where  e.numLigne = :id")
	LigneCmd findLigneCmdById(@Param("id") Long id);

}
