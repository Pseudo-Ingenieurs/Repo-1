package fr.epsi.gl.quizz.persistance.fake;

import java.util.List;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;

import fr.epsi.gl.quizz.domaine.generate.EntrepotQuizzs;
import fr.epsi.gl.quizz.domaine.generate.Quizz;

public class FakeEntrepotQuizzs implements EntrepotQuizzs{

	public Optional<Quizz> get(Object id) {
		 for (Quizz quizz : quizzs) {
	            if(quizz.getId().equals(id)) {
	                return Optional.of(quizz);
	            }
	        }
	        return Optional.absent();
	}

	public Quizz ajoute(Quizz aggregat) {
		quizzs.add(aggregat);
		return aggregat;
	}

	public void supprime(Quizz aggregat) {
		quizzs.remove(aggregat);
		
	}

	private List<Quizz> quizzs = Lists.newArrayList();
}
