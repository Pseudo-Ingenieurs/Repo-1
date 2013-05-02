package fr.epsi.gl.quizz.commande.generate;

import fr.epsi.gl.quizz.commande.Message;

public class CreationQuizzMessage implements Message{

	 public final String libellé;
	  
	public CreationQuizzMessage(String libellé) {
	        this.libellé = libellé;
	 }
	  
}
