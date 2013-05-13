package fr.epsi.gl.quizz.persistance.mongo;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mongolink.MongoSession;
import org.mongolink.test.MongolinkRule;

import fr.epsi.gl.quizz.commande.FournisseurMongoSession;

import fr.epsi.gl.quizz.domaine.user.FabriqueUser;
import fr.epsi.gl.quizz.domaine.user.User;

public class EntrepotUserMongoTest {
	 @Rule
	 public MongolinkRule mongolinkRule = MongolinkRule.withPackage("fr.epsi.gl.quizz.persistance.mongo.mapping");
	 private EntrepotUserMongo entrepot;
	 
	 @Before
	    public void setUp()  {
	        entrepot = new EntrepotUserMongo(new FournisseurMongoSession() {
	         
	            public MongoSession get() {
	                return mongolinkRule.getCurrentSession();
	            }

	            
	            public void nettoie() {

	            }
	        });
	    }
	    
	    @Test
	    public void peutAjouterUnUser() {   
	    	
	        /*User user = new FabriqueUser().nouveau("test", "nnn");

	        entrepot.ajoute(user);
	        mongolinkRule.cleanSession();

	        User userTrouvé = entrepot.get(user.getId()).orNull();
	        assertThat(userTrouvé).isNotNull();
	        assertThat(userTrouvé.getLogin()).isEqualTo("test");
	        //assertThat(userTrouvé.getMotdepasse()).isEqualTo("nnn");*/

	    }
}
