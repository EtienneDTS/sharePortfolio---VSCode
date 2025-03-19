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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PortefeuilleTest {

    private Portefeuille portefeuille;
    private Action action1;
    private Action action2;
    private Jour jour;

    @BeforeEach
    void setUp() {
        portefeuille = new Portefeuille();
        action1 = new ActionSimple("BNP");
        action2 = new ActionSimple("AXA");
        jour = new Jour(2014, 1);  // Exemple de jour
    }

    @Test
    void testAcheterAction() {
        portefeuille.acheter(action1, 10);
        assertEquals(10, portefeuille.mapLignes.get(action1).getQte(), "La quantité d'actions BNP devrait être 10.");
    }

    @Test
    void testVendreAction() {
        portefeuille.acheter(action1, 10);
        portefeuille.vendre(action1, 5);
        assertEquals(5, portefeuille.mapLignes.get(action1).getQte(), "La quantité d'actions BNP devrait être 5 après la vente.");


        portefeuille.vendre(action1, 5);
        assertNull(portefeuille.mapLignes.get(action1), "L'action BNP devrait être supprimée du portefeuille.");
    }

    @Test
    void testValeurPortefeuille() {
        ActionSimple action3 = new ActionSimple("Capgemini");
        ActionSimple action4 = new ActionSimple("Sopra");
        action3.enrgCours(jour, 100f);
        action4.enrgCours(jour, 5);
        portefeuille.acheter(action1, 10);
        portefeuille.acheter(action2, 5);
        assertEquals(1025, portefeuille.valeur(jour), "La valeur totale du portefeuille ne correspond pas à la somme des actions.");
    }

    @Test
    void testAcheterPlusieursActions() {
        portefeuille.acheter(action1, 10);
        portefeuille.acheter(action2, 20);

        
        assertEquals(10, portefeuille.mapLignes.get(action1).getQte(), "La quantité d'actions BNP devrait être 10.");
        assertEquals(20, portefeuille.mapLignes.get(action2).getQte(), "La quantité d'actions AXA devrait être 20.");
    }
}