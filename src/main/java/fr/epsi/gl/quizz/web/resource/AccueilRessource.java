package fr.epsi.gl.quizz.web.resource;

import fr.epsi.gl.quizz.web.representation.ModeleEtVue;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class AccueilRessource extends ServerResource {

    @Get
    public ModeleEtVue hello() {
        return ModeleEtVue.crée("/accueil");
    }


}
