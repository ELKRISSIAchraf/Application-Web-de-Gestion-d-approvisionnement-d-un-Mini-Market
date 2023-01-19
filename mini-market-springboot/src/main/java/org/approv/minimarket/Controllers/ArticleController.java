package org.approv.minimarket.Controllers;

import java.util.List;

import org.approv.minimarket.metiers.ArticleMetier;

import org.approv.minimarket.model.Article;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/article")
@CrossOrigin
public class ArticleController {
	private final ArticleMetier articleMetier;
	
	public ArticleController(ArticleMetier articleMetier) {
		this.articleMetier=articleMetier;
	}
	@GetMapping("/all")
	public ResponseEntity<List<Article>> getAllClient(){
	
		List<Article> article =articleMetier.listArticle() ;
		
		
		return new ResponseEntity<>(article,HttpStatus.OK);	
	}
	@PostMapping("/add")
	public ResponseEntity<Article> addClient(@RequestBody Article article){  
		Article newArticle=articleMetier.saveArticle(article);
		return new ResponseEntity<>(newArticle,HttpStatus.CREATED);	
	}
	@GetMapping("/find/{id}")
	public ResponseEntity<Article> getArticleById(@PathVariable("id") Long id){
		Article article = articleMetier.findArticleById(id );
	return new ResponseEntity<>(article,HttpStatus.OK);	
	}
	@PutMapping("/update")
	public ResponseEntity <Article> updateArticle(@RequestBody Article article){  
		Article updateArticle=articleMetier.updateArticle(article);
		return new ResponseEntity<>(updateArticle,HttpStatus.OK);	
		//return new ResponseEntity<>("coco",HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity <?> deleteArticle(@PathVariable("id") Long id){  
		articleMetier.deleteArticle(id);
	return new ResponseEntity<>(HttpStatus.OK);	
	}
}
