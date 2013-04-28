package fr.epsi.gl.quizz.persistance.fake;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import fr.epsi.gl.quizz.domaine.question.EntrepotQuestions;
import fr.epsi.gl.quizz.domaine.question.Question;

import java.util.List;

public class FakeEntrepotQuestions implements EntrepotQuestions {
    @Override
    public Optional<Question> get(Object id) {
        for (Question question : questions) {
            if(question.getId().equals(id)) {
                return Optional.of(question);
            }
        }
        return Optional.absent();
    }

    @Override
    public Question ajoute(Question aggregat) {
        questions.add(aggregat);
        return aggregat;
    }

    @Override
    public void supprime(Question aggregat) {
        questions.remove(aggregat);
    }

    private List<Question> questions = Lists.newArrayList();
}
