package fr.epsi.gl.quizz.requete.generate;

import java.util.List;
import java.util.UUID;

import org.jongo.Jongo;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

public class RechercheQuizzs {

	 @Inject
	    public RechercheQuizzs(Jongo jongo) {
	        this.jongo = jongo;
	    }

	    public List<ResumeQuizz> toutes() {
	        return Lists.newArrayList(jongo.getCollection("quizz").find().projection("{_id:1, libellé : 1}").as(ResumeQuizz.class));
	    }

	    public DetailsQuizz detailsDe(UUID id) {
	        return jongo.getCollection("quizz").findOne("{_id:#}", id).as(DetailsQuizz.class);
	    }


	    private Jongo jongo;
}
