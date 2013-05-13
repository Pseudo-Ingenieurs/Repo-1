package fr.epsi.gl.quizz.domaine.user;

import java.util.UUID;

import fr.epsi.gl.quizz.domaine.Aggregat;

public class User implements Aggregat{

	private UUID id;
	private String login;
	private String mdp;
	private String mail;
	private String age;
	
	@SuppressWarnings("UnusedDeclaration")
	protected User() {
	}

	public User(UUID id) {
        this.id = id;
    }
	public UUID getId() {
		return id;
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
	
	public void setLogin(String login) {
		this.login=login;		
	}

	public void setMotdepasse(String mdp) {
		this.mdp=mdp;
		
	}

	public void setMail(String mail) {
		this.mail=mail;
		
	}
	
	public void setAge(String age) {
		this.age=age;
	
	}
	
}
