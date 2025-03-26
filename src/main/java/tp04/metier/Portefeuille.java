package tp04.metier;

import java.util.logging.Logger;

public class Portefeuille {
    private static final Logger logger = Logger.getLogger(Portefeuille.class.getName());
    private String nom;
    private double montant;
    private User user;
    private static int idCounter = 0;
    private int id;

    public Portefeuille(String nom, User user) {
        idCounter++;
        this.nom = nom;
        this.montant = 0.0;
        this.user = user;
        this.id = idCounter;
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

    //Nommage du portefeuille        
    public void nommerPortefeuille(String nouveauNom) {
        setNom(nouveauNom);
        if (logger.isLoggable(java.util.logging.Level.INFO)) {
            logger.info(String.format("Le portefeuille a été nommé: %s", nouveauNom));
        }
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
