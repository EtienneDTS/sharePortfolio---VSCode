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

        Fournisseur.getAllAction();
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
        Fournisseur.getAllAction();
    }

    @Test
    public void testGetAllActionWithNullAction() {
        Action action = new ActionSimple("Action1");
        Fournisseur.addAction(action);
        Fournisseur.addAction(null);
        Fournisseur.getAllAction();
    }

    @Test
    public void testRemoveAction() {
        Action action1 = new ActionSimple("Action1");
        Action action2 = new ActionSimple("Action2");
        Fournisseur.addAction(action1);
        Fournisseur.addAction(action2);

        Fournisseur.getActionPropose().remove(action1);
        assertEquals(1, Fournisseur.getActionPropose().size());
        assertFalse(Fournisseur.getActionPropose().contains(action1));
    }

    @Test
    public void testAddMultipleActions() {
        Action action1 = new ActionSimple("Action1");
        Action action2 = new ActionSimple("Action2");
        Action action3 = new ActionSimple("Action3");
        
        Fournisseur.addAction(action1);
        Fournisseur.addAction(action2);
        Fournisseur.addAction(action3);
        
        assertEquals(3, Fournisseur.getActionPropose().size());
        assertTrue(Fournisseur.getActionPropose().contains(action1));
        assertTrue(Fournisseur.getActionPropose().contains(action2));
        assertTrue(Fournisseur.getActionPropose().contains(action3));
    }

    @Test
    public void testAddSameActionTwice() {
        Action action = new ActionSimple("Action1");
        Fournisseur.addAction(action);
        Fournisseur.addAction(action);

        assertEquals(2, Fournisseur.getActionPropose().size());
        assertEquals(action, Fournisseur.getActionPropose().get(0));
        assertEquals(action, Fournisseur.getActionPropose().get(1));
    }

    @Test
    public void testGetActionInListNegativeIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            Fournisseur.getActionInList(-1);
        });
    }

    @Test
    public void testActionProposeSizeAfterRemoveAll() {
        Action action1 = new ActionSimple("Action1");
        Action action2 = new ActionSimple("Action2");
        Fournisseur.addAction(action1);
        Fournisseur.addAction(action2);
        Fournisseur.getActionPropose().clear();
        
        assertEquals(0, Fournisseur.getActionPropose().size());
    }

    @Test
    public void testAddNullToEmptyList() {
        Fournisseur.addAction(null);
        assertNull(Fournisseur.getActionInList(0));
    }

    @Test
    public void testAddNullThenValidAction() {
        Fournisseur.addAction(null);
        Action action = new ActionSimple("Action1");
        Fournisseur.addAction(action);
        
        assertEquals(2, Fournisseur.getActionPropose().size());
        assertEquals(action, Fournisseur.getActionInList(1));
    }
}
