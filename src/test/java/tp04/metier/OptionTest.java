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
    void testOptionConstructor() {
        Option option = new Option("Option1", menu);
        Assertions.assertEquals(1, option.getNumOption());
        Assertions.assertEquals("Option1", option.getNomOption());
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
        String expected = "Option{numOption=1, nomOption=Option1}";
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