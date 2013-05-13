package fr.epsi.gl.quizz.commande.users;

import java.util.UUID;

import fr.epsi.gl.quizz.commande.HandlerCommande;
import fr.epsi.gl.quizz.domaine.Entrepots;
import fr.epsi.gl.quizz.domaine.user.FabriqueUser;
import fr.epsi.gl.quizz.domaine.user.User;

@SuppressWarnings("UnusedDeclaration")
public class CreationUsersHandler implements HandlerCommande<CreationUsersMessage>{

	public UUID execute(CreationUsersMessage commande) {
		User user = new FabriqueUser().nouveau(commande.login,commande.mdp);
		Entrepots.users().ajoute(user);
		return user.getId();
	}

	public Class<CreationUsersMessage> typeCommande() {
		return CreationUsersMessage.class;
	}

}
