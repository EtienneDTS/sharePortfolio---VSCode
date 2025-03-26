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
package tp04.exec;


import java.util.List;

import tp04.metier.ActionComposee;
import tp04.metier.ActionSimple;
import tp04.metier.Fournisseur;
import tp04.metier.Jour;
import tp04.metier.Menu;
import tp04.metier.Option;


public class Run {

    public static void main(String[] args) {
        ActionSimple actionSimple1;
        ActionSimple actionSimple2;
        ActionComposee actionComposee1;
        Jour jour1;
        Jour jour2;

        // init des objets metiers Jour
        jour1 = new Jour(2014, 1);
        System.out.println(jour1);
        jour2 = new Jour(2014, 2);
        System.out.println(jour2);

        // creation d'actions simples et composée
        actionSimple1 = new ActionSimple("BNP");
        System.out.println(actionSimple1);
        actionSimple2 = new ActionSimple("AXA");
        System.out.println(actionSimple2);
        actionComposee1 = new ActionComposee("Banque-Assurance");
        System.out.println(actionComposee1);

        // enrg de la composition de l'action composée
        actionComposee1.enrgComposition(actionSimple1, 0.3f);
        actionComposee1.enrgComposition(actionSimple2, 0.7f);
        System.out.println(actionComposee1);

        // enrg. de 2 cours pour chaque action 
        actionSimple1.enrgCours(jour1, 200);
        actionSimple1.enrgCours(jour2, 250);
        actionSimple2.enrgCours(jour1, 100);
        actionSimple2.enrgCours(jour2, 200);

        Fournisseur.addAction(actionComposee1);
        Fournisseur.addAction(actionSimple1);
        Fournisseur.addAction(actionSimple2);
        List listeActionFournisseur = Fournisseur.getActionPropose();
        System.out.println(listeActionFournisseur);

        // créer un menu
        Menu menu = new Menu();

        // créer des options 
        Option option1  = new Option("Afficher la liste des options",menu);
        Option option2  = new Option("Afficher la liste des portefeuille",menu);

        // afficher dans le menu
        System.out.println(menu.afficherMenu());

    }

}
