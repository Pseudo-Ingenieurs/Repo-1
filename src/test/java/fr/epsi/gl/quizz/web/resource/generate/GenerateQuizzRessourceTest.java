package fr.epsi.gl.quizz.web.resource.generate;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.Before;

import com.google.common.util.concurrent.Futures;

import fr.epsi.gl.quizz.commande.BusCommande;
import fr.epsi.gl.quizz.commande.Message;
import fr.epsi.gl.quizz.requete.question.RechercheQuestions;
import fr.epsi.gl.quizz.web.resource.RessourceHelper;
import fr.epsi.gl.quizz.web.resource.question.QuestionsRessource;

public class GenerateQuizzRessourceTest {
	
	private BusCommande bus;
    private QuestionsRessource ressource;
    private RechercheQuestions recherche;
    
    @Before
    public void setUp() throws Exception {
        bus = mock(BusCommande.class);
        when(bus.envoie(any(Message.class))).thenReturn(Futures.<Object>immediateFuture(UUID.randomUUID()));
        recherche = mock(RechercheQuestions.class);
        ressource = new QuestionsRessource(bus, recherche);
        RessourceHelper.initialise(ressource);
    }
}
