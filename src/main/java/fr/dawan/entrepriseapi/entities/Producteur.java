package fr.dawan.entrepriseapi.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

import fr.dawan.entrepriseapi.entities.enums.Poste;

@Entity
@Table(name = "t_producteur")
public class Producteur extends Employe {
	

	private final static double COEF = 5;
	

	public Producteur() {
		super();
	}


	public Producteur(String nom, String prenom, int age, LocalDate dateEntree, double baseCalc) {
		super(nom, prenom, age, dateEntree, baseCalc);
		this.p = Poste.PRODARISQUE;
	}


	@Override
	public double calculerSalaire() {
		return this.baseCalcul * this.baseCalcul;
	}

	@Override
	public String getPoste() {
		return "Le producteur ";
	}
}
