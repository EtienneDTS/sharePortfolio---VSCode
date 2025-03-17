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
        Action action = new Action("Action1");
        Fournisseur.addAction(action);
        assertEquals(1, Fournisseur.getActionPropose().size(), "La liste doit contenir une action");
        assertEquals(action, Fournisseur.getActionPropose().get(0), "L'action ajoutée doit être récupérée correctement");
    }

    @Test
    public void testGetActionInList() {
        Action action1 = new Action("Action1");
        Action action2 = new Action("Action2");
        Fournisseur.addAction(action1);
        Fournisseur.addAction(action2);

        Action result = Fournisseur.getActionInList(1);
        assertEquals(action2, result, "L'action à l'index 1 doit être action2");
    }

    @Test
    public void testGetActionPropose() {
        Action action = new Action("Action1");
        Fournisseur.addAction(action);

        assertNotNull(Fournisseur.getActionPropose(), "La liste des actions ne doit pas être nulle");
        assertTrue(Fournisseur.getActionPropose().contains(action), "La liste doit contenir l'action ajoutée");
    }

    @Test
    public void testGetActionInListOutOfBounds() {
        
        assertThrows(IndexOutOfBoundsException.class, () -> {
            Fournisseur.getActionInList(0); 
        });
    }
}