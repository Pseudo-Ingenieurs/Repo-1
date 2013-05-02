package fr.epsi.gl.quizz.persistance.mongo.mapping;

import org.mongolink.domain.mapper.AggregateMap;

import fr.epsi.gl.quizz.domaine.generate.Quizz;

@SuppressWarnings("UnusedDeclaration")
public class QuizzMapping extends AggregateMap<Quizz>{

	public QuizzMapping() {
		super(Quizz.class);
	}

	@Override
	protected void map() {
		id(element().getId()).natural();
		property(element().getLibellé());
		collection(element().getQuestions());		
	}
	

}
