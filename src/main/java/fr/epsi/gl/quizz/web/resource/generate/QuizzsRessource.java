package fr.epsi.gl.quizz.web.resource.generate;


import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import org.restlet.data.Form;

import org.restlet.data.Status;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

import fr.epsi.gl.quizz.commande.BusCommande;
import fr.epsi.gl.quizz.commande.generate.CreationQuizzMessage;
import fr.epsi.gl.quizz.domaine.question.Question;
import fr.epsi.gl.quizz.requete.generate.DetailsQuizz;
import fr.epsi.gl.quizz.requete.generate.RechercheQuizzs;
import fr.epsi.gl.quizz.requete.question.DetailsQuestion;
import fr.epsi.gl.quizz.requete.question.RechercheQuestions;
import fr.epsi.gl.quizz.web.representation.ModeleEtVue;

public class QuizzsRessource extends ServerResource{

	public List<DetailsQuestion> questions = Lists.newArrayList();
	public String ids;

	@Inject
	public QuizzsRessource(BusCommande busCommande, RechercheQuestions recherche) {
		this.busCommande = busCommande;
		this.recherche = recherche;
	}

	@Get
	public ModeleEtVue représente() {
		return ModeleEtVue.crée("/generation-quizz/quizzs").avec("quizzs",recherche.toutes());
	}

	@Post
	public void crée(Form formulaire) {

		String[] tab = formulaire.getValuesArray("aquestion"); 
		
		for (String string : tab) {
			UUID id = UUID.fromString(string.toString());
			question = recherche.detailsDe(id);			
			questions.add(question);
		}
		
		for(DetailsQuestion ab : questions){
			System.out.println(ab.getLibellé()+"\n\n");
			
		}
		
		CreationQuizzMessage commande = new CreationQuizzMessage(formulaire.getFirstValue("libelle"),questions);
		ListenableFuture<UUID> idQuizz = busCommande.envoie(commande);
		setStatus(Status.SUCCESS_ACCEPTED);
		setLocationRef("/quizzs/" + Futures.getUnchecked(idQuizz));
	}
	private BusCommande busCommande;
	private DetailsQuestion question;
	private RechercheQuestions recherche;
}
