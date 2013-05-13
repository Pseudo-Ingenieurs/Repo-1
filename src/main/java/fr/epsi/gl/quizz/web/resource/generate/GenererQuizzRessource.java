package fr.epsi.gl.quizz.web.resource.generate;

import javax.inject.Inject;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
import fr.epsi.gl.quizz.commande.BusCommande;
import fr.epsi.gl.quizz.requete.question.RechercheQuestions;
import fr.epsi.gl.quizz.web.representation.ModeleEtVue;

public class GenererQuizzRessource extends ServerResource{
	
	 @Inject
	    public GenererQuizzRessource(BusCommande busCommande, RechercheQuestions recherche) {
	        this.busCommande = busCommande;
	        this.recherche = recherche;
	 } 
	 

	 @Get
	    public ModeleEtVue représente() {
	        return ModeleEtVue.crée("/generation-quizz/generer-quizz").avec("questions", recherche.toutes());
	    }
	 

	 private BusCommande busCommande;
	 private RechercheQuestions recherche;
}
