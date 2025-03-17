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

/**
 * Tests unitaires pour la classe Action et ses implémentations.
 */
class ActionTest {

    private Action actionImpl;
    private ActionSimple actionSimple;
    private Jour jour;

    @BeforeEach
    void setUp() {
        actionImpl = new ActionImpl("TestAction");
        actionSimple = new ActionSimple("AXA");
        jour = new Jour(2025, 3); 
    }

    @Test
    void testGetLibelle() {
        assertNotNull(actionImpl.getLibelle(), "Le libellé de l'action ne doit pas être nul.");
    }

    @Test
    void testLibelleCorrect() {
        assertEquals("TestAction", actionImpl.getLibelle(), "Le libellé de l'action doit être 'TestAction'.");
    }

    @Test
    void testValeurActionImpl() {
        assertEquals(0.0F, actionImpl.valeur(jour), "La valeur de l'action implémentée doit être 0.");
    }

    @Test
    void testEnregCours() {
        actionSimple.enrgCours(jour, 100.5F);

        assertEquals(100.5F, actionSimple.valeur(jour), "La valeur de l'action AXA pour ce jour devrait être 100.5.");
    }

    @Test
    void testValeurActionSimple() {
        
        actionSimple.enrgCours(jour, 100.5F);
        assertEquals(100.5F, actionSimple.valeur(jour), "La valeur de l'action simple AXA doit être 100.5.");
       
        Jour jourFutur = new Jour(2025, 4);
        assertEquals(0.0F, actionSimple.valeur(jourFutur), "La valeur de l'action AXA pour un jour sans cours doit être 0.");
    }

    @Test
    void testEqualsAndHashCode() {
        Action action1 = new ActionImpl("TestAction");
        Action action2 = new ActionImpl("TestAction");
        Action action3 = new ActionImpl("DifferentAction");
        assertEquals(action1, action2, "Les actions avec le même libellé doivent être égales.");
        assertNotEquals(action1, action3, "Les actions avec des libellés différents doivent être différentes.");
        assertEquals(action1.hashCode(), action2.hashCode(), "Les actions avec le même libellé doivent avoir le même hashcode.");
    }

    
    public class ActionImpl extends Action {

        public ActionImpl(String libelle) {
            super(libelle);
        }

        @Override
        public float valeur(Jour j) {
            return 0.0F; 
        }
    }
}
