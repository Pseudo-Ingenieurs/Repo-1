package fr.epsi.gl.quizz.persistance.mongo;

import org.mongolink.MongoSession;

import com.google.common.base.Optional;

import fr.epsi.gl.quizz.commande.FournisseurMongoSession;
import fr.epsi.gl.quizz.domaine.user.EntrepotUsers;
import fr.epsi.gl.quizz.domaine.user.User;

public class EntrepotUserMongo implements EntrepotUsers {
	
    private FournisseurMongoSession fournisseur;

    public EntrepotUserMongo(FournisseurMongoSession fournisseur) {
        this.fournisseur = fournisseur;
    }
    
	public Optional<User> get(Object id) {
		MongoSession session = fournisseur.get();
        return Optional.fromNullable(session.get(id, User.class));
	}

	public User ajoute(User aggregat) {
		  fournisseur.get().save(aggregat);
	        return aggregat;
	}

	public void supprime(User aggregat) {
        fournisseur.get().delete(aggregat);		
	}

}
