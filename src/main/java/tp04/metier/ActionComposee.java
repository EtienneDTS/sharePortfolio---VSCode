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

import java.util.HashMap;
import java.util.Map;

public class ActionComposee extends Action {

    private Map<ActionSimple, Float> mapPanier;

    public ActionComposee(String libelle) {
        super(libelle);
        this.mapPanier = new HashMap<>();
    }

    public void enrgComposition(ActionSimple actionSimple1, float pourcentage) {
        mapPanier.put(actionSimple1, pourcentage);
    }

    @Override
    public float valeur(Jour j) {
        float valeur = 0;
        for (Map.Entry<ActionSimple, Float> entry : mapPanier.entrySet()) {
            ActionSimple actionSimple = entry.getKey();
            Float pourcentage = entry.getValue();
            valeur += actionSimple.valeur(j) * pourcentage;
        }
        return valeur;
    }
}
