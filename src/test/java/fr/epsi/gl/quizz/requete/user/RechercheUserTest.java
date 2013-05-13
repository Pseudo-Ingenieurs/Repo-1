package fr.epsi.gl.quizz.requete.user;

import static org.fest.assertions.Assertions.assertThat;

import java.util.List;
import java.util.UUID;

import org.jongo.Jongo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.foursquare.fongo.Fongo;

import fr.epsi.gl.quizz.users.DetailsUsers;
import fr.epsi.gl.quizz.users.RechercheUser;

public class RechercheUserTest {

    @Before
    public void setUp() throws Exception {
        fongo = new Fongo("test");
        jongo = new Jongo(fongo.getDB("quizz"));
    }

    @After
    public void tearDown() throws Exception {
        fongo.dropDatabase("quizz");
    }

    @Test
    public void peutRécupérerToutesLesUser() {
        jongo.getCollection("user").insert("{login: 'test'}");
        RechercheUser recherche = new RechercheUser(jongo);

        List<DetailsUsers> users = recherche.toutes();

        assertThat(users).hasSize(1);
        assertThat(users.get(0).getLogin()).isEqualTo("test");
    }

    @Test
    public void peutRécupérerUnUser() {
        UUID id = UUID.randomUUID();
        jongo.getCollection("user").insert("{_id: #, login : 'toto'}");
        RechercheUser recherche = new RechercheUser(jongo);

        DetailsUsers details = recherche.detailsDe(id);

        assertThat(details).isNotNull();
        assertThat(details.getLogin()).isEqualTo("toto");

    }

    private Jongo jongo;
    private Fongo fongo;
}
