package fr.epsi.gl.quizz.commande.generate;

import java.util.List;

import com.google.common.collect.Lists;

import fr.epsi.gl.quizz.commande.Message;
import fr.epsi.gl.quizz.domaine.question.Question;
import fr.epsi.gl.quizz.requete.question.DetailsQuestion;

public class CreationQuizzMessage implements Message{

	 public final String libellé;
	 public List<DetailsQuestion> questions = Lists.newArrayList();
	 
	public CreationQuizzMessage(String libellé,List<DetailsQuestion> questions2) {
	        this.libellé = libellé;
	        this.questions=questions2;
	 }
	  
}
