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

public class Fournisseur {
    private static ArrayList<Action> actionPropose = new ArrayList<>();

    public static ArrayList<Action> getActionPropose () {
        return actionPropose;
    }

    public static void getAllAction(Jour jour) {
        for (Action action : actionPropose) {
            if (action != null) {
                System.out.println(action.toString());
            } else {
                System.out.println("Action null détectée !");
            }
        }
    }
    

    public static Action getActionInList (int index) {
        return actionPropose.get(index);
    }

    public static void addAction (Action action) {
        actionPropose.add(action);
    }

}
