package tp04.metier;


import java.util.ArrayList;
import java.util.List;

public class Portefeuille {
    private String nom;
    private double montant;
    private User user;
    private static int idCounter = 0;
    private int id;
    private List<Action> actionsList; // Liste des actions propre à chaque portefeuille


    public Portefeuille(String nom, User user) {
        idCounter++;
        this.nom = nom;
        this.montant = 0.0;
        this.user = user;
        this.id = idCounter;
        this.actionsList = new ArrayList<>(); // Initialisation de la liste d'actions
    }

    public String getNom() {
        return nom;
    }

    public double getMontant() {
        return montant;
    }

    public int getId() {
        return id;
    }

    public List<Action> getActions() {
        return actionsList;
    }


    public User getUser() {
        return user;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Portefeuille{nom='" + nom + "', montant=" + montant + ", user=" + user + "}";
    }

    @Override
    public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Portefeuille that = (Portefeuille) o;
    return id == that.id && // Ajout de la comparaison de l'ID
           Double.compare(that.montant, montant) == 0 &&
           nom.equals(that.nom) &&
           user.equals(that.user);
}

    @Override
    public int hashCode() {
    int result = Integer.hashCode(id);
    result = 31 * result + nom.hashCode();
    result = 31 * result + Double.hashCode(montant);
    result = 31 * result + user.hashCode();
    return result;
}
}
