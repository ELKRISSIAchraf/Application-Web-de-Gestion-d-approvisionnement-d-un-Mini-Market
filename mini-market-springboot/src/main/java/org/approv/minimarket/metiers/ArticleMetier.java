package org.approv.minimarket.metiers;

import java.util.List;
import java.util.Optional;

import org.approv.minimarket.model.Article;
import org.approv.minimarket.repo.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ArticleMetier {
	@Autowired
	private ArticleRepository articleRepository;
	
	public Article saveArticle(Article c) {
	// TODO Auto-generated method stub
	return articleRepository.save(c);
	}
	
	public List<Article> listArticle() {
	// TODO Auto-generated method stub
	return articleRepository.findAll();
	}
	
	public Article findArticleById( Long id ) {
		return articleRepository.findArticleById(id);
	}
	public void deleteArticle(Long id) {
		 articleRepository.delete(findArticleById(id));
	}
	public Article updateArticle(Article article) {
		
		return articleRepository.save(article);
	}
	

}
