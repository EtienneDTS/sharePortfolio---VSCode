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

import java.util.Scanner;

import tp04.metier.Menu;
import tp04.metier.Option;

public class Run {

    public static void main(String[] args) {
        System.out.println("Veuillez choisir une option : ");

        Menu menu = new Menu();

        Option option1 = new Option("Afficher la liste des Actions", menu);
        Option option2 = new Option("Afficher la liste des Portefeuilles", menu);


        while (true) {
            menu.afficherMenu();
            int choix = lireChoixUtilisateur();
            traiterChoix(choix);
        }
    }

    private static int lireChoixUtilisateur() {
        Scanner scanner = new Scanner(System.in);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Entrée non reconnue, veuillez entrer un nombre valide");
            return -1;
        }
    }

     private static void traiterChoix(int choix) {
    //     try {
    //         switch (choix) {
    //             case 1:
    //                 menu.
    //                 break;
    //             case 2:
    //                 Functions.creerEleveEtAffecterMaison(eleveDAO, maisonDAO, scanner);
    //                 break;
    //             case 3:
    //                 Functions.evaluerEleve(eleveDAO, matiereDAO, evaluerDAO, scanner);
    //                 break;
    //             case 4:
    //                 Functions.afficherClassementMaisons(eleveDAO);
    //                 break;
    //             case 5:
    //                 Functions.afficherTop10Eleves(eleveDAO);
    //                 break;
    //             case 6:
    //                 jouerPartieChifoumi();
    //                 break;
    //             case 7:
    //                 Functions.printWithDelay("🧙🏻 Au revoir !\n", 10);
    //                 scanner.close();
    //                 System.exit(0);
    //             default:
    //                 Functions.printWithDelay("Choix non reconnu, veuillez réessayer.\n", 10);
    //         }
    //     } catch (Exception e) {
    //         Functions.printWithDelay("Une erreur est survenue : " + e.getMessage() + "\n", 10);
    //         e.printStackTrace();
    //     }
     }

}

