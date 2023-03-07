package hopital.model;

import java.time.LocalDate;

public class Visite {
	private int numero_visite;
	private Patient id_patient;
	private Compte id_compte;
	private int cout_visite = 20;
	private int salle;
	private LocalDate date;
	
	public Visite(int numero_visite, Patient id_patient, Compte id_compte) {
		this.numero_visite = numero_visite;
		this.id_patient = id_patient;
		this.id_compte = id_compte;
	}
	
//	public Visite(int numero_visite, Patient id_patient, Compte id_compte, int cout_visite, int salle, LocalDate date) {
//		this.numero_visite = numero_visite;
//		this.id_patient = id_patient;
//		this.id_compte = id_compte;
//		this.cout_visite = cout_visite;
//		this.salle = salle;
//		this.date = date;
//	}
	


	public int getNumero_visite() {
		return numero_visite;
	}

	public void setNumero_visite(int numero_visite) {
		this.numero_visite = numero_visite;
	}

	public Patient getId_patient() {
		return id_patient;
	}

	public void setId_patient(Patient id_patient) {
		this.id_patient = id_patient;
	}

	public Compte getId_compte() {
		return id_compte;
	}

	public void setId_compte(Compte id_compte) {
		this.id_compte = id_compte;
	}

	public int getCout_visite() {
		return cout_visite;
	}

	public void setCout_visite(int cout_visite) {
		this.cout_visite = cout_visite;
	}

	public int getSalle() {
		return salle;
	}

	public void setSalle(int salle) {
		this.salle = salle;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
	
}
