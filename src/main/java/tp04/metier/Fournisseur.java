package tp04.metier;

import java.util.ArrayList;

public class Fournisseur {
    private static ArrayList<Action> actionPropose = new ArrayList<>();

    public static ArrayList<Action> getActionPropose () {
        return actionPropose;
    }

    public static void getAllAction (Jour jour) {
        for (int i=0; i< actionPropose.size(); i++) {
            System.out.println(i + ": " + actionPropose.get(i).toString() + " valeur: " + actionPropose.get(i).valeur(jour));
        }
    }

    public static Action getActionInList (int index) {
        return actionPropose.get(index);
    }

    public static void addAction (Action action) {
        actionPropose.add(action);
    }

}
