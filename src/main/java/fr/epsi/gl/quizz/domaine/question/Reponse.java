package fr.epsi.gl.quizz.domaine.question;

public class Reponse {

    public static Reponse fausse(String libellé) {
        Reponse résultat = new Reponse();
        résultat.libellé = libellé;
        résultat.correcte = false;
        return résultat;
    }

    public static Reponse juste(String libellé) {
        Reponse reponse = new Reponse();
        reponse.libellé = libellé;
        reponse.correcte = true;
        return reponse;
    }

    protected Reponse() {

    }

    public String getLibellé() {
        return libellé;
    }

    public boolean isCorrecte() {
        return correcte;
    }

    private String libellé;
    private boolean correcte;
}
