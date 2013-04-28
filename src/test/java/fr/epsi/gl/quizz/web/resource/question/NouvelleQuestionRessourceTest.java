package fr.epsi.gl.quizz.web.resource.question;

import fr.epsi.gl.quizz.web.representation.ModeleEtVue;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class NouvelleQuestionRessourceTest {

    @Test
    public void peutAfficherLeFormulaire() {
        NouvelleQuestionRessource ressource = new NouvelleQuestionRessource();

        ModeleEtVue modeleEtVue = ressource.représente();

        assertThat(modeleEtVue).isNotNull();
        assertThat((modeleEtVue.getTemplate())).isEqualTo("/question/nouvelle-question");
    }
}
