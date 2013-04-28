package fr.epsi.gl.quizz.domaine;

import fr.epsi.gl.quizz.domaine.question.EntrepotQuestions;

public abstract class Entrepots {

    public static EntrepotQuestions questions() {
        return instance.entrepotQuestions();
    }

    protected abstract EntrepotQuestions entrepotQuestions();

    public static void setInstance(Entrepots instance) {
        Entrepots.instance = instance;
    }

    private static Entrepots instance;
}
