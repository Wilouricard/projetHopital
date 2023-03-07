package hopital.model;

public class Patient {
	private String nom;
	private String prenom;
	private int id_patient;


	public Patient(String nom, String prenom, int id_patient) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.id_patient = id_patient;
	}





	public Patient(int id_patient) {
        this.id_patient = id_patient;
    }
	
	
	
	public Patient(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}





	public String getNom() {
		return nom;
	}





	public void setNom(String nom) {
		this.nom = nom;
	}





	public String getPrenom() {
		return prenom;
	}





	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}





	public int getId_patient() {
		return id_patient;
	}

	public void setId_patient(int id_patient) {
		this.id_patient = id_patient;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_patient;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		if (id_patient != other.id_patient)
			return false;
		return true;
	}
	
	
	
}
