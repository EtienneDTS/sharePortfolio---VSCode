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

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tp04.metier.*;

public class RunTest {

    @BeforeEach
    public void setUp() {
        Fournisseur.getActionPropose().clear(); // Clear the list before each test
    }

    @Test
    public void testActionAdding() {
        ActionSimple bnp = new ActionSimple("BNP");
        ActionSimple axa = new ActionSimple("AXA");
        ActionComposee bqAss = new ActionComposee("Banque-Assurance");

        Fournisseur.addAction(bnp);
        Fournisseur.addAction(axa);
        Fournisseur.addAction(bqAss);

        assertEquals(3, Fournisseur.getActionPropose().size(), "Fournisseur should have 3 actions");
        assertTrue(Fournisseur.getActionPropose().contains(bnp), "Fournisseur should contain BNP");
        assertTrue(Fournisseur.getActionPropose().contains(axa), "Fournisseur should contain AXA");
        assertTrue(Fournisseur.getActionPropose().contains(bqAss), "Fournisseur should contain Banque-Assurance");
    }

    @Test
    public void testActionCours() {
        ActionSimple axa = new ActionSimple("AXA");
        Jour j1 = new Jour(2014, 1);
        Jour j2 = new Jour(2014, 2);

        axa.enrgCours(j1, 200);
        axa.enrgCours(j2, 250);

        assertEquals(200, axa.valeur(j1), "AXA's value on 2014-01 should be 200");
        assertEquals(250, axa.valeur(j2), "AXA's value on 2014-02 should be 250");
    }

    @Test
    public void testActionComposeeComposition() {
        ActionSimple bnp = new ActionSimple("BNP");
        ActionSimple axa = new ActionSimple("AXA");
        ActionComposee bqAss = new ActionComposee("Banque-Assurance");

        bqAss.enrgComposition(axa, 0.3f);
        bqAss.enrgComposition(bnp, 0.7f);

        assertEquals(2, bqAss.getCompositions().size(), "The composite action should have 2 components");
        assertTrue(bqAss.getCompositions().containsKey(axa), "The composite action should contain AXA");
        assertTrue(bqAss.getCompositions().containsKey(bnp), "The composite action should contain BNP");
    }

    @Test
    public void testActionAddingNull() {
        ActionSimple axa = new ActionSimple("AXA");
        Fournisseur.addAction(axa);
        Fournisseur.addAction(null); // Adding null action

        assertEquals(2, Fournisseur.getActionPropose().size(), "Fournisseur should contain 2 actions");
        assertNull(Fournisseur.getActionPropose().get(1), "The second action should be null");
    }

    @Test
    public void testActionComposeeValue() {
        ActionSimple axa = new ActionSimple("AXA");
        ActionSimple bnp = new ActionSimple("BNP");
        ActionComposee bqAss = new ActionComposee("Banque-Assurance");

        Jour j1 = new Jour(2014, 1);
        Jour j2 = new Jour(2014, 2);

        bqAss.enrgComposition(axa, 0.3f);
        bqAss.enrgComposition(bnp, 0.7f);

        axa.enrgCours(j1, 200);
        axa.enrgCours(j2, 250);
        bnp.enrgCours(j1, 100);
        bnp.enrgCours(j2, 200);

        assertEquals(200 * 0.3f + 100 * 0.7f, bqAss.valeur(j1), "Value of Banque-Assurance on 2014-01 should be the weighted average of its components");
        assertEquals(250 * 0.3f + 200 * 0.7f, bqAss.valeur(j2), "Value of Banque-Assurance on 2014-02 should be the weighted average of its components");
    }

    @Test
    public void testAddMultipleActions() {
        for (int i = 0; i < 100; i++) {
            Action action = new ActionSimple("Action" + i);
            Fournisseur.addAction(action);
        }

        assertEquals(100, Fournisseur.getActionPropose().size(), "Fournisseur should have 100 actions");
    }

    @Test
    public void testGetActionInListOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            Fournisseur.getActionInList(0); // Empty list, should throw exception
        });
    }

    @Test
    public void testGetAllActionWithEmptyList() {
        Jour jour = new Jour(2024, 2);
        Fournisseur.getAllAction(jour); // Testing if the method handles an empty list gracefully
    }
}
