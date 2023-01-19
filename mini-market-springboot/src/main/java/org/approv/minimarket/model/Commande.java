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

import org.approv.minimarket.model.Client;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class Commande implements Serializable{
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(nullable = false, updatable =false)
	private Long numCmd;
	private Date dateCmd; 

	@ManyToOne
	@JoinColumn(name="COD_CLI") 
	private Client client;
	@OneToMany(mappedBy="article",fetch=FetchType.LAZY) 
	private Collection<LigneCmd> ligneCmds;

	public Commande(Date dateCmd) {
		super();
		this.dateCmd = dateCmd;
		
	}
	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getNumCmd() {
		return numCmd;
	}
	public void setNumCmd(Long numCmd) {
		this.numCmd = numCmd;
	}
	public Date getDateCmd() {
		return dateCmd;
	}
	public void setDateCmd(Date dateCmd) {
		this.dateCmd = dateCmd;
	}
	
	public Long getClient() {
		return client.getCodCli();
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	@JsonIgnore
	public Collection<LigneCmd> getLigneCmds() {
		return ligneCmds;
	}
	@JsonSetter
	public void setLigneCmds(Collection<LigneCmd> ligneCmds) {
		this.ligneCmds = ligneCmds;
	}

}
