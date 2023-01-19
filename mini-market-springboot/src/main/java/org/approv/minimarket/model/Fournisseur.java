package org.approv.minimarket.model;

import java.io.Serializable;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Fournisseur implements Serializable{
	@Override
	public String toString() {
		return "Fournisseur [codeFour=" + codeFour + ", nomFour=" + nomFour + ", villeFour=" + villeFour + ", telFour="
				+ telFour + ", societes=" + societes + ", livraisons=" + livraisons + "]";
	}
	public Long getCodeFour() {
		return codeFour;
	}
	public void setCodeFour(Long codeFour) {
		this.codeFour = codeFour;
	}
	public String getNomFour() {
		return nomFour;
	}
	public void setNomFour(String nomFour) {
		this.nomFour = nomFour;
	}
	public String getVilleFour() {
		return villeFour;
	}
	public void setVilleFour(String villeFour) {
		this.villeFour = villeFour;
	}
	public String getTelFour() {
		return telFour;
	}
	public void setTelFour(String telFour) {
		this.telFour = telFour;
	}
	public Collection<Societe> getSocietes() {
		return societes;
	}
	
	public Collection<Livraison> getLivraisons() {
		return livraisons;
	}

	public Fournisseur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Fournisseur(Long codeFour, String nomFour, String villeFour, String telFour, Collection<Societe> societes,
			Collection<Livraison> livraisons) {
		super();
		this.codeFour = codeFour;
		this.nomFour = nomFour;
		this.villeFour = villeFour;
		this.telFour = telFour;
		
	}
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(nullable = false, updatable =false)
	private Long codeFour;
	private String nomFour;
	private String villeFour;
	private String telFour;
	@OneToMany(mappedBy="fournisseur",fetch=FetchType.LAZY) 
	private Collection<Societe> societes;
	@OneToMany(mappedBy="fournisseur",fetch=FetchType.LAZY) 
	private Collection<Livraison> livraisons;

}
