package fr.epsi.gl.quizz.persistance.mongo;

import com.google.inject.Inject;
import fr.epsi.gl.quizz.commande.FournisseurMongoSession;
import fr.epsi.gl.quizz.domaine.Entrepots;
import fr.epsi.gl.quizz.domaine.generate.EntrepotQuizzs;
import fr.epsi.gl.quizz.domaine.question.EntrepotQuestions;
import fr.epsi.gl.quizz.domaine.user.EntrepotUsers;

public class EntrepotsMongo extends Entrepots {

    @Inject
    public EntrepotsMongo(FournisseurMongoSession fournisseur) {
        this.fournisseur = fournisseur;
    }

    @Override
    protected EntrepotQuestions entrepotQuestions() {
        return new EntrepotQuestionMongo(fournisseur);
    }

    @Override
    protected EntrepotQuizzs entrepotQuizzs(){
    	return new EntrepotQuizzMongo(fournisseur);
    }
    
    @Override 
    protected EntrepotUsers entrepotUsers(){
    	return new EntrepotUserMongo(fournisseur);
    }
    private FournisseurMongoSession fournisseur;
}
