package fr.epsi.gl.quizz.web.representation;

import com.google.common.collect.Lists;
import org.restlet.Context;
import org.restlet.engine.converter.ConverterHelper;
import org.restlet.engine.resource.VariantInfo;
import org.restlet.representation.Representation;
import org.restlet.representation.Variant;
import org.restlet.resource.Resource;
import org.thymeleaf.TemplateEngine;

import java.io.IOException;
import java.util.List;

@SuppressWarnings("UnusedDeclaration")
public class ModeleEtVueConverter extends ConverterHelper {
    @Override
    public List<Class<?>> getObjectClasses(final Variant variant) {
        return Lists.newArrayList();
    }

    @Override
    public List<VariantInfo> getVariants(final Class<?> aClass) {
        return Lists.newArrayList();
    }

    @Override
    public float score(Object source, Variant target, Resource resource) {
        if (ModeleEtVue.class.isAssignableFrom(source.getClass())) {
            return 1.0f;
        }
        return -1.0f;
    }

    @Override
    public <T> float score(Representation source, Class<T> target, Resource resource) {
        return -1.0f;
    }

    @Override
    public <T> T toObject(Representation source, Class<T> target, Resource resource) throws IOException {
        return null;
    }

    @Override
    public Representation toRepresentation(Object source, Variant target, Resource resource) throws IOException {
        final ModeleEtVue modeleEtVue = (ModeleEtVue) source;
        return new ThymeleafRepresentation(modeleEtVue, getEngine());

    }

    private TemplateEngine getEngine() {
        return (TemplateEngine) Context.getCurrent().getAttributes().get(TemplateEngine.class.getName());
    }
}
