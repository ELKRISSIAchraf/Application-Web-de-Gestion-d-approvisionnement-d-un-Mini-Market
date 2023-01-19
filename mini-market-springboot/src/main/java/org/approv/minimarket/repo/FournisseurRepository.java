package org.approv.minimarket.repo;

import org.approv.minimarket.model.Article;
import org.approv.minimarket.model.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Long>{
	@Query("select e from Fournisseur e where  e.codeFour = :id")
	Fournisseur findFournisseurById(@Param("id") Long id);

}
