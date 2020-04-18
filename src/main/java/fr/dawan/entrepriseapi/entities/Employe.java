package fr.dawan.entrepriseapi.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import fr.dawan.entrepriseapi.entities.enums.Poste;

@Entity
@Table
@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "ptype")
@JsonSubTypes({
	@JsonSubTypes.Type(value = Vendeur.class, name = "VENDEUR"),
	@JsonSubTypes.Type(value = Producteur.class, name = "PRODUCTEUR"),
	@JsonSubTypes.Type(value = ProducteurARisque.class, name = "PRODARISQUE"),
	@JsonSubTypes.Type(value = Manutentionnaire.class, name = "MANUTENTIONNAIRE"),
	@JsonSubTypes.Type(value = ManutARisque.class, name = "MANUTARISQUE"),
	@JsonSubTypes.Type(value = Representant.class, name = "REPRESENTANT"),
})

public abstract class Employe extends Login {
	@Column
	protected String nom;
	@Column
	protected String prenom;
	@Column
	protected int age;
	@Column
	protected LocalDate dateEntree;	
	@Column
	protected Double baseCalcul;
	
	@Enumerated(EnumType.STRING)
	protected Poste p;
	
	
	public Employe() {
		
	}
	
	public Employe(String nom, String prenom, int age, LocalDate dateEntree, double baseCalcul) {
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.dateEntree = dateEntree;
		this.baseCalcul = baseCalcul;
		this.p = Poste.EMPLOYE;
	}

	public abstract double calculerSalaire();
	
	public String getPoste() {
		return "L'employe";
	}
	
	public String getFullNom() {
		return this.getPoste() + this.prenom + " " + this.nom;
	}

	
	public Double getBaseCalcul() {
		return baseCalcul;
	}

	public void setBaseCalcul(Double baseCalcul) {
		this.baseCalcul = baseCalcul;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public LocalDate getDateEntree() {
		return dateEntree;
	}

	public void setDateEntree(LocalDate dateEntree) {
		this.dateEntree = dateEntree;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public Poste getP() {
		return p;
	}

	public void setP(Poste p) {
		this.p = p;
	}
	
}
