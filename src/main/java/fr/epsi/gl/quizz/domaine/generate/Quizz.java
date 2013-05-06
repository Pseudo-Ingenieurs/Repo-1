package fr.epsi.gl.quizz.domaine.generate;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import com.google.common.collect.Lists;

import fr.epsi.gl.quizz.domaine.Aggregat;
import fr.epsi.gl.quizz.domaine.question.Question;

public class Quizz implements Aggregat{

    private List<Question> questions = Lists.newArrayList();
    private String libellé;
	private UUID id;
	
	@SuppressWarnings("UnusedDeclaration")
	protected Quizz() {
		 
	}
	Quizz(UUID id){
		this.id=id;		
	}
	
	public UUID getId() {
		return id;
	}
	
	public String getLibellé() {
	        return libellé;
	}
	
	public List<Question> getQuestions() {
        return Collections.unmodifiableList(questions);
    }

	public void setLibellé(String libellé) {
		this.libellé = libellé;		
	}
				
		
}

