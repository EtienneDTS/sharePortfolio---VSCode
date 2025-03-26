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

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 * Test class for User
 * 
 * @version 1.0
 */

class UserTest {



    @Test
    void testSetPortefeuilles() {
        User user = new User("Nom", "Prenom");
        List<Portefeuille> list = new ArrayList<>();
        list.add(new Portefeuille("Crypto", user)); // Ajout de l'utilisateur dans le constructeur
        user.setPortefeuilles(list);
    
        assertEquals(1, user.getPortefeuilles().size(), "La liste des portefeuilles doit contenir un élément");
        assertEquals("Crypto", user.getPortefeuilles().get(0).getNom(), "Le nom du portefeuille doit être 'Crypto'");
    }

    @Test
    void testAddPortefeuilleNull() {
        User user = new User("Dupont", "Jean");
        assertThrows(IllegalArgumentException.class, 
            () -> user.addPortefeuille(null), 
            "L'ajout d'un portefeuille null devrait lancer une exception IllegalArgumentException");
    }

    @Test
    void testGetPortefeuilleByIdInexistant() {
        User user = new User("Dupont", "Jean");
        Portefeuille portefeuille = new Portefeuille("Portefeuille A", user);
        user.addPortefeuille(portefeuille);

        Portefeuille result = user.getPortefeuilleById(999);  // ID inexistant
        assertEquals(null, result, "La méthode devrait retourner null si aucun portefeuille avec l'ID donné n'est trouvé");
    }

    @Test
    void testNomSetterAvecNull() {
        User user = new User("Dupont", "Jean");
        assertThrows(NullPointerException.class, 
            () -> user.setNom(null), 
            "Le setter pour le nom devrait lancer une exception NullPointerException si le nom est null");
    }

    @Test
    void testPrenomSetterAvecNull() {
        User user = new User("Dupont", "Jean");
        assertThrows(NullPointerException.class, 
            () -> user.setPrenom(null), 
            "Le setter pour le prénom devrait lancer une exception NullPointerException si le prénom est null");
    }

    @Test
    void testSetIdNegative() {
        User user = new User("Durand", "Paul");
        user.setId(-5);
        assertEquals(-5, user.getId(), "L'ID devrait pouvoir être défini sur une valeur négative, même si cela n'est pas logique");
    }

    @Test
    public void testAddPortefeuille() {
        User user = new User("Dupont", "Jean");
        Portefeuille portefeuille = new Portefeuille("Portefeuille A", user);
        user.addPortefeuille(portefeuille);

        assertEquals(1, user.getPortefeuilles().size());
        assertEquals("Portefeuille A", user.getPortefeuilles().get(0).getNom());
    }

    @Test
    public void testGetPortefeuilleById() {
        User user = new User("Martin", "Paul");
        Portefeuille portefeuille = new Portefeuille("Portefeuille D", user);
        user.addPortefeuille(portefeuille);

        Portefeuille retrievedPortefeuille = user.getPortefeuilleById(portefeuille.getId());
        assertNotNull(retrievedPortefeuille);
        assertEquals("Portefeuille D", retrievedPortefeuille.getNom());
    }

    @Test
    void testSetId() {
    User user = new User("Nom", "Prenom");
    user.setId(42);

    assertEquals(42, user.getId(), "Le setter de l'ID devrait modifier l'ID");
    }

    @Test
    void testEqualsMemeIdNomDifferents() {
    User user1 = new User("Dupont", "Jean");
    User user2 = new User("Durand", "Paul");
    user2.setId(user1.getId());  // Force même ID

    assertNotEquals(user1, user2, "Deux utilisateurs avec le même ID mais noms/prénoms différents ne doivent pas être égaux");
}



    @Test
    void testUserCreation() {
        User user = new User("Dupont", "Jean");

        assertEquals("Dupont", user.getNom());
        assertEquals("Jean", user.getPrenom());
        assertNotNull(user.getPortefeuilles());
        assertTrue(user.getPortefeuilles().isEmpty());
    }



    @Test
    void testEqualsAvecObjetNonUser() {
    User user = new User("Dupont", "Jean");
    String autreObjet = "NonUserObject";

    assertNotEquals(user, autreObjet, "La méthode equals doit retourner false lorsqu'elle est comparée à un objet d'une autre classe");
    }

    @Test
    void testConstructeurAvecParametresInvalides() {
        assertThrows(NullPointerException.class, () -> new User(null, "Jean"),
        "Le constructeur devrait lancer une exception si le nom est null");
        assertThrows(NullPointerException.class, () -> new User("Dupont", null),
        "Le constructeur devrait lancer une exception si le prénom est null");
    }

    @Test
    void testSetters() {
        User user = new User("Durand", "Paul");

        user.setNom("Martin");
        user.setPrenom("Luc");

        assertEquals("Martin", user.getNom());
        assertEquals("Luc", user.getPrenom());
    }

    @Test
    void testToString() {
        User user = new User("Nom", "Prenom");

        String result = user.toString();

        assertNotNull(result, "The toString method should not return null");
        assertTrue(result.contains("Nom"), "The toString method should include the user's last name");
        assertTrue(result.contains("Prenom"), "The toString method should include the user's first name");
    }

    @Test
    void testEquals() {
        User user1 = new User("Dupont", "Jean");
        User user2 = new User("Dupont", "Jean");
        User user3 = new User("Durand", "Paul");

        assertEquals(user1, user1, "A user should be equal to itself");
        assertNotEquals(user1, user2, "Users with different IDs should not be equal");
        assertNotEquals(user1, user3, "Users with different names and IDs should not be equal");
    }

    @Test
    void testIncrementId() {
    User user1 = new User("Dupont", "Jean");
    User user2 = new User("Durand", "Paul");

    assertTrue(user2.getId() > user1.getId(), "L'ID du deuxième utilisateur doit être supérieur à celui du premier");
}

    @Test
    void testHashCode() {
        User user1 = new User("Dupont", "Jean");
        User user2 = new User("Dupont", "Jean");

        assertNotEquals(user1.hashCode(), user2.hashCode(), "Users with different IDs should have different hash codes");
    }

    @Test
    void testHashCodeAvecObjetsIdentiques() {
    User user = new User("Dupont", "Jean");

    assertEquals(user.hashCode(), user.hashCode(), "Deux références au même objet doivent avoir le même hash code");
}
}
