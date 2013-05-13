package fr.epsi.gl.quizz.domaine.user;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.UUID;

public class FabriqueUser {
	
	public User nouveau(String login,String mdp,String mail,String age){
		checkNotNull(login,mdp);
        User user = new User(UUID.randomUUID());
        user.setLogin(login);
        user.setMotdepasse(mdp);
        user.setMail(mail);
        user.setAge(age);
        return user;
	}
	
	public User nouveau(String login,String mdp){
		checkNotNull(login,mdp);
        User user = new User(UUID.randomUUID());
        user.setLogin(login);
        user.setMotdepasse(mdp);
        return user;
	}
}
