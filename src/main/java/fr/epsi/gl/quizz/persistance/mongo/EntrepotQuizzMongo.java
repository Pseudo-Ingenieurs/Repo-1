package fr.epsi.gl.quizz.persistance.mongo;

import org.mongolink.MongoSession;

import com.google.common.base.Optional;

import fr.epsi.gl.quizz.commande.FournisseurMongoSession;
import fr.epsi.gl.quizz.domaine.generate.EntrepotQuizzs;
import fr.epsi.gl.quizz.domaine.generate.Quizz;


public class EntrepotQuizzMongo implements EntrepotQuizzs{

	public EntrepotQuizzMongo(FournisseurMongoSession fournisseur){
		this.fournisseur = fournisseur;		
	}
		
	public Optional<Quizz> get(Object id) {
		 MongoSession session = fournisseur.get();
	     return Optional.fromNullable(session.get(id, Quizz.class));
	}

	public Quizz ajoute(Quizz aggregat) {
		fournisseur.get().save(aggregat);
        return aggregat;
	}

	public void supprime(Quizz aggregat) {
		fournisseur.get().delete(aggregat);		
	}
	
	private FournisseurMongoSession fournisseur;
	
}
