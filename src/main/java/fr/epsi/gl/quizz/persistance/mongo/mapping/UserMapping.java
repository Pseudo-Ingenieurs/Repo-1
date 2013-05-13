package fr.epsi.gl.quizz.persistance.mongo.mapping;

import org.mongolink.domain.mapper.AggregateMap;

import fr.epsi.gl.quizz.domaine.user.User;

public class UserMapping extends AggregateMap<User>{

	public UserMapping() {
		super(User.class);
	}

	@Override
	protected void map() {
		id(element().getId()).natural();
		property(element().getLogin());
		property(element().getMotdepasse());
		property(element().getMail());
		property(element().getAge());
	}	
}
