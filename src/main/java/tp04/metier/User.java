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
import java.util.List;

public class User {

    private String nom;
    private String prenom;
    private int id;
    private static int idCounter = 0;
    private List<Portefeuille> portefeuilles;

    public User(String nom, String prenom) {
        if (nom == null) {
            throw new NullPointerException("Le nom ne peut pas être null");
        }
        if (prenom == null) {
            throw new NullPointerException("Le prénom ne peut pas être null");
        }
        idCounter++;
        this.nom = nom;
        this.id = idCounter;
        this.prenom = prenom;
        this.portefeuilles = new ArrayList<>();
    }



    public String getNom() {
        return nom;
    }
    public int getId() {
        return id;
    }
    
    public String getPrenom() {
        return prenom;
    }
    public List<Portefeuille> getPortefeuilles() {
        return portefeuilles;
    }

    public void setNom(String nom) {
        if (nom == null) {
            throw new NullPointerException("Le nom ne peut pas être null");
        }
        this.nom = nom;
    }
    
    public void setPrenom(String prenom) {
        if (prenom == null) {
            throw new NullPointerException("Le prénom ne peut pas être null");
        }
        this.prenom = prenom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPortefeuilles(List<Portefeuille> portefeuilles) {
        this.portefeuilles = portefeuilles;
    }

    @Override
    public String toString() {
        return "User{nom='" + nom + "', prenom='" + prenom + "', portefeuilles=" + portefeuilles.size() + "id=" + id +  "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
               nom.equals(user.nom) &&
               prenom.equals(user.prenom);
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(id);
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        return result;
    }

    public void addPortefeuille(Portefeuille portefeuille) {
        if (portefeuille == null) {
            throw new IllegalArgumentException("Le portefeuille ne peut pas être null");
        }
        portefeuilles.add(portefeuille);
    }

    public Portefeuille getPortefeuilleById(int id) {
        for (Portefeuille portefeuille : portefeuilles) {
            if (portefeuille.getId() == id) {
                return portefeuille;
            }
        }
        return null; // Retourne null si aucun portefeuille avec cet ID n'est trouvé
    }
}

