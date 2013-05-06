package fr.epsi.gl.quizz.domaine.generate;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;
import java.util.UUID;

import fr.epsi.gl.quizz.requete.question.DetailsQuestion;

public class FabriqueQuizzs {

	public Quizz nouveau(String libellé, List<DetailsQuestion> questions){
		checkNotNull(libellé);
        Quizz quizz = new Quizz(UUID.randomUUID());
        quizz.setLibellé(libellé);
        quizz.setQuestions(questions);
        return quizz;
	}
}

