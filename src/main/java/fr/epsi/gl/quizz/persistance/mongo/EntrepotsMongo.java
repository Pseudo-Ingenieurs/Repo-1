package fr.epsi.gl.quizz.persistance.mongo;

import com.google.inject.Inject;
import fr.epsi.gl.quizz.commande.FournisseurMongoSession;
import fr.epsi.gl.quizz.domaine.Entrepots;
import fr.epsi.gl.quizz.domaine.question.EntrepotQuestions;

public class EntrepotsMongo extends Entrepots {

    @Inject
    public EntrepotsMongo(FournisseurMongoSession fournisseur) {
        this.fournisseur = fournisseur;
    }

    @Override
    protected EntrepotQuestions entrepotQuestions() {
        return new EntrepotQuestionMongo(fournisseur);
    }

    private FournisseurMongoSession fournisseur;
}
