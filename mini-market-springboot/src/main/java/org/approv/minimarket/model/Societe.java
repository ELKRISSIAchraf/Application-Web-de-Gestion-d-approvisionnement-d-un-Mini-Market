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
public class Societe implements Serializable{
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(nullable = false, updatable =false)
	private Long codeSte;
	public Societe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Societe( String nomSte, String telSte, String faxSte, String villeSte) {
		super();
	
		this.nomSte = nomSte;
		this.telSte = telSte;
		this.faxSte = faxSte;
		this.villeSte = villeSte;
	
	}
	public Long getCodeSte() {
		return codeSte;
	}
	public void setCodeSte(Long codeSte) {
		this.codeSte = codeSte;
	}
	public String getNomSte() {
		return nomSte;
	}
	public void setNomSte(String nomSte) {
		this.nomSte = nomSte;
	}
	public String getTelSte() {
		return telSte;
	}
	public void setTelSte(String telSte) {
		this.telSte = telSte;
	}
	public String getFaxSte() {
		return faxSte;
	}
	public void setFaxSte(String faxSte) {
		this.faxSte = faxSte;
	}
	public String getVilleSte() {
		return villeSte;
	}
	public void setVilleSte(String villeSte) {
		this.villeSte = villeSte;
	}
	public Long getFournisseur() {
		return fournisseur.getCodeFour();
	}
	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
	private String nomSte;
	private String telSte;
	private String faxSte;
	private String villeSte;
	@ManyToOne
	@JoinColumn(name="code_Four") 
	private Fournisseur fournisseur;
}
