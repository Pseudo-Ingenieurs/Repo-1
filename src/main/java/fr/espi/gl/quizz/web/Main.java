package fr.espi.gl.quizz.web;

import org.restlet.Component;
import org.restlet.data.Protocol;

public class Main {

    public static void main(String[] args)  {
        Component component = new Component();
        component.getServers().add(Protocol.HTTP, 8080);
        component.getDefaultHost().attach(new QuizzApplication());
        try {
            component.start();
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
