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
public class Client implements Serializable{
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(nullable = false, updatable =false)
	private Long codCli;
	
	private String nomCli;
	private String preCli;
	private String adrCli;

	private String telCli;
	private String villeCli;
	
	@OneToMany(mappedBy="client",fetch=FetchType.LAZY) 
	private Collection<Commande> commandes;
	public Long getCodCli() {
		return codCli;
	}

	public void setCodCli(Long codCli) {
		this.codCli = codCli;
	}

	public String getNomCli() {
		return nomCli;
	}

	public void setNomCli(String nomCli) {
		this.nomCli = nomCli;
	}

	public String getPreCli() {
		return preCli;
	}

	public void setPreCli(String preCli) {
		this.preCli = preCli;
	}

	public String getAdrCli() {
		return adrCli;
	}

	public void setAdrCli(String adrCli) {
		this.adrCli = adrCli;
	}

	public String getTelCli() {
		return telCli;
	}

	public void setTelCli(String telCli) {
		this.telCli = telCli;
	}

	public String getVilleCli() {
		return villeCli;
	}

	public void setVilleCli(String villeCli) {
		this.villeCli = villeCli;
	}

	public Collection<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(Collection<Commande> commandes) {
		this.commandes = commandes;
	}

	public Client(Long codCli, String nomCli, String preCli, String adrCli, String telCli, String villeCli
			) {
		super();
		this.codCli = codCli;
		this.nomCli = nomCli;
		this.preCli = preCli;
		this.adrCli = adrCli;
		this.telCli = telCli;
	
	}

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	} 
	@Override
	public String toString() {
		return "Client [codCli=" + codCli + ", nomCli=" + nomCli + ", preCli=" + preCli + ", adrCli=" + adrCli
				+ ", telCli=" + telCli + ", villeCli=" + villeCli + ", commandes=" + commandes + "]";
	}
	

}
