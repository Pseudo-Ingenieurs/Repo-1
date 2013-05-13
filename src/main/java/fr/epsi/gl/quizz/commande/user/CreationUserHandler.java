package fr.epsi.gl.quizz.commande.user;

import java.util.UUID;

import fr.epsi.gl.quizz.commande.HandlerCommande;
import fr.epsi.gl.quizz.domaine.Entrepots;
import fr.epsi.gl.quizz.domaine.user.FabriqueUser;
import fr.epsi.gl.quizz.domaine.user.User;

@SuppressWarnings("UnusedDeclaration")
public class CreationUserHandler implements HandlerCommande<CreationUserMessage>{

	public UUID execute(CreationUserMessage commande) {
		User user = new FabriqueUser().nouveau(commande.login,commande.mdp,commande.mail,commande.age);
		Entrepots.users().ajoute(user);
		return user.getId();
	}

	public Class<CreationUserMessage> typeCommande() {
		return CreationUserMessage.class;
	}

}
