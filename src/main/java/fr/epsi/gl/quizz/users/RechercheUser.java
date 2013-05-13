package fr.epsi.gl.quizz.users;

import java.util.List;
import java.util.UUID;

import org.jongo.Jongo;

import com.google.common.collect.Lists;
import com.google.inject.Inject;


public class RechercheUser {
	@Inject
    public RechercheUser(Jongo jongo) {
        this.jongo = jongo;
    }

    public List<DetailsUsers> toutes() {
        return Lists.newArrayList(jongo.getCollection("user").find().projection("{_id:1, libellé : 1}").as(DetailsUsers.class));
    }

    public DetailsUsers detailsDe(UUID id) {
        return jongo.getCollection("user").findOne("{_id:#}", id).as(DetailsUsers.class);
    }


    private Jongo jongo;
}
