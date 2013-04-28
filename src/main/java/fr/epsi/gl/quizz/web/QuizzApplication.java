package fr.epsi.gl.quizz.web;

import com.google.inject.Injector;
import fr.epsi.gl.quizz.web.configuration.QuizzRouter;
import org.restlet.Application;
import org.restlet.Context;
import org.restlet.Restlet;
import org.thymeleaf.TemplateEngine;

public class QuizzApplication extends Application {


    public QuizzApplication(Context context, Injector injector) {
        super(context);
        this.injector = injector;
        getContext().getAttributes().put(TemplateEngine.class.getName(), injector.getInstance(TemplateEngine.class));
    }

    @Override
    public Restlet createInboundRoot() {
        return new QuizzRouter(getContext(), injector);
    }

    private Injector injector;
}
