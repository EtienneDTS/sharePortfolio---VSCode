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
}