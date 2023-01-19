package org.approv.minimarket.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class LigneCmd implements Serializable{
	public Long getNumLigne() {
		return numLigne;
	}
	public void setNumLigne(Long numLigne) {
		this.numLigne = numLigne;
	}
	public Long getArticle() {
		return article.getCodArt();
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	//@JsonIgnore
	public Long getCommande() {
		return commande.getNumCmd();
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	public Long getQteCmd() {
		return qteCmd;
	}
	public void setQteCmd(Long qteCmd) {
		this.qteCmd = qteCmd;
	}
	public LigneCmd() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LigneCmd(Long numLigne, Article article, Commande commande, Long qteCmd) {
		super();
		this.numLigne = numLigne;
		this.article = article;
		this.commande = commande;
		this.qteCmd = qteCmd;
	}
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(nullable = false, updatable =false)
	private Long numLigne;
	@ManyToOne
	@JoinColumn(name="cod_Art") 
	private Article article;
	@ManyToOne
	@JoinColumn(name="num_Cmd") 
	private Commande commande;
	private Long qteCmd;

	
	

}
