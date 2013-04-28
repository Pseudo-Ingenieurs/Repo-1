package fr.epsi.gl.quizz.persistance.fake;

import fr.epsi.gl.quizz.domaine.Entrepots;
import org.junit.rules.ExternalResource;

public class AvecEntrepots extends ExternalResource{

    @Override
    protected void before() throws Throwable {
        Entrepots.setInstance(new FakeEntrepots());
    }

    @Override
    protected void after() {
        Entrepots.setInstance(null);
    }
}
