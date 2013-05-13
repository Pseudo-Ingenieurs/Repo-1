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
import com.google.common.util.concurrent.ListenableFuture;

import fr.epsi.gl.quizz.commande.BusCommande;
import fr.epsi.gl.quizz.commande.user.CreationUserMessage;
import fr.epsi.gl.quizz.requete.user.DetailsUser;
import fr.epsi.gl.quizz.requete.user.RechercheUsers;
import fr.epsi.gl.quizz.utils.BCrypt;
import fr.epsi.gl.quizz.web.representation.ModeleEtVue;

public class UsersRessource extends ServerResource{

	private BusCommande bus;
	private RechercheUsers recherche ;
	private DetailsUser user;
	private String hashpw;

	@Inject
	public UsersRessource(BusCommande bus, RechercheUsers user){
		this.bus=bus;
		this.recherche=user;		
	}
	


	@Get
	public ModeleEtVue représente() {
		// après submit login
		return ModeleEtVue.crée("/registered/login").avec("login",user.getLogin());

	}

	@Post
	public void crée(Form formulaire) {
		// submit formulaire register
		hashpw= BCrypt.hashpw(formulaire.getFirstValue("password"),	BCrypt.gensalt());
		CreationUserMessage commande = new CreationUserMessage(formulaire.getFirstValue("username"),hashpw,formulaire.getFirstValue("email"),
				formulaire.getFirstValue("age"));
		ListenableFuture<UUID> idUser = bus.envoie(commande);
		setStatus(Status.SUCCESS_ACCEPTED);
		setLocationRef("/register/" + Futures.getUnchecked(idUser));
	}

}
