package hopital.model;

import java.util.ArrayList;
import java.util.List;

public class FileAttente {
    private List<Patient> patients;
    
    public FileAttente() {
        patients = new ArrayList<Patient>();
    }
    
    public void ajouterPatient(Patient patient) {
        // add un patient a la fin de la file d'attente
        patients.add(patient);
    }
    
    public void afficherEtat() {
        // afficher l'état dla file
        System.out.println("Etat de la file d'attente : ");
        if (patients.isEmpty()) {
            System.out.println("La file d'attente est vide.");
        } else {
            System.out.println("La file d'attente contient " + patients.size() + " patient(s) :");
            for (Patient patient : patients) {
                System.out.println("- " + patient);
            }
        }
    }
    
    public void afficherListeAttente() {
        // affich liste patient ak une boucle
        System.out.println("Liste d'attente des patients :");
        for (int i = 0; i < patients.size(); i++) {
            System.out.println((i+1) + ". " + patients.get(i));
        }
    }
    
    public void afficherProchainPatient() {
        // afficher prochein patient
        if (patients.isEmpty()) {
            System.out.println("Il n'y a pas de patien dans la file d'attente.");
        } else {
            System.out.println("Prochain patien dans la file d'attente : " + patients.get(0));
        }
    }
    
    public void vider() {
        // Vider la file d'attente
        patients.clear();
    }
    
    public void sauvegarderFile(String fileName) {
        // Sauvegarder la file d'attente dans un fichier
        // ...
    }
}
