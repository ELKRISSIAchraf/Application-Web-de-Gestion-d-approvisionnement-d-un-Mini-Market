package org.approv.minimarket.model;

import java.io.Serializable;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Article  implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codArt;
	private String nomArt;
	private float pu;
	private int qteStock;
	
	
	@OneToMany(mappedBy="article",fetch=FetchType.LAZY) 
	private Collection<LigneCmd> ligneCmds;
	@OneToMany(mappedBy="article",fetch=FetchType.LAZY) 
	private Collection<LigneLiv> ligneLivs;
	public Collection<LigneCmd> getLigneCmds() {
		return ligneCmds;
	}
	public void setLigneCmds(Collection<LigneCmd> ligneCmds) {
		this.ligneCmds = ligneCmds;
	}
	public Long getCodArt() {
		return codArt;
	}
	@Override
	public String toString() {
		return "Article [codArt=" + codArt + ", nomArt=" + nomArt + ", pu=" + pu + ", qteStock=" + qteStock + "]";
	}
	public void setCodArt(Long codArt) {
		this.codArt = codArt;
	}
	public String getNomArt() {
		return nomArt;
	}
	public void setNomArt(String nomArt) {
		this.nomArt = nomArt;
	}
	public float getPu() {
		return pu;
	}
	public void setPu(float pu) {
		this.pu = pu;
	}
	public int getQteStock() {
		return qteStock;
	}
	public void setQteStock(int qteStock) {
		this.qteStock = qteStock;
	}
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Collection<LigneLiv> getLigneLivs() {
		return ligneLivs;
	}
	public void setLigneLivs(Collection<LigneLiv> ligneLivs) {
		this.ligneLivs = ligneLivs;
	}
	public Article( String nomArt, float pu, int qteStock) {
		super();
	//	this.codArt = codArt;
		this.nomArt = nomArt;
		this.pu = pu;
		this.qteStock = qteStock;
	}
}
