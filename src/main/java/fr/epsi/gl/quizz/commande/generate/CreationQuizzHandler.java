package fr.epsi.gl.quizz.commande.generate;

import java.util.UUID;

import fr.epsi.gl.quizz.commande.HandlerCommande;
import fr.epsi.gl.quizz.domaine.Entrepots;
import fr.epsi.gl.quizz.domaine.generate.FabriqueQuizzs;
import fr.epsi.gl.quizz.domaine.generate.Quizz;

@SuppressWarnings("UnusedDeclaration")
public class CreationQuizzHandler implements HandlerCommande<CreationQuizzMessage>{

	public UUID execute(CreationQuizzMessage commande) {
		Quizz quizz = new FabriqueQuizzs().nouveau(commande.libellé);
		Entrepots.quizzs().ajoute(quizz);
		return quizz.getId();
	}

	public Class<CreationQuizzMessage> typeCommande() {
		return CreationQuizzMessage.class;
	}

}
