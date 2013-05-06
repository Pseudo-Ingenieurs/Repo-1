package fr.epsi.gl.quizz.domaine.generate;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.UUID;

public class FabriqueQuizzs {

	public Quizz nouveau(String libellé){
		checkNotNull(libellé);
        Quizz quizz = new Quizz(UUID.randomUUID());
        quizz.setLibellé(libellé);
        return quizz;
	}
}

