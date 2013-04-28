package fr.epsi.gl.quizz.commande;


import org.mongolink.MongoSession;

public interface FournisseurMongoSession {
    MongoSession get();

    void nettoie();
}
