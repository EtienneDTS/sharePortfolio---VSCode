/*
 * Copyright 2025 David Navarre &lt;David.Navarre at irit.fr&gt;.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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