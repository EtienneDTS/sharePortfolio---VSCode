package tp04.metier;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String nom;
    private String prenom;
    private List<Portefeuille> portefeuilles;

    public User(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        this.portefeuilles = new ArrayList<>(); 
    }



    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public List<Portefeuille> getPortefeuilles() {
        return portefeuilles;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public void setPortefeuilles(List<Portefeuille> portefeuilles) {
        this.portefeuilles = portefeuilles;
    }

    @Override
    public String toString() {
        return "User{nom='" + nom + "', prenom='" + prenom + "', portefeuilles=" + portefeuilles.size() + "}";
    }

    
    
}

