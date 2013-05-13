package fr.epsi.gl.quizz.web.resource.generate;


import java.util.UUID;
import org.restlet.resource.Get;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import com.google.inject.Inject;

import fr.epsi.gl.quizz.commande.BusCommande;
import fr.epsi.gl.quizz.domaine.question.Question;
import fr.epsi.gl.quizz.requete.generate.DetailsQuizz;
import fr.epsi.gl.quizz.requete.generate.RechercheQuizzs;
import fr.epsi.gl.quizz.web.representation.ModeleEtVue;

public class QuizzRessource extends ServerResource{
	Question question = null;

	@Inject
	public QuizzRessource(RechercheQuizzs recherche, BusCommande bus) {
		this.recherche = recherche;
		this.bus = bus;
	}

	@Override
	protected void doInit() throws ResourceException {
		UUID id = UUID.fromString(getRequestAttributes().get("id").toString());
		quizz = recherche.detailsDe(id);
	}
	
	@Get
	public ModeleEtVue représente() {
		return ModeleEtVue.crée("/generation-quizz/quizz").avec("quizz", quizz);
	}


	private DetailsQuizz quizz;
	private RechercheQuizzs recherche;
	private BusCommande bus;
}
