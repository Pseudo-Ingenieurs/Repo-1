package fr.epsi.gl.quizz.web.representation;

import org.restlet.representation.WriterRepresentation;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.IOException;
import java.io.Writer;
import java.util.Locale;

public class ThymeleafRepresentation extends WriterRepresentation {
    public ThymeleafRepresentation(ModeleEtVue modeleEtVue, TemplateEngine engine) {
        super(modeleEtVue.getType());
        this.modèleEtVue = modeleEtVue;
        this.engine = engine;
    }

    @Override
    public void write(Writer writer) throws IOException {
        Context context = new Context(Locale.FRENCH);
        context.getVariables().putAll(modèleEtVue.getData());
        engine.process(modèleEtVue.getTemplate(), context, writer);
    }

    private final ModeleEtVue modèleEtVue;
    private TemplateEngine engine;
}
