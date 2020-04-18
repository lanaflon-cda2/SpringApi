package fr.dawan.entrepriseapi.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

import fr.dawan.entrepriseapi.entities.enums.Poste;

@Entity
@Table(name = "t_representant")
public class Representant extends Commerciaux {
	
	public Representant() {
		super();
	}
	
	public Representant(String nom, String prenom, int age, LocalDate dateEntree, double ca) {
		super(nom, prenom, age, dateEntree, ca);
		this.taux = 0.02F;
		this.fixe = 800;
		this.p = Poste.REPRESENTANT;
	}
	
	@Override
	public double calculerSalaire() {
		return this.baseCalcul * this.taux + this.fixe;
	}
	@Override
	public String getPoste() {
		return "Le representant ";
	}
}
