package fr.epsi.gl.quizz.requete.user;

import org.jongo.marshall.jackson.oid.Id;

public class DetailsUser {
	private String login;
	private String mdp;
	private String mail;
	private String age;
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
	public String getMail(){
		return mail;
	}
	
	public String getAge(){
		return age;
	}
	public void setMail(String mail) {
		this.mail=mail;
		
	}
	
	public void setAge(String age) {
		this.age=age;
	
	}
}
