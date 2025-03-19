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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class OptionTest {

    private Menu menu;

    // avant chaque test, on réinitialise le uid pour que numOption commence à 1
    @BeforeEach
    void setUp() {
        Option.resetUid();
        menu = new Menu();
    }

    // test pour vérifier la méthodes set et get de numOption
    @Test
    void testGetSetNumOption() {
        Option option = new Option("Option1", menu);
        option.setNumOption(5);
        Assertions.assertEquals(5, option.getNumOption());
    }

    // test pour vérifier la méthodes set et get de nomOption
    @Test
    void testGetSetNomOption() {
        Option option = new Option("Option1", menu);
        option.setNomOption("NewOption");
        Assertions.assertEquals("NewOption", option.getNomOption());
    }

    // test le bon fonctionnement de la méthode toString
    @Test
    void testToString() {
        Option option = new Option("Option1", menu);
        String expected = "Option{numOption=1, nomOption=Option1}";
        Assertions.assertEquals(expected, option.toString());
    }

    // test le bon fonctionnement des méthodes Hashcode (entre les différents objets)
    @Test
    void testHashCodeDifferentObjects() {
        Option option1 = new Option("Option1", menu);
        Option option2 = new Option("Option1", menu);
        Assertions.assertNotEquals(option1.hashCode(), option2.hashCode(), "Hashcodes should differ because numOption differs");
    }

    // test le bon fonctionnement des méthodes Hashcode (entre les mêmes objets)
    @Test
    void testHashCodeEqualObjects() {
        Option option1 = new Option("Option1", menu);
        Option option2 = new Option("Option1", menu);
        // Manually synchronize numOption to test equality
        option2.setNumOption(option1.getNumOption());
        Assertions.assertEquals(option1.hashCode(), option2.hashCode(), "Hashcodes should be equal");
    }

    // test le bon fonctionnement des méthodes Eaquals (entre les mêmes références)
    @Test
    void testEqualsSameReference() {
        Option option1 = new Option("Option1", menu);
        Assertions.assertEquals(option1, option1);
    }

    // test le bon fonctionnement des méthodes Eaquals (entre les différents références)
    @Test
    void testEqualsDifferentObjectsSameData() {
        Option option1 = new Option("Option1", menu);
        Option option2 = new Option("Option1", menu);

        // Same nomOption, but numOption differs => not equal
        Assertions.assertNotEquals(option1, option2);

        // Now align numOption to make them logically equal
        option2.setNumOption(option1.getNumOption());

        Assertions.assertEquals(option1, option2);
    }

}