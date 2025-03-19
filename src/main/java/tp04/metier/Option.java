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
    private static int uid =0;
    private int numOption;
    private String nomOption;

    public Option (String nomOption, Menu menu){
        uid += 1;
		this.numOption = uid;
		this.nomOption = nomOption;
        menu.ajouterOption(this);
    }

    public int getNumOption() {
        return numOption;
    }

    public void setNumOption(int numOption) {
        this.numOption = numOption;
    }

    public String getNomOption() {
        return nomOption;
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
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.numOption;
        hash = 13 * hash + Objects.hashCode(this.nomOption);
        return hash;
    }
    
    
}
