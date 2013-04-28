package fr.epsi.gl.quizz.web.resource.question;

import fr.epsi.gl.quizz.web.representation.ModeleEtVue;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class NouvelleQuestionRessource extends ServerResource
{
    @Get
    public ModeleEtVue représente() {
        return ModeleEtVue.crée("/question/nouvelle-question");
    }
}
