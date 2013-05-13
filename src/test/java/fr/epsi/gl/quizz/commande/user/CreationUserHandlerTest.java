package fr.epsi.gl.quizz.commande.user;

import static org.fest.assertions.Assertions.assertThat;

import java.util.UUID;

import org.junit.Rule;
import org.junit.Test;

import fr.epsi.gl.quizz.domaine.Entrepots;
import fr.epsi.gl.quizz.persistance.fake.AvecEntrepots;

public class CreationUserHandlerTest {

	 @Rule
	    public AvecEntrepots entrepots = new AvecEntrepots();

	    @Test
	    public void peutCréerUser() {
	        CreationUserMessage commande = new CreationUserMessage("login","mdp","test@epsi.fr","18");

	        UUID idUser = new CreationUserHandler().execute(commande);

	        assertThat(idUser).isNotNull();
	        assertThat(Entrepots.users().get(idUser)).isNotNull();
	        assertThat(Entrepots.users().get(idUser).get().getLogin().equals("login"));
	    }
}
