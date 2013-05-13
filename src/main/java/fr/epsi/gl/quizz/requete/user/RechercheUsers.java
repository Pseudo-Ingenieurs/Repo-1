package fr.epsi.gl.quizz.requete.user;

import java.util.List;
import java.util.UUID;

import org.jongo.Jongo;

import com.google.common.collect.Lists;
import com.google.inject.Inject;


public class RechercheUsers {
	@Inject
    public RechercheUsers(Jongo jongo) {
        this.jongo = jongo;
    }

    public List<DetailsUser> toutes() {
        return Lists.newArrayList(jongo.getCollection("user").find().projection("{_id:1, libellé : 1}").as(DetailsUser.class));
    }

    public DetailsUser detailsDe(UUID id) {
        return jongo.getCollection("user").findOne("{_id:#}", id).as(DetailsUser.class);
    }
    
    public DetailsUser detailsDe(String login) {
        return jongo.getCollection("user").findOne("{_login:#}",login).as(DetailsUser.class);
    }



    private Jongo jongo;
}
