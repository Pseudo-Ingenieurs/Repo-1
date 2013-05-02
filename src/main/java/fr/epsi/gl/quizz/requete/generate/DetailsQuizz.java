package fr.epsi.gl.quizz.requete.generate;

import java.util.List;

import org.jongo.marshall.jackson.oid.Id;

import com.google.common.collect.Lists;

import fr.epsi.gl.quizz.requete.question.DetailsQuestion;

public class DetailsQuizz {
	
	   public String getLibellé() {
	        return libellé;
	    }

	    public void setLibellé(String libellé) {
	        this.libellé = libellé;
	    }

	    public String getId() {
	        return id;
	    }

	    public void setId(String id) {
	        this.id = id;
	    }

	    public List<DetailsQuestion> getQuestions() {
	        return questions;
	    }

	    public void setQuestions(List<DetailsQuestion> questions) {
	        this.questions = questions;
	    }

	    private String libellé;
	    @Id
	    private String id;

	    private List<DetailsQuestion> questions = Lists.newArrayList();
}
