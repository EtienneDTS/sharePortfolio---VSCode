package tp04.metier;

import java.util.Objects;

public class Option {
    private static int uid =0;
    private int numOption;
    private String nomOption;

    public Option (String nomOption, Menu menu){
        uid += 1;
		this.numOption = uid;
		this.nomOption = nomOption;
        menu.ajouterOption(this);
    }

    public int getNumOption() {
        return numOption;
    }

    public void setNumOption(int numOption) {
        this.numOption = numOption;
    }

    public String getNomOption() {
        return nomOption;
    }

    public void setNomOption(String nomOption) {
        this.nomOption = nomOption;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Option{");
        sb.append("numOption=").append(numOption);
        sb.append(", nomOption=").append(nomOption);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.numOption;
        hash = 13 * hash + Objects.hashCode(this.nomOption);
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
        final Option other = (Option) obj;
        if (this.numOption != other.numOption) {
            return false;
        }
        return Objects.equals(this.nomOption, other.nomOption);
    }

    
    
}
