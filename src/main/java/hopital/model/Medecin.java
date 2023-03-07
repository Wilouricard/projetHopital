package hopital.model;

import java.util.ArrayList;
import java.util.List;

public class Medecin extends Compte {
    private List<Visite> visites;
    
    public Medecin(int id, String login, String password) {
        super(id, login, password, "Medecin");
        this.visites = new ArrayList<Visite>();
    }
    
    public void rendreSalleDisponible(int salle, Patient patient) {
        // Créer une visite avec la salle, le patient et le médecin
        Visite visite = new Visite(salle, patient, this);
        // Ajouter la visite à la liste des visites en cours du médecin
        visites.add(visite);
    }
    
    public void afficherListeAttente(FileAttente fileAttente) {
        // Afficher la liste d'attente des patients
        fileAttente.afficherListeAttente();
    }
    
    public void afficherProchainPatient(FileAttente fileAttente) {
        // Afficher le prochain patiet dan la file d'attente
        fileAttente.afficherProchainPatient();
    }
    
    public void sauvegarderListeVisites() {
        // Sauvegarder la liste des visites en cours dans un fichier
        // ...
    }
}
