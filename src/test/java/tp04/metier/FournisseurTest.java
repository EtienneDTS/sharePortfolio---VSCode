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

public class FournisseurTest {

    @BeforeEach
    public void setUp() {
        Fournisseur.getActionPropose().clear();
    }

    @Test
    public void testAddAction() {
        Action action = new ActionSimple("Action1");
        Fournisseur.addAction(action);
        assertEquals(1, Fournisseur.getActionPropose().size());
        assertEquals(action, Fournisseur.getActionPropose().get(0));
    }

    @Test
    public void testGetActionInList() {
        Action action1 = new ActionSimple("Action1");
        Action action2 = new ActionSimple("Action2");
        Fournisseur.addAction(action1);
        Fournisseur.addAction(action2);

        Action result = Fournisseur.getActionInList(1);
        assertEquals(action2, result);
    }

    @Test
    public void testGetActionPropose() {
        Action action = new ActionSimple("Action1");
        Fournisseur.addAction(action);

        assertNotNull(Fournisseur.getActionPropose());
        assertTrue(Fournisseur.getActionPropose().contains(action));
    }

    @Test
    public void testGetActionInListOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            Fournisseur.getActionInList(0);
        });
    }

    @Test
    public void testGetAllAction() {
        Action action1 = new ActionSimple("Action1");
        Action action2 = new ActionSimple("Action2");
        Fournisseur.addAction(action1);
        Fournisseur.addAction(action2);
        
        Jour jour = new Jour(2024, 2);
        Fournisseur.getAllAction(jour);
    }

    @Test
    public void testAddNullAction() {
        Fournisseur.addAction(null);
        assertEquals(1, Fournisseur.getActionPropose().size());
        assertNull(Fournisseur.getActionInList(0));
    }

    @Test
    public void testClearActionList() {
        Action action1 = new ActionSimple("Action1");
        Action action2 = new ActionSimple("Action2");
        Fournisseur.addAction(action1);
        Fournisseur.addAction(action2);
        Fournisseur.getActionPropose().clear();
        assertTrue(Fournisseur.getActionPropose().isEmpty());
    }

    @Test
    public void testSizeAfterMultipleAdds() {
        for (int i = 0; i < 100; i++) {
            Action action = new ActionSimple("Action" + i);
            Fournisseur.addAction(action);
        }
        assertEquals(100, Fournisseur.getActionPropose().size());
    }

    @Test
    public void testGetActionProposeWhenEmpty() {
        assertTrue(Fournisseur.getActionPropose().isEmpty());
    }

    @Test
    public void testGetAllActionEmptyList() {
        Jour jour = new Jour(2024, 2);
        Fournisseur.getAllAction(jour);
    }
}
