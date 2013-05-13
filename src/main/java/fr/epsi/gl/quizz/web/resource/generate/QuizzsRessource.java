package fr.epsi.gl.quizz.web.resource.generate;


import java.util.ArrayList;
import java.util.Iterator;
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
import fr.epsi.gl.quizz.requete.generate.RechercheQuizzs;
import fr.epsi.gl.quizz.requete.question.DetailsQuestion;
import fr.epsi.gl.quizz.requete.question.DetailsReponse;
import fr.epsi.gl.quizz.requete.question.RechercheQuestions;
import fr.epsi.gl.quizz.requete.question.ResumeQuestion;
import fr.epsi.gl.quizz.web.representation.ModeleEtVue;

public class QuizzsRessource extends ServerResource{

	public List<Question> questions = Lists.newArrayList();
	public String ids;
	public Question question = null;
	public ResumeQuestion resumeQuestion = null;
	public List<ResumeQuestion> allQuestion = new ArrayList<ResumeQuestion>();
	public DetailsQuestion detailsQuestion = null;
	
	@Inject
	public QuizzsRessource(BusCommande busCommande, RechercheQuizzs recherche, RechercheQuestions rech) {
		this.busCommande = busCommande;
		this.recherche = recherche;
		this.rechercheQuestions = rech;
	}

	@Get
	public ModeleEtVue représente() {
		return ModeleEtVue.crée("/generation-quizz/quizzs").avec("quizzs",recherche.toutes());
	}

	@Post
	public void crée(Form formulaire) {

		String[] tab = formulaire.getValuesArray("aquestion"); 

		allQuestion = rechercheQuestions.toutes();	
		
		for (String strId : tab) {
			UUID id = UUID.fromString(strId.toString());
			for (Iterator<ResumeQuestion> iterator = allQuestion.iterator(); iterator.hasNext();) {
				ResumeQuestion rq = (ResumeQuestion) iterator
						.next();
				if(rq.getId().equals(strId)){
					resumeQuestion = rq;
				}
			}
			question = new Question(id);
			question.setLibellé(resumeQuestion.getLibellé());
			detailsQuestion = rechercheQuestions.detailsDe(id);
			for (Iterator<DetailsReponse> iterator = detailsQuestion.getRéponses().iterator(); iterator
					.hasNext();) {
				DetailsReponse reponse = (DetailsReponse) iterator.next();
				ajouterReponse(reponse, question);
			}
			
			questions.add(question);
		}
		
		CreationQuizzMessage commande = new CreationQuizzMessage(formulaire.getFirstValue("libelle"),questions);
		ListenableFuture<UUID> idQuizz = busCommande.envoie(commande);
		setStatus(Status.SUCCESS_ACCEPTED);
		setLocationRef("/quizzs/" + Futures.getUnchecked(idQuizz));
	}
	
	private void ajouterReponse(DetailsReponse reponse, Question question){
		if(reponse.isCorrecte()){
			question.ajouteRéponseJuste(reponse.getLibellé());
		}
		else{
			question.ajouteRéponseFausse(reponse.getLibellé());
		}
	}
	private BusCommande busCommande;

	private RechercheQuizzs recherche;
	private RechercheQuestions rechercheQuestions;
}
