package fr.epsi.gl.quizz.users;

import org.jongo.marshall.jackson.oid.Id;

public class DetailsUsers {
	private String login;
	private String mdp;

    @Id
    private String id;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getLogin() {
        return login;
    }
    public String getMotdepasse() {
        return mdp;
    }
	
}
