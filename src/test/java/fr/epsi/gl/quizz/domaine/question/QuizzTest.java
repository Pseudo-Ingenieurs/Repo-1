package fr.epsi.gl.quizz.domaine.question;


import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

import static org.fest.assertions.Assertions.assertThat;

import fr.epsi.gl.quizz.domaine.generate.FabriqueQuizzs;
import fr.epsi.gl.quizz.domaine.generate.Quizz;

public class QuizzTest {
	
	 List<Question> questions = Lists.newArrayList();

	
	@Test
	public void peutDonnerUnId(){
		Quizz q = unQuizz();
		
		assertThat(q).isNotNull();
		assertThat(q.getId()).isNotNull();
		
	}

	@Test
	public void peutDonnerUnLibelle(){
		
		Quizz q = new FabriqueQuizzs().nouveau("toto",questions);
		assertThat(q.getLibellé()).isEqualTo("toto");
	}
	
	
	private Quizz unQuizz() {
		return new FabriqueQuizzs().nouveau("test quizz",questions);
	}
}
