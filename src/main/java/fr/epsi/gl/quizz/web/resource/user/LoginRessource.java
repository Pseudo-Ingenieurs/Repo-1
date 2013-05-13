package fr.epsi.gl.quizz.web.resource.user;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import fr.epsi.gl.quizz.web.representation.ModeleEtVue;


public class LoginRessource extends ServerResource{

	 @Get
	    public ModeleEtVue représente() {
	        return ModeleEtVue.crée("/user/registering");
	    }
	
}
