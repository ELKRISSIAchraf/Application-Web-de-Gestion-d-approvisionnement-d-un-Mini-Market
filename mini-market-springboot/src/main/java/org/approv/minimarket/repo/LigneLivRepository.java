package org.approv.minimarket.repo;

import org.approv.minimarket.model.LigneCmd;
import org.approv.minimarket.model.LigneLiv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LigneLivRepository extends JpaRepository<LigneLiv, Long> {
	@Query("select e from LigneLiv e where  e.codeLigne = :id")
	LigneLiv findLigneLivById(@Param("id") Long id);
}
