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
import java.util.List;
import java.util.Objects;

public class Menu {
    private List<Option> listeOptions;

    // Constructor
    public Menu() {
        this.listeOptions = new ArrayList<>();
    }

    // Obtenir la liste des options pour le teste (Uutil ne supprime pas)
    public List<Option> getListeOptions() {
        return this.listeOptions;
    }

    // Ajouter une option dans le menu 
    public void ajouterOption(Option option){
        this.listeOptions.add(option);
    }

    // methodes : afficher le menu && StringBuilder用于高效拼接字符串的类
    public String afficherMenu() {
        StringBuilder sb = new StringBuilder();
        for (Option option : this.listeOptions) {
            sb.append(option.getNumOption())
              .append(" : ")
              .append(option.getNomOption())
              .append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Menu{" +
                "listeOptions=" + listeOptions +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return Objects.equals(listeOptions, menu.listeOptions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listeOptions);
    }

    
}