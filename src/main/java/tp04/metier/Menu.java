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

public class Menu {
    private ArrayList<Option> listeOptions;


    public Menu() {
        this.listeOptions = new ArrayList<>();
    }


    public ArrayList<Option> getListeOptions() {
        return listeOptions;
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
}