package org.approv.minimarket.repo;

import org.approv.minimarket.model.LigneCmd;
import org.approv.minimarket.model.Livraison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LivraisonRepository  extends JpaRepository<Livraison, Long>{
	@Query("select e from Livraison e where  e.numLiv = :id")
	Livraison findLivraisonById(@Param("id") Long id);
}
