package fr.epsi.gl.quizz.web.representation;

import org.junit.Test;
import org.restlet.Context;
import org.restlet.data.MediaType;
import org.restlet.representation.Representation;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.IOException;
import java.util.logging.Logger;

import static org.fest.assertions.Assertions.*;

public class ModeleEtVueConverterTest {

    @Test
    public void peutFusionnerUnTemplate() throws IOException {
        Context context = étantDonnéUnContexteConfiguré();
        Context.setCurrent(context);
        ModeleEtVue modeleEtVue = ModeleEtVue.crée("/test", MediaType.TEXT_HTML);

        Representation representation = new ModeleEtVueConverter().toRepresentation(modeleEtVue, null, null);

        assertThat(representation).isNotNull();
        assertThat(representation.getText()).contains("test");
    }

    private Context étantDonnéUnContexteConfiguré() {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setTemplateMode("HTML5");
        templateResolver.setPrefix("templates-test");
        templateResolver.setSuffix(".html");
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        Context context = new Context(Logger.getLogger("test"));
        context.getAttributes().put(TemplateEngine.class.getName(), templateEngine);
        return context;
    }
}
