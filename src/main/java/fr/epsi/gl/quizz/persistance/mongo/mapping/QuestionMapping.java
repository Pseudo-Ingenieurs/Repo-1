package fr.epsi.gl.quizz.persistance.mongo.mapping;

import fr.epsi.gl.quizz.domaine.question.Question;
import org.mongolink.domain.mapper.AggregateMap;

@SuppressWarnings("UnusedDeclaration")
public class QuestionMapping extends AggregateMap<Question> {

    public QuestionMapping() {
        super(Question.class);
    }

    @Override
    protected void map() {
        id(element().getId()).natural();
        property(element().getLibellé());
        collection(element().getRéponses());
    }
}
