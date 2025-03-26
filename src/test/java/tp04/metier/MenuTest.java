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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MenuTest {

    // test pour véridier la bonne création d'un menu avec des paramètres corrects
    @Test 
    void testCreateMenuWithCorrectParameters() {
        Assertions.assertDoesNotThrow(() -> {
            Menu menu = new Menu();
            Option option = new Option("Test", menu);
            Assertions.assertEquals(option.getNomOption(), menu.getListeOptions().get(0).getNomOption());
        });
    }

    // test pour vérifier l'affichage du menu avec des options
    @Test
    void testAfficherMenu() {
        Menu menu = new Menu();
        Option option1 = new Option("Option 1", menu);
        Option option2 = new Option("Option 2", menu);

        String expectedOutput =
                option1.getNumOption() + " : " + option1.getNomOption() + "\n" +
                option2.getNumOption() + " : " + option2.getNomOption() + "\n";

        String actualOutput = menu.afficherMenu();

        Assertions.assertEquals(expectedOutput, actualOutput);
    }

    // test le bon fonctionnement de la méthode toString
    @Test
    void testMenuToString() {
        Menu menu = new Menu();
        Option option = new Option("Test Option", menu);

        String expected = "Menu{listeOptions=[" + option.toString() + "]}";
        Assertions.assertEquals(expected, menu.toString());
    }

    // test le bon fonctionnement des méthodes Eaquals et Hashcode 
    @Test
    void testMenuEqualsAndHashCode() {
        Menu menu1 = new Menu();
        Menu menu2 = new Menu();

        Option option1 = new Option("Option 1", menu1);

        menu2.ajouterOption(option1);

        Assertions.assertEquals(menu1, menu2);
        Assertions.assertEquals(menu1.hashCode(), menu2.hashCode());
    }
    
}
