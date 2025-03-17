package tp04.metier;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MenuTest {

    @Test
    void testCreateMenuWithCorrectParameters() {
        Assertions.assertDoesNotThrow(new org.junit.jupiter.api.function.Executable() {
        @Override
        public void execute() throws Throwable {
            // TODO Auto-generated method stub
            Menu menu = new Menu();
            Option option = new Option("Test", menu);
            Assertions.assertEquals("Test", menu.getListeOptions().get(0).getNomOption());
        }
        
    });
  }
    
}
