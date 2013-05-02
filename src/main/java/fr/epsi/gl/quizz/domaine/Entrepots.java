package fr.epsi.gl.quizz.domaine;

import fr.epsi.gl.quizz.domaine.generate.EntrepotQuizzs;
import fr.epsi.gl.quizz.domaine.question.EntrepotQuestions;

public abstract class Entrepots {

    public static EntrepotQuestions questions() {
        return instance.entrepotQuestions();
    }
    
    public static EntrepotQuizzs quizzs() {
        return instance.entrepotQuizzs();
    }
    
    public static void setInstance(Entrepots instance) {
        Entrepots.instance = instance;
    }
    
    protected abstract EntrepotQuestions entrepotQuestions();
    
    protected abstract EntrepotQuizzs entrepotQuizzs();
    
    private static Entrepots instance;
}
