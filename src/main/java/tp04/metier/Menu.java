package tp04.metier;
import java.util.ArrayList;
import java.util.Objects;

public class Menu {
    private ArrayList<Option> listeOptions;


    public Menu() {
        this.listeOptions = new ArrayList<>();
    }


    public ArrayList<Option> getListeOptions() {
        return listeOptions;
    }


    public void setListeOptions(ArrayList<Option> listeOptions) {
        this.listeOptions = listeOptions;
    }

    public void ajouterOption(Option option){
        this.listeOptions.add(option);
    }

    // methodes : afficher le menu 
    public void afficherMenu(){
        for(Option option : this.listeOptions){
            System.out.println(option.getNumOption() + " : " + option.getNomOption());
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Menu{");
        sb.append("listeOptions=").append(listeOptions);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.listeOptions);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Menu other = (Menu) obj;
        return Objects.equals(this.listeOptions, other.listeOptions);
    }

    
}