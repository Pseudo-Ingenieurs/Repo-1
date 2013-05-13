package fr.epsi.gl.quizz.web.resource.user;

import static org.fest.assertions.Assertions.assertThat;
import static org.fest.assertions.MapAssert.entry;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.restlet.data.Form;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Futures;

import fr.epsi.gl.quizz.commande.BusCommande;
import fr.epsi.gl.quizz.commande.Message;
import fr.epsi.gl.quizz.commande.question.CreationQuestionMessage;
import fr.epsi.gl.quizz.requete.user.DetailsUser;
import fr.epsi.gl.quizz.requete.user.RechercheUsers;
import fr.epsi.gl.quizz.web.representation.ModeleEtVue;
import fr.epsi.gl.quizz.web.resource.RessourceHelper;

public class UsersRessourceTest {

	@Before
    public void setUp() throws Exception {
        bus = mock(BusCommande.class);
        when(bus.envoie(any(Message.class))).thenReturn(Futures.<Object>immediateFuture(UUID.randomUUID()));
        recherche = mock(RechercheUsers.class);
        ressource = new UsersRessource(bus, recherche);
        RessourceHelper.initialise(ressource);
    }

    @Test
    public void peutCréerUnUsers() {
        Form formulaire = new Form();
        formulaire.add("login", "C'est mon login");

        ressource.crée(formulaire);

        ArgumentCaptor<CreationQuestionMessage> capteur = ArgumentCaptor.forClass(CreationQuestionMessage.class);
        verify(bus).envoie(capteur.capture());
        CreationQuestionMessage commande = capteur.getValue();
        assertThat(commande.libellé).isEqualTo("C'est mon login");
    }



    @Test
    public void peutAfficherToutesLesUsers() {
        List<DetailsUser> users = Lists.newArrayList();
        when(recherche.toutes()).thenReturn(users);

        ModeleEtVue represente = ressource.représente();

        assertThat(represente.getTemplate()).isEqualTo("/registered/login");
        assertThat(represente.getData()).includes(entry("login", users));

    }

    private BusCommande bus;
    private UsersRessource ressource;
    private RechercheUsers recherche;
}
