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

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for User
 * 
 * @version 1.0
 */


class UserTest {

    @Test
    void testUserCreation() {
        User user = new User("Dupont", "Jean");

        assertEquals("Dupont", user.getNom());
        assertEquals("Jean", user.getPrenom());
        assertNotNull(user.getPortefeuilles());
        assertTrue(user.getPortefeuilles().isEmpty());
    }

    @Test
    void testSetters() {
        User user = new User("Durand", "Paul");

        user.setNom("Martin");
        user.setPrenom("Luc");

        assertEquals("Martin", user.getNom());
        assertEquals("Luc", user.getPrenom());
    }

    // @Test
    // void testToString() {
    //     // Arrange
    //     User user = new User("Nom", "Prenom");

    //     // Act
    //     String result = user.toString();

    //     // Assert
    //     assertNotNull(result, "The toString method should not return null");
    // }

    @Test
    void testToString() {
    // Arrange
    User user = new User("Nom", "Prenom");

    // Act
    String result = user.toString();

    // Assert
    assertNotNull(result, "The toString method should not return null");
    assertTrue(result.contains("Nom"), "The toString method should include the user's last name");
    assertTrue(result.contains("Prenom"), "The toString method should include the user's first name");
}


   
}
