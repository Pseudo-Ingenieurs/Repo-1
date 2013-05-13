package fr.epsi.gl.quizz.web;

import com.google.inject.Injector;
import fr.epsi.gl.quizz.web.configuration.QuizzRouter;
import org.restlet.Application;
import org.restlet.Context;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.data.ChallengeScheme;
import org.restlet.security.ChallengeAuthenticator;
import org.restlet.security.MapVerifier;
import org.thymeleaf.TemplateEngine;

public class QuizzApplication extends Application {

	private ChallengeAuthenticator authenticator;
	
    public QuizzApplication(Context context, Injector injector) {
        super(context);
        this.injector = injector;
        getContext().getAttributes().put(TemplateEngine.class.getName(), injector.getInstance(TemplateEngine.class));
    }
    
    private ChallengeAuthenticator createAuthenticator() {
        Context context = getContext();
        boolean optional = true;
        ChallengeScheme challengeScheme = ChallengeScheme.HTTP_BASIC;
        String realm = "Example site";

        // MapVerifier isn't very secure; see docs for alternatives
        MapVerifier verifier = new MapVerifier();
        verifier.getLocalSecrets().put("user", "password".toCharArray());

        ChallengeAuthenticator auth = new ChallengeAuthenticator(context, optional, challengeScheme, realm, verifier) {
            @Override
            protected boolean authenticate(Request request, Response response) {
                if (request.getChallengeResponse() == null) {
                    return false;
                } else {
                    return super.authenticate(request, response);
                }
            }
        };

        return auth;
    }
    
    @Override
    public Restlet createInboundRoot() {
    	this.authenticator = createAuthenticator();
    	QuizzRouter qr = new QuizzRouter(getContext(), injector);
    	authenticator.setNext(qr);
        return authenticator;
        
    }
    
    public boolean authenticate(Request request, Response response) {
        if (!request.getClientInfo().isAuthenticated()) {
            authenticator.challenge(response, false);
            return false;
        }
        return true;
    }

    private Injector injector;
}
