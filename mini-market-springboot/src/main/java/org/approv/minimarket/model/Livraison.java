package org.approv.minimarket.model;

import java.io.Serializable;


import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;


@Entity
public class Livraison implements Serializable{
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(nullable = false, updatable =false)
	private Long numLiv;
	private Date dateLiv;
	@ManyToOne
	@JoinColumn(name="CODE_FOUR") 
	private Fournisseur fournisseur;
	public Livraison() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Livraison( Date dateLiv) {
		super();

		this.dateLiv = dateLiv;

	}
	public Long getNumLiv() {
		return numLiv;
	}
	public void setNumLiv(Long numLiv) {
		this.numLiv = numLiv;
	}
	public Date getDateLiv() {
		return dateLiv;
	}
	public void setDateLiv(Date dateLiv) {
		this.dateLiv = dateLiv;
	}
	
	public Long getFournisseur() {
		return fournisseur.getCodeFour();
	}
	
	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
	
	@JsonIgnore
	public Collection<LigneLiv> getLigneLivs() {
		return ligneLivs;
	}
	@JsonSetter
	public void setLigneLivs(Collection<LigneLiv> ligneLivs) {
		this.ligneLivs = ligneLivs;
	}

	@OneToMany(mappedBy="livraison",fetch=FetchType.LAZY) 
	private Collection<LigneLiv> ligneLivs;
}
