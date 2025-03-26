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

import java.util.Objects;

public class Option {

    // Attribut
    private static int uid =0;
    private int numOption;
    private String nomOption;

    // Constructor
    public Option (String nomOption, Menu menu){
        uid ++;
		this.numOption = uid;
		this.nomOption = nomOption;
        menu.ajouterOption(this);
    }

    // Réinitialiser le uid pour chaque option
    public static void resetUid() {
        uid = 0;
    }

    // getter & setter 
    public int getNumOption() {
        return this.numOption;
    }
    public void setNumOption(int numOption) {
        this.numOption = numOption;
    }
    public String getNomOption() {
        return this.nomOption;
    }
    public void setNomOption(String nomOption) {
        this.nomOption = nomOption;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Option{");
        sb.append("numOption=").append(numOption);
        sb.append(", nomOption=").append(nomOption);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Option option = (Option) o;
        return numOption == option.numOption &&
                Objects.equals(nomOption, option.nomOption);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numOption, nomOption);
    }
    
    
}
