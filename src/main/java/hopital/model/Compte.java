package hopital.model;

public class Compte {
	private int id_compte;
    private String login;
    private String password;
    private String typeCompte;
    
    public Compte(int id, String login, String password, String typeCompte) {
        this.id_compte = id;
        this.login = login;
        this.password = password;
        this.typeCompte = typeCompte;
    }
    
    public Compte(String login, String password, String typeCompte) {
    	this.login = login;
    	this.password = password;
    	this.typeCompte = typeCompte;
    }
    
    public Compte(int id) {
        this.id_compte = id;
    }
    

    public int getId() {
        return id_compte;
    }

    public void setId(int id) {
        this.id_compte = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTypeCompte() {
        return typeCompte;
    }

    public void setTypeCompte(String typeCompte) {
        this.typeCompte = typeCompte;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_compte;
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
		Compte other = (Compte) obj;
		if (id_compte != other.id_compte)
			return false;
		return true;
	}

}
