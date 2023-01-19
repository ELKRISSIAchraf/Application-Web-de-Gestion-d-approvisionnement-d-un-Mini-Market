package org.approv.minimarket.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LigneLiv implements Serializable{

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(nullable = false, updatable =false)
	private Long codeLigne;
	public LigneLiv() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getCodeLigne() {
		return codeLigne;
	}
	public void setCodeLigne(Long codeLigne) {
		this.codeLigne = codeLigne;
	}
	public Long getArticle() {
		return article.getCodArt();
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public Long getLivraison() {
		return livraison.getNumLiv();
	}
	public void setLivraison(Livraison livraison) {
		this.livraison = livraison;
	}
	public Long getQteLiv() {
		return qteLiv;
	}
	public void setQteLiv(Long qteLiv) {
		this.qteLiv = qteLiv;
	}
	public LigneLiv(Long codeLigne, Article article, Livraison livraison, Long qteLiv) {
		super();
		this.codeLigne = codeLigne;
		this.article = article;
		this.livraison = livraison;
		this.qteLiv = qteLiv;
	}
	@ManyToOne
	@JoinColumn(name="cod_Art") 
	private Article article;
	@ManyToOne
	@JoinColumn(name="num_Liv") 
	private Livraison livraison;
	private Long qteLiv;
}
