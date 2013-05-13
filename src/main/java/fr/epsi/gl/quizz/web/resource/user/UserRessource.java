package fr.epsi.gl.quizz.web.resource.user;

import java.util.UUID;

import javax.inject.Inject;

import org.restlet.data.Form;
import org.restlet.data.Status;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import com.google.common.util.concurrent.Futures;

import fr.epsi.gl.quizz.commande.BusCommande;
import fr.epsi.gl.quizz.commande.users.CreationUsersMessage;
import fr.epsi.gl.quizz.requete.user.DetailsUser;
import fr.epsi.gl.quizz.requete.user.RechercheUsers;
import fr.epsi.gl.quizz.web.representation.ModeleEtVue;

public class UserRessource extends ServerResource{

	private BusCommande bus;
	private RechercheUsers recherche ;
	private DetailsUser user;

	@Inject
	public UserRessource(BusCommande bus, RechercheUsers user){
		this.bus=bus;
		this.recherche=user;		
	}

	@Override
    protected void doInit() throws ResourceException {
        UUID id = UUID.fromString(getRequestAttributes().get("id").toString());
        user = recherche.detailsDe(id);
    }
	
	@Get
	public ModeleEtVue représente() {
		// après le submit register	
		return ModeleEtVue.crée("/user/register").avec("user",user);

	}
	
	@Post
	public void crée(Form formulaire) {
		// submit login
		CreationUsersMessage commande = new CreationUsersMessage(formulaire.getFirstValue("username"),formulaire.getFirstValue("password"));	
//		 TODO avoir /registered/{id} ou {name} et modifier les classes 
		user = recherche.detailsDe(formulaire.getFirstValue("username"));
		setStatus(Status.SUCCESS_ACCEPTED);
		//setLocationRef("/registered/" + Futures.getUnchecked(UUID.fromString(user.getId())));
	}

}
