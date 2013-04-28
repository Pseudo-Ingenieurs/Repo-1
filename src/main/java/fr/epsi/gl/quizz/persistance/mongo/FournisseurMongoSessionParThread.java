package fr.epsi.gl.quizz.persistance.mongo;

import fr.epsi.gl.quizz.commande.FournisseurMongoSession;
import org.mongolink.MongoSession;
import org.mongolink.MongoSessionManager;

import javax.inject.Inject;

public class FournisseurMongoSessionParThread implements FournisseurMongoSession{

    @Inject
    public FournisseurMongoSessionParThread(MongoSessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public MongoSession get() {
        return sessions.get();
    }

    @Override
    public void nettoie() {
        sessions.get().stop();
        sessions.remove();
    }

    private final ThreadLocal<MongoSession> sessions = new ThreadLocal<MongoSession>() {
        @Override
        protected MongoSession initialValue() {
            MongoSession session = sessionManager.createSession();
            session.start();
            return session;
        }
    };

    private final MongoSessionManager sessionManager;
}
