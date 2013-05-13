package fr.epsi.gl.quizz.commande.user;
import fr.epsi.gl.quizz.commande.Message;


public class CreationUserMessage implements Message{

	public CreationUserMessage(String login,String mdp,String mail,String age) {
        this.login = login;
        this.mdp = mdp;
        this.mail=mail;
        this.age=age;
    }
	
	public final String age;
	public final String mail;
    public final String login;
    public final String mdp;

}
