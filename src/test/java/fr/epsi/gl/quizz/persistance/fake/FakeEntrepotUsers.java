package fr.epsi.gl.quizz.persistance.fake;

import java.util.List;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;

import fr.epsi.gl.quizz.domaine.user.EntrepotUsers;
import fr.epsi.gl.quizz.domaine.user.User;

public class FakeEntrepotUsers implements EntrepotUsers{

	private List<User> users = Lists.newArrayList();

	public Optional<User> get(Object id) {
		 for (User user : users) {
	            if(user.getId().equals(id)) {
	                return Optional.of(user);
	            }
	        }
	        return Optional.absent();
	}

	public User ajoute(User aggregat) {
		users.add(aggregat);
		return aggregat;
	}

	public void supprime(User aggregat) {
		users.remove(aggregat);		
	}

}
