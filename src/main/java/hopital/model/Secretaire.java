package hopital.model;



	public class Secretaire extends Compte {
	    public Secretaire(int id, String login, String password) {
	        super(id, login, password, "Secretaire");
	    }
	    
	    public void ajouterPatient(FileAttente fileAttente, Patient patient) {
	        fileAttente.ajouterPatient(patient);
	    }
	    
	    public void afficherEtatFile(FileAttente fileAttente) {
	        fileAttente.afficherEtat();
	    }
	    
	    public void partirEnPause(FileAttente fileAttente) {
	        fileAttente.sauvegarderFile("file_attente.txt");
	        fileAttente.vider();
	    }
	}
