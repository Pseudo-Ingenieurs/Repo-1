package fr.epsi.gl.quizz.persistance.fake;

import fr.epsi.gl.quizz.domaine.Entrepots;
import fr.epsi.gl.quizz.domaine.generate.EntrepotQuizzs;
import fr.epsi.gl.quizz.domaine.question.EntrepotQuestions;
import fr.epsi.gl.quizz.domaine.user.EntrepotUsers;

public class FakeEntrepots extends Entrepots{
	
    @Override
    protected EntrepotQuestions entrepotQuestions() {
        return entrepotQuestions;
    }
    
	@Override
	protected EntrepotQuizzs entrepotQuizzs() {
	
		return entrepotQuizzs;
	}
	
	@Override
	protected EntrepotUsers entrepotUsers(){
		return entrepotUsers;
	}
    private EntrepotQuestions entrepotQuestions = new FakeEntrepotQuestions();
    private EntrepotQuizzs entrepotQuizzs = new FakeEntrepotQuizzs();
    private EntrepotUsers entrepotUsers = new FakeEntrepotUsers();

}
