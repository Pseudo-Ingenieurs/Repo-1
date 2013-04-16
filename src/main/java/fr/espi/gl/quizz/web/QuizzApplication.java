package fr.espi.gl.quizz.web;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

public class QuizzApplication extends Application {

    @Override
    public Restlet createInboundRoot() {
        Router router = new Router();
        router.attach("/hello", HelloResource.class);
        return router;
    }
}
