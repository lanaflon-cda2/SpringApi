package fr.dawan.entrepriseapi.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

import fr.dawan.entrepriseapi.entities.enums.Poste;

@Entity
@Table(name = "t_prodarisque")
public class ProducteurARisque extends Producteur implements ARisque {

	public ProducteurARisque() {
		
	}
	public ProducteurARisque(String nom, String prenom, int age, LocalDate dateEntree, double baseCalc) {
		super(nom, prenom, age, dateEntree, baseCalc);
		this.p = Poste.PRODARISQUE;
	}

	@Override
	public double calculerSalaire() {
		return super.calculerSalaire() + PRIME_RISQUE;
	}

	@Override
	public String getPoste() {
		return "Le producteur a risque ";
	}
}
