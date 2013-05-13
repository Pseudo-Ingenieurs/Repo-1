package fr.epsi.gl.quizz.domaine.user;

import static org.fest.assertions.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

public class UserTest {

	 List<User> users = Lists.newArrayList();

		
	@Test
	public void peutDonnerUnId(){
		User q = unUser();
		
		assertThat(q).isNotNull();
		assertThat(q.getId()).isNotNull();
		
	}

	@Test
	public void peutDonnerUnAge(){
		
		User u = new FabriqueUser().nouveau("toto","secret","email@epsi.fr", "12");
		assertThat(u.getAge()).isEqualTo("12");
	}
	
	@Test
	public void peutDonnerUnLogin(){
		
		User u = new FabriqueUser().nouveau("toto","secret","email@epsi.fr", "12");
		assertThat(u.getLogin()).isEqualTo("toto");
	}
	
	@Test
	public void peutDonnerUnEMail(){
		
		User u = new FabriqueUser().nouveau("toto","secret","email@epsi.fr", "12");
		assertThat(u.getMail()).isEqualTo("email@epsi.fr");
	}
	
	@Test
	public void peutDonnerUnMotDePasse(){
		
		User u = new FabriqueUser().nouveau("toto","secret","email@epsi.fr", "12");
		assertThat(u.getMotdepasse()).isEqualTo("secret");
	}
	
	
	private User unUser() {
		return new FabriqueUser().nouveau("toto","age","email@epsi.fr", "12");
	}
}
