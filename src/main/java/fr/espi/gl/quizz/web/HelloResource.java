package fr.espi.gl.quizz.web;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class HelloResource extends ServerResource {


    @Get
    public String hello() {
        return "hello world!!!"
                ;
    }
}
