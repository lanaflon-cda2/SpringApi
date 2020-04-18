package fr.dawan.entrepriseapi.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

import fr.dawan.entrepriseapi.entities.enums.Poste;

@Entity
@Table(name = "t_manutarisque")
public class ManutARisque extends Manutentionnaire implements ARisque {

	public ManutARisque() {
		
	}
	
	public ManutARisque(String nom, String prenom, int age, LocalDate date, int heures) {
		super(nom, prenom, age, date, heures);
		this.p = Poste.MANUTARISQUE;
	}

	@Override
	public double calculerSalaire() {
		return super.calculerSalaire() + PRIME_RISQUE;
	}
	
	

}
