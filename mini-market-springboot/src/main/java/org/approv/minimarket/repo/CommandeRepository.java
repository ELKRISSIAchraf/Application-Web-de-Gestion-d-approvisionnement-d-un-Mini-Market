package org.approv.minimarket.repo;

import org.approv.minimarket.model.Article;
import org.approv.minimarket.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
	@Query("select e from Commande e where  e.numCmd = :id")
	Commande findCommandeById(@Param("id") Long id);

}
