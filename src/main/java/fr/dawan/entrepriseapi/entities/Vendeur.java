package fr.dawan.entrepriseapi.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

import fr.dawan.entrepriseapi.entities.enums.Poste;

@Entity
@Table(name = "t_vendeur")
public class Vendeur extends Commerciaux {

	public Vendeur() {
		super();
	}
	
	public Vendeur(
				String nom, 
				String prenom, 
				int age, 
				LocalDate dateEntree, 
				double ca) {
		super(nom, prenom, age, dateEntree, ca);
		this.taux = 0.2;
		this.fixe = 400;
		this.p = Poste.VENDEUR;
	}

	@Override
	public double calculerSalaire() {
		return this.baseCalcul * this.taux + this.fixe;
	}

	@Override
	public String getPoste() {
		return "Le Vendeur ";
	}
}
