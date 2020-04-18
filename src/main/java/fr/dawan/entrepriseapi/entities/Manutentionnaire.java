package fr.dawan.entrepriseapi.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import fr.dawan.entrepriseapi.entities.enums.Poste;

@Entity
@Table(name = "t_manutentionnaire")
public class Manutentionnaire extends Employe {

	private final static double SALAIRE_HORAIRE = 65.0;
	@Transient
	private int heures;
	
	public Manutentionnaire() {
		
	}
	
	public Manutentionnaire(String nom, String prenom, int age, LocalDate date, int heures) {
		super(nom, prenom, age, date, heures);
		this.p = Poste.MANUTENTIONNAIRE;
	}

	@Override
	public double calculerSalaire() {
		return SALAIRE_HORAIRE * heures;
	}
	
	public String getTitre() {
		return "Le manut. ";
	}

}
