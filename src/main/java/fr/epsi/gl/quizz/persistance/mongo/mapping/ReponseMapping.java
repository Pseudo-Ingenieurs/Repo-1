package fr.epsi.gl.quizz.persistance.mongo.mapping;

import fr.epsi.gl.quizz.domaine.question.Reponse;
import org.mongolink.domain.mapper.ComponentMap;

public class ReponseMapping extends ComponentMap<Reponse> {

    public ReponseMapping() {
        super(Reponse.class);
    }

    @Override
    protected void map() {
        property(element().getLibellé());
        property(element().isCorrecte());
    }
}
