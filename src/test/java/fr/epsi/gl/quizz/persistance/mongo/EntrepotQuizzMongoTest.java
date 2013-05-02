package fr.epsi.gl.quizz.persistance.mongo;

import static org.fest.assertions.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mongolink.MongoSession;
import org.mongolink.test.MongolinkRule;

import com.google.common.collect.Lists;

import fr.epsi.gl.quizz.commande.FournisseurMongoSession;
import fr.epsi.gl.quizz.domaine.generate.FabriqueQuizzs;
import fr.epsi.gl.quizz.domaine.generate.Quizz;
import fr.epsi.gl.quizz.domaine.question.Question;

public class EntrepotQuizzMongoTest {

	 @Rule
	 public MongolinkRule mongolinkRule = MongolinkRule.withPackage("fr.epsi.gl.quizz.persistance.mongo.mapping");
	 
	 private EntrepotQuizzMongo entrepot;
	 List<Question> questions = Lists.newArrayList();
	 
	    @Before
	    public void setUp()  {
	        entrepot = new EntrepotQuizzMongo(new FournisseurMongoSession() {
	         
	            public MongoSession get() {
	                return mongolinkRule.getCurrentSession();
	            }

	            
	            public void nettoie() {

	            }
	        });
	    }
	    
	    @Test
	    public void peutAjouterUnQuizz() {

	    	
	        Quizz quizz = new FabriqueQuizzs().nouveau("test");

	        entrepot.ajoute(quizz);
	        mongolinkRule.cleanSession();

	        Quizz quizzTrouvée = entrepot.get(quizz.getId()).orNull();
	        assertThat(quizzTrouvée).isNotNull();
	        assertThat(quizzTrouvée.getLibellé()).isEqualTo("test");
	    }
	    
}
