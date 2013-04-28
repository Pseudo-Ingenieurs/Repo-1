package fr.epsi.gl.quizz.web.representation;

import org.junit.Test;
import org.restlet.data.MediaType;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.IOException;

import static org.fest.assertions.Assertions.assertThat;

public class ThymeleafRepresentationTest {

    @Test
    public void peutFusionnerDesDonnées() throws IOException {
        TemplateEngine engine = créeEngine();
        ModeleEtVue modeleEtVue = ModeleEtVue.crée("/test-fusion", MediaType.TEXT_HTML).avec("nom", "Jb Dusseaut");

        String text = new ThymeleafRepresentation(modeleEtVue, engine).getText();

        assertThat(text).contains("Jb Dusseaut");
    }

    private TemplateEngine créeEngine() {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setTemplateMode("HTML5");
        templateResolver.setPrefix("templates-test");
        templateResolver.setSuffix(".html");
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        return templateEngine;
    }
}
