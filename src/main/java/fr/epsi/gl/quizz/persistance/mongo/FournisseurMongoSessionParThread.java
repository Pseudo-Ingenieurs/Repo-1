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

    public MongoSession get() {
        return sessions.get();
    }

    public void nettoie() {
        sessions.get().stop();
        sessions.remove();
    }

    private final ThreadLocal<MongoSession> sessions = new ThreadLocal<MongoSession>() {
        protected MongoSession initialValue() {
            MongoSession session = sessionManager.createSession();
            session.start();
            return session;
        }
    };

    private final MongoSessionManager sessionManager;
}
