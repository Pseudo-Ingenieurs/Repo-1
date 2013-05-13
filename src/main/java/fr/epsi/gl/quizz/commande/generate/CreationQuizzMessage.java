package fr.epsi.gl.quizz.commande.generate;

import java.util.List;

import com.google.common.collect.Lists;

import fr.epsi.gl.quizz.commande.Message;
import fr.epsi.gl.quizz.domaine.question.Question;

public class CreationQuizzMessage implements Message{

	 public final String libellé;
	 public List<Question> questions = Lists.newArrayList();
	 
	public CreationQuizzMessage(String libellé,List<Question> questions) {
	        this.libellé = libellé;
	        this.questions=questions;
	 }
	  
}
