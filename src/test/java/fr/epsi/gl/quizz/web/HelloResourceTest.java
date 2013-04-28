package fr.epsi.gl.quizz.web;

import fr.epsi.gl.quizz.web.representation.ModeleEtVue;
import fr.epsi.gl.quizz.web.resource.AccueilRessource;
import org.junit.Test;

import static org.fest.assertions.Assertions.*;

public class HelloResourceTest {

    @Test
    public void ditbienHello() {
        ModeleEtVue coucou = new AccueilRessource().hello();

        assertThat(coucou.getTemplate()).isEqualTo("/accueil");
    }

}
