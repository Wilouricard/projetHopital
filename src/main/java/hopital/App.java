package hopital;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import hopital.model.FileAttente;
import hopital.model.Medecin;
import hopital.model.Patient;
import hopital.model.Secretaire;

public class App {
	// MENU DE ALEXIS
	public static void main(String[] args) {
		//DELET THAT LATER NEED FOR TEST NOW MAP FOR LOGINS AND PASSWORDS
//		Map<String,String> mLogins = new HashMap<>();
//		mLogins.put("Doc1", "mdp1");mLogins.put("Doc2", "mdp2");mLogins.put("Secretaire", "mdp3");
//		System.out.println(mLogins.get("Doc1"));

//DELET THAT LATER NEEDED FOR TEST NOW LIST D'ATTENTE
//		Object LA = "1234";
		
		// Interface de login
//		System.out.println("|                 Compte médecin                 |");		
		System.out.println("*------------------------------------------------*");
		System.out.println("|         Bienvenue à l'hôpital du style         |");
		System.out.println("*------------------------------------------------*");

		loggingIn("             Veuillez vous enregsitrer            ");
		
		System.out.println("Aurevoir");
	}
	
	
	private static void loggingIn(String phrase_prompt) {
		//delet that later and replace with a a list with a list of real logins and passwords
				Map<String,String> mLogins = new HashMap<String, String>();
				mLogins.put("Doc1", "mdp1");mLogins.put("Doc2", "mdp2");mLogins.put("Secretaire", "mdp3");
				
				
				Scanner sc = new Scanner(System.in);
				System.out.println(phrase_prompt);
				System.out.print(" Login: ");
				String login = sc.nextLine();
				if(login.toLowerCase().equals("q")) {
					return;
				}
				if (!mLogins.containsKey(login)){
					System.err.println("login innexistant");
					loggingIn("        Veuillez vous enregsitrer à nouveau       ");
				} else {
				System.out.print(" Mot de passe: ");
				String mdp = sc.nextLine();
		 
					if (!mLogins.get(login).equals(mdp)) {
						System.err.println("mot de passe inccorect");
						loggingIn("        Veuillez vous enregsitrer à nouveau       ");
					} else {
						System.out.println("Loggin successful");
						switch (login) {
						case "Doc1":
							System.out.println("*-----------------------------------------------*");
							System.out.println("|                Compte médecin                 |");
							System.out.println("*-----------------------------------------------*");
							accesMedecin(1);
							break;
						case "Doc2":
							System.out.println("*-----------------------------------------------*");
							System.out.println("|                Compte médecin                 |");
							System.out.println("*-----------------------------------------------*");
							accesMedecin(2);
							break;
						case "Secretaire":
							System.out.println("*-----------------------------------------------*");
							System.out.println("|               Compte secrétaire               |");
							System.out.println("*-----------------------------------------------*");
							accesSecretaire();
							break;
						case "Stop":
							break;
						}
					}
				}
				
			}
			
			private static void accesMedecin(int numeroMedecin) {
				String action = actionsMedecin(numeroMedecin);
				switch (action.toLowerCase()) {
				case "la":
					System.out.println();
					System.err.println("Afficher la Liste d'Attente");
					accesMedecin(numeroMedecin);
					break;
				
				case "rsd":
					System.err.println("Rendre la salle dispo");
					accesMedecin(numeroMedecin);
					break;
					
				case "slv":
					System.err.println("Sauvegarder la liste des visites");
					accesMedecin(numeroMedecin);
					break;
					
				case "dc":
					System.err.println("Déconnection réussie");
					loggingIn("             Veuillez vous enregsitrer            ");
					break;
				}
			}
			
			private static void accesSecretaire() {
				String action = actionsSecretaire();
				switch (action.toLowerCase()) {
				case "la":
					System.err.println("Afficher la Liste d'Attente");
					accesSecretaire();
					break;
				
				case "addla":
					System.err.println("Ajouter patient à la liste d'attente");
					accesSecretaire();
					break;
					
				case "p":
					System.err.println("Faire une pause");
					accesSecretaire();
					break;
					
				case "dc":
					System.err.println("Déconnection réussie");
					loggingIn("             Veuillez vous enregsitrer            ");
					break;
				}

				
			}
			
			private static String actionsSecretaire() {
				Scanner sc = new Scanner(System.in);
				System.out.println("            Veuillez saisir une action           ");
				System.out.println("Afficher la Liste d'Attente (LA)");
				System.out.println("Ajouter un patient à la Liste d'Attente (AddLA)");
				System.out.println("Faire une pause (P)");
				System.out.println("Déconnection (DC)");
				System.out.print("Action: ");
				String action = sc.nextLine();
				return action;
			}
			
			private static void afficherListeAttente(FileAttente fileAttente) {
				
				System.out.println(fileAttente);
			}
			private static void ajouterPatientLA(int id_patient) {
				
			}
			
			private static String actionsMedecin(int numero_medecin) {
				Scanner sc = new Scanner(System.in);
				System.out.println("            Veuillez saisir une action           ");
				System.out.println("Afficher la Liste d'Attente (LA)");
				System.out.println("Rendre la salle dispo (RSD)");
				System.out.println("Sauvegarder la liste des visites (SLV)");
				System.out.println("Déconnection (DC)");
				System.out.print("Action: ");
				String action = sc.nextLine();
				return action;
			}
	
	// MOOOOOOOOON COOOOOOOOOODE
//	public static void main(String[] args) {
//		System.out.println("Hello");
//		
//		// creation des medecins
//		Medecin medecin1 = new Medecin(1, "medecin1", "password1");
//        Medecin medecin2 = new Medecin(2, "medecin2", "password2");
//        
//        // creation secretaire
//        Secretaire secretaire = new Secretaire(3, "secretaire", "password3");
//        
//     // Craation de la file d'attente
//        FileAttente fileAttente = new FileAttente();
        
//     // Cretion d'un nouveau patient
//        Patient patient1 = new Patient("Nonom", "Jiji", 1);

//        // Ajou du patient à la file d'attente
//        fileAttente.ajouterPatient(patient1);
        
//     // Création d'un nouveau patient sans ID spécifié
//        Patient patient2 = new Patient("Momo", "Jouli");
        
        
//        // UTILISATEUR PATIENT MENUMENUMENU
//        Scanner scanner = new Scanner(System.in);
//        
//     // demande à patient user de mettre son ID
//        System.out.println("Veuillez saisir votre identifiant :");
//        int idPatient = scanner.nextInt();
//        
//        
//     // recherche du patient dans la bdd
//        Patient patient = null; // init à null pour le vérifierr plus tard
//        for (Patient p : BDDDDD) {
//            if (p.getId_patient() == idPatient) {
//                patient = p;
//                break;
//            }
//        }
//        
//     // si le patient n'est pas connu, on lui demande de remplir ses informations
//        if (patient == null) {
//            System.out.println("tu n'es pas connu de notre système, rempli les informations suivantes :");
//            System.out.println("Nom :");
//            String nom = scanner.next();
//            System.out.println("Prénom :");
//            String prenom = scanner.next();
//            patient = new Patient(nom, prenom, idPatient);
//            // ajout du nouveau patient dans la base de données
//            BDDDD.add_METHODDDDDD(patient);
//        }
//        
//     // ajout du patient dans la fileAttente
//        fileAttente.ajouterPatient(patient);
//        System.out.println("patient ajouter dans la file attente.");
       
        
        
        // MENOU MENU
//        Scanner sc = new Scanner(System.in);
//        int choix = -1;
//        
//        while (choix != 0) {
//            System.out.println("---- Menu principal ----");
//            System.out.println("1. Gestion de la file d'attente");
//            System.out.println("2. Gestion des visites");
//            System.out.println("0. Quitter l'application");
//            System.out.print("Votre choix : ");
//            choix = sc.nextInt();
//            System.out.println();
//
//            switch (choix) {
//                case 1:
//                    gestionFileAttente();
//                    break;
//
//                case 2:
//                    gestionVisites();
//                    break;
//
//                case 0:
//                    System.out.println("Au revoir !");
//                    break;
//
//                default:
//                    System.out.println("Choix invalide.");
//                    break;
//            }
//        }
//	}
        
 
//        private static void gestionFileAttente() {
//            Scanner sc = new Scanner(System.in);
//            int choix = -1;
//            
//            while (choix != 0) {
//                System.out.println("---- Gestion de la file d'attente ----");
//                System.out.println("1. Ajouter un patient à la file d'attente");
//                System.out.println("2. Afficher l'état de la file d'attente");
//                System.out.println("3. Partir en pause");
//                System.out.println("0. Retour au menu principal");
//                System.out.print("Votre choix : ");
//                choix = sc.nextInt();
//                System.out.println();
//
//                switch (choix) {
//                    case 1:
//                        System.out.println("Veuillez entrer l'identifiant du patient :");
//                        int id = sc.nextInt();
//                        Patient patient = trouverPatient(id);
//                        if (patient != null) {
//                            System.out.println("Patient trouvé dans la base de données.");
//                            System.out.println("Le patient " + patient.getNomComplet() + " est ajouté à la file d'attente.");
//                            fileAttente.ajouterPatient(patient);
//                        } else {
//                            System.out.println("Patient non trouvé dans la base de données. Veuillez remplir ses informations.");
//                            System.out.print("Nom : ");
//                            String nom = sc.next();
//                            System.out.print("Prénom : ");
//                            String prenom = sc.next();
//                            Patient nouveauPatient = new Patient(nom, prenom, id);
//                            ajouterPatient(nouveauPatient);
//                            System.out.println("Le patient " + nouveauPatient.getNomComplet() + " est ajouté à la base de données et à la file d'attente.");
//                            fileAttente.ajouterPatient(nouveauPatient);
//                        }
//                        break;
//
//                    case 2:
//                        System.out.println("---- Etat de la file d'attente ----");
//                        fileAttente.afficherFileAttente();
//                        break;
//
//                    case 3:
//                        System.out.println("La secrétaire part en pause.");
//                        break;
//
//                    case 0:
//                        System.out.println("Retour au menu principal.");
//                        break;
//
//                    default:
//                        System.out.println("Choix invalide.");
//                        break;
//                }
//                System.out.println();
//            }
//
//
//	}
//        
//       
//        private static void gestionVisites() {
//            Scanner sc = new Scanner(System.in);
//            int choix = -1;
//            
//            while (choix != 0) {
//                System.out.println("---- Gestion des visites ----");
//                System.out.println("1. Visualiser la liste d'attente");
//                System.out.println("2. Visualiser le prochain patient");
//                System.out.println("3. Sauvegarder la liste de ses visites");
//                System.out.println("0. Retour au menu principal");
//                System.out.print("Votre choix : ");
//                choix = sc.nextInt();
//                System.out.println();
//
//                switch (choix) {
//                    case 1:
//                        System.out.println("Liste des visites :");
//                        for (Visite visite : Medecin.getListeVisites()) {
//                            System.out.println(visite.toString());
//                        }
//                        System.out.println();
//                        break;
//
//                    case 2:
//                        System.out.println("Prochain patient : " + Medecin.getProchainPatient());
//                        System.out.println();
//                        break;
//
//                    case 3:
//                        Medecin.sauvegarderListeVisites();
//                        System.out.println("La liste des visites a été sauvegardée.");
//                        System.out.println();
//                        break;
//
//                    case 0:
//                        System.out.println("Retour au menu principal.");
//                        break;
//
//                    default:
//                        System.out.println("Choix invalide.");
//                        break;
//                }
//            }
//        }
//
//        
        
        
}



	
	
	
 
	
	
	
	
	
	
	
	
	

