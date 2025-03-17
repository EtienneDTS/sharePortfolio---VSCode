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

    @BeforeEach
    void setUp() {
        menu = new Menu();
    }

    @Test
    void testGetSetNumOption() {
        Option option = new Option("Option1", menu);
        option.setNumOption(5);
        Assertions.assertEquals(5, option.getNumOption());
    }

    @Test
    void testGetSetNomOption() {
        Option option = new Option("Option1", menu);
        option.setNomOption("NewOption");
        Assertions.assertEquals("NewOption", option.getNomOption());
    }

    @Test
    void testToString() {
        Option option = new Option("Option1", menu);
        String expected = "Option{numOption="+option.getNumOption()+", nomOption=Option1}";
        Assertions.assertEquals(expected, option.toString());
    }

    @Test
    void testHashCode() {
        Option option1 = new Option("Option1", menu);
        Option option2 = new Option("Option1", menu);
        Assertions.assertNotEquals(option1.hashCode(), option2.hashCode());
    }

    @Test
    void testEquals() {
        Option option1 = new Option("Option1", menu);
        Option option2 = new Option("Option1", menu);
        Option option3 = new Option("Option2", menu);
        Assertions.assertNotEquals(option1, option2);
        Assertions.assertNotEquals(option1, option3);
        Assertions.assertEquals(option1, option1);
    }
}