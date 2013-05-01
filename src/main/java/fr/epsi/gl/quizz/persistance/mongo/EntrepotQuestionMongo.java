package fr.epsi.gl.quizz.persistance.mongo;

import com.google.common.base.Optional;
import fr.epsi.gl.quizz.commande.FournisseurMongoSession;
import fr.epsi.gl.quizz.domaine.question.EntrepotQuestions;
import fr.epsi.gl.quizz.domaine.question.Question;
import org.mongolink.MongoSession;

public class EntrepotQuestionMongo implements EntrepotQuestions {
    public EntrepotQuestionMongo(FournisseurMongoSession fournisseur) {
        this.fournisseur = fournisseur;
    }

    public Optional<Question> get(Object id) {
        MongoSession session = fournisseur.get();
        return Optional.fromNullable(session.get(id, Question.class));
    }

    public Question ajoute(Question aggregat) {
        fournisseur.get().save(aggregat);
        return aggregat;
    }

    public void supprime(Question aggregat) {
        fournisseur.get().delete(aggregat);
    }

    private FournisseurMongoSession fournisseur;
}
