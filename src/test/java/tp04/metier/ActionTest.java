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
import org.junit.jupiter.api.Test;

/**
 *
 * @author David Navarre &lt;David.Navarre at irit.fr&gt;
 */
class ActionTest {

    @Test
    void testBuidActionWithCorrectLabel_success() {
        Assertions.assertDoesNotThrow(new org.junit.jupiter.api.function.Executable() {
        @Override
        public void execute() throws Throwable {
            // TODO Auto-generated method stub
            new ActionImpl("cc!");
        }
        
    });
  }

  @Test
  void testBuildActionWithIncorrectLabel_failure(){
    Assertions.assertThrows(IllegalArgumentException.class, new org.junit.jupiter.api.function.Executable() {
      @Override
      public void execute() throws Throwable {
        // TODO Auto-generated method stub
        new ActionImpl("");
      }
      
    });
  }

 //action 是一个抽象方法，不能被实体化 即Action action = nwe action；所以要新实体化一个对象ActionImpl
  private static class ActionImpl extends Action {

    public ActionImpl(final String libelle) {
      super(libelle);
    }

    public float valeur(Jour j) {
      return 0.0F;
    }
  }
}
