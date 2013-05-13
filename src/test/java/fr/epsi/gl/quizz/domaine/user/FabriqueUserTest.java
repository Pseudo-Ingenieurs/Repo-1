package fr.epsi.gl.quizz.domaine.user;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class FabriqueUserTest {

	  @Test
	    public void peutDonnerUserCompletEnBase() {
	        User user = unUserComplet();

	        assertThat(user).isNotNull();
	        assertThat(user.getId()).isNotNull();
	        assertThat(user.getLogin()).isNotNull();
	        assertThat(user.getMail()).isNotNull(); 
	        assertThat(user.getMotdepasse()).isNotNull();
	    }

	    @Test
	    public void peutDonnerUserIncompletEnLogin() {
	    	User user = unUserIncomplet();

	        assertThat(user).isNotNull();
	        assertThat(user.getId()).isNotNull();
	        assertThat(user.getLogin()).isNotNull();
	    }

	

	    private User unUserComplet() {
	        return new FabriqueUser().nouveau("toto","secret","email@epsi.fr", "12");
	    }
	    
	    private User unUserIncomplet() {
	        return new FabriqueUser().nouveau("toto","secret");
	    }
}
