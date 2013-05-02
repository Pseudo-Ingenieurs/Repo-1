package fr.epsi.gl.quizz.web.resource.generate;


import java.util.UUID;

import javax.inject.Inject;

import org.restlet.data.Form;
import org.restlet.data.Status;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

import fr.epsi.gl.quizz.commande.BusCommande;
import fr.epsi.gl.quizz.commande.generate.CreationQuizzMessage;
import fr.epsi.gl.quizz.requete.generate.RechercheQuizzs;
import fr.epsi.gl.quizz.web.representation.ModeleEtVue;

public class QuizzsRessource extends ServerResource{


	@Inject
	public QuizzsRessource(BusCommande busCommande, RechercheQuizzs recherche) {
		this.busCommande = busCommande;
		this.recherche = recherche;
	}

	@Get
	public ModeleEtVue représente() {
		return ModeleEtVue.crée("/generation-quizz/quizzs").avec("quizzs",recherche.toutes());
	}
	
	private BusCommande busCommande;
	
	private RechercheQuizzs recherche;
}
