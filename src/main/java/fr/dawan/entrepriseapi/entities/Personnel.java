package fr.dawan.entrepriseapi.entities;

public class Personnel {
	Employe[] employes = new Employe[100];
	public static int nbEmploye;
	
	public void ajouterEmploye(Employe e) {
		if (nbEmploye < 100) {
			this.employes[nbEmploye] = e;
			nbEmploye++;
		}
	}
	
	public void afficherSalaire() {
		for (int i = 0; i < nbEmploye; i++) {
			System.out.println(this.employes[i].calculerSalaire());
		}
	}
}
