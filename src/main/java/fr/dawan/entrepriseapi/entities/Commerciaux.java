package fr.dawan.entrepriseapi.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "t_commerciaux")
public abstract class Commerciaux extends Employe {

	@Transient
	protected double taux;

	@Transient
	protected double fixe;
	
	
	public Commerciaux() {
	}


	public Commerciaux(String nom, String prenom, int age, LocalDate dateEntree, double CA) {
		super(nom, prenom, age, dateEntree, CA);
		// TODO Auto-generated constructor stub
	}
	
}
