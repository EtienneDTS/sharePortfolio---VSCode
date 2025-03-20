package tp04.metier;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PortefeuilleTest {

    @Test
    void testPortefeuilleCreation() {
        User user = new User("Dupont", "Jean");
        Portefeuille portefeuille = new Portefeuille("Investissements", user);

        assertEquals("Investissements", portefeuille.getNom(), "Le nom du portefeuille doit être correctement initialisé");
        assertEquals(0.0, portefeuille.getMontant(), "Le montant initial du portefeuille doit être 0.0");
        assertEquals(user, portefeuille.getUser(), "L'utilisateur associé doit être correctement initialisé");
        assertTrue(portefeuille.getId() > 0, "L'ID du portefeuille doit être supérieur à 0");
    }

    @Test
    void testSetters() {
        User user = new User("Dupont", "Jean");
        Portefeuille portefeuille = new Portefeuille("Investissements", user);

        portefeuille.setNom("Épargne");
        portefeuille.setMontant(2000.0);
        User newUser = new User("Durand", "Paul");
        portefeuille.setUser(newUser);

        assertEquals("Épargne", portefeuille.getNom(), "Le nom du portefeuille doit être mis à jour");
        assertEquals(2000.0, portefeuille.getMontant(), "Le montant du portefeuille doit être mis à jour");
        assertEquals(newUser, portefeuille.getUser(), "L'utilisateur associé doit être mis à jour");
    }

    @Test
    void testToString() {
        User user = new User("Dupont", "Jean");
        Portefeuille portefeuille = new Portefeuille("Investissements", user);

        String result = portefeuille.toString();

        assertNotNull(result, "La méthode toString ne doit pas retourner null");
        assertTrue(result.contains("Investissements"), "Le nom du portefeuille doit être inclus dans la méthode toString");
        assertTrue(result.contains("0.0"), "Le montant initial du portefeuille doit être inclus dans la méthode toString");
        assertTrue(result.contains(user.toString()), "L'utilisateur associé doit être inclus dans la méthode toString");
    }

    @Test
    void testEquals() {
        User user1 = new User("Dupont", "Jean");
        User user2 = new User("Durand", "Paul");

        Portefeuille portefeuille1 = new Portefeuille("Investissements", user1);
        Portefeuille portefeuille2 = new Portefeuille("Investissements", user1);
        Portefeuille portefeuille3 = new Portefeuille("Épargne", user2);

        assertEquals(portefeuille1, portefeuille1, "Un portefeuille doit être égal à lui-même");
        assertNotEquals(portefeuille1, portefeuille2, "Deux portefeuilles avec des IDs différents ne doivent pas être égaux");
        assertNotEquals(portefeuille1, portefeuille3, "Deux portefeuilles avec des noms ou utilisateurs différents ne doivent pas être égaux");
        assertNotEquals(portefeuille1, null, "Un portefeuille ne doit jamais être égal à null");
        assertNotEquals(portefeuille1, user1, "Un portefeuille ne doit jamais être égal à un objet d'un autre type");
    }

    @Test
    void testHashCode() {
        User user1 = new User("Dupont", "Jean");
        User user2 = new User("Durand", "Paul");

        Portefeuille portefeuille1 = new Portefeuille("Investissements", user1);
        Portefeuille portefeuille2 = new Portefeuille("Investissements", user1);
        Portefeuille portefeuille3 = new Portefeuille("Épargne", user2);

        assertNotEquals(portefeuille1.hashCode(), portefeuille2.hashCode(), "Deux portefeuilles différents doivent avoir des hash codes différents");
        assertNotEquals(portefeuille1.hashCode(), portefeuille3.hashCode(), "Deux portefeuilles avec des noms ou utilisateurs différents doivent avoir des hash codes différents");
    }

    @Test
    void testMontantNegatif() {
        User user = new User("Dupont", "Jean");
        Portefeuille portefeuille = new Portefeuille("Investissements", user);

        portefeuille.setMontant(-500.0);

        assertEquals(-500.0, portefeuille.getMontant(), "Le montant négatif doit être accepté (si c'est permis par les règles métier)");
    }

    @Test
    void testMultiplePortefeuillesIncrementId() {
        User user = new User("Dupont", "Jean");
        Portefeuille portefeuille1 = new Portefeuille("Investissements", user);
        Portefeuille portefeuille2 = new Portefeuille("Épargne", user);

        assertTrue(portefeuille2.getId() > portefeuille1.getId(), "L'ID doit s'incrémenter pour chaque nouveau portefeuille créé");
    }

    @Test
    void testNomVide() {
        User user = new User("Dupont", "Jean");
        Portefeuille portefeuille = new Portefeuille("", user);

        assertEquals("", portefeuille.getNom(), "Le portefeuille devrait accepter un nom vide (si c'est permis par les règles métier)");
    }
}
