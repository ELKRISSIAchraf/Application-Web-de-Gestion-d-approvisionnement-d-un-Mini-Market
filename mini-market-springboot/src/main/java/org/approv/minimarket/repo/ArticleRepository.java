package org.approv.minimarket.repo;

import org.approv.minimarket.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ArticleRepository extends JpaRepository<Article, Long>{
	@Query("select e from Article e where  e.codArt = :id")
	Article findArticleById(@Param("id") Long id);

}
