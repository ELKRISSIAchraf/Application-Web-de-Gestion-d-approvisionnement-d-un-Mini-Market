package org.approv.minimarket.repo;


import org.approv.minimarket.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClientRepository extends JpaRepository<Client, Long>{
	@Query("select e from Client e where  e.codCli = :id")
	Client findClientById(@Param("id") Long id);

}
