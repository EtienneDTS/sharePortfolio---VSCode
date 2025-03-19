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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ActionComposeeTest {

    private ActionComposee actionComposee;
    private ActionSimple actionSimple1;
    private ActionSimple actionSimple2;
    private Jour jour;

    @BeforeEach
    void setUp() {
        actionComposee = new ActionComposee("CompositeAction");
        actionSimple1 = new ActionSimple("AXA");
        actionSimple2 = new ActionSimple("LVMH");
        jour = new Jour(2025, 3);
    }

    @Test
    void testGetLibelle() {
        assertNotNull(actionComposee.getLibelle(), "Le libellé de l'action composée ne doit pas être nul.");
    }

    @Test
    void testLibelleCorrect() {
        assertEquals("CompositeAction", actionComposee.getLibelle(), "Le libellé de l'action composée doit être 'CompositeAction'.");
    }

    @Test
    void testValeurActionComposee() {
        assertEquals(0.0F, actionComposee.valeur(jour), "La valeur de l'action composée doit être 0 si aucune composition n'est enregistrée.");
    }

    @Test
    void testEnregComposition() {
        actionSimple1.enrgCours(jour, 100.5F);
        actionSimple2.enrgCours(jour, 50.0F);

        actionComposee.enrgComposition(actionSimple1, 0.6f);
        actionComposee.enrgComposition(actionSimple2, 0.4f);

        assertEquals(80.3F, actionComposee.valeur(jour), "La valeur de l'action composée doit être 80.3 après la composition.");
    }

    @Test
    void testValeurActionComposeeAvecCours() {
        actionSimple1.enrgCours(jour, 100.5F);
        actionSimple2.enrgCours(jour, 50.0F);

        actionComposee.enrgComposition(actionSimple1, 0.7f);
        actionComposee.enrgComposition(actionSimple2, 0.3f);

        assertEquals(85.35F, actionComposee.valeur(jour), "La valeur de l'action composée doit être 85.35 après la composition avec les cours.");
    }

    @Test
    void testValeurActionComposeeSansCours() {
        actionComposee.enrgComposition(actionSimple1, 0.5f);
        actionComposee.enrgComposition(actionSimple2, 0.5f);

        Jour jourFutur = new Jour(2025, 4);
        assertEquals(0.0F, actionComposee.valeur(jourFutur), "La valeur de l'action composée doit être 0 si aucune action n'a de cours enregistré pour le jour.");
    }

    @Test
    void testEqualsAndHashCode() {
        ActionComposee action1 = new ActionComposee("CompositeAction");
        ActionComposee action2 = new ActionComposee("CompositeAction");
        ActionComposee action3 = new ActionComposee("AnotherCompositeAction");

        assertEquals(action1, action2, "Les actions composées avec le même libellé doivent être égales.");
        assertNotEquals(action1, action3, "Les actions composées avec des libellés différents doivent être différentes.");
        assertEquals(action1.hashCode(), action2.hashCode(), "Les actions composées avec le même libellé doivent avoir le même hashcode.");
    }

    public class ActionSimple extends Action {

        public ActionSimple(String libelle) {
            super(libelle);
        }

        @Override
        public float valeur(Jour j) {
            return 0.0F;
        }

        public void enrgCours(Jour j, float valeur) {
            // Simulating a method to register the value for a specific day
        }
    }
}