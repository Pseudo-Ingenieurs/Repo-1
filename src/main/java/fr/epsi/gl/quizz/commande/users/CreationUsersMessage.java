package fr.epsi.gl.quizz.commande.users;
import fr.epsi.gl.quizz.commande.Message;


public class CreationUsersMessage implements Message{

	public CreationUsersMessage(String login,String mdp){
        this.login = login;
        this.mdp = mdp;

    }
    public final String login;
    public final String mdp;

}
