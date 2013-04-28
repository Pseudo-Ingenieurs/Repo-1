package fr.epsi.gl.quizz.web.representation;

import com.google.common.collect.Maps;
import org.restlet.data.MediaType;

import java.util.Map;

public class ModeleEtVue {

    public static ModeleEtVue crée(String template) {
        return crée(template, MediaType.TEXT_HTML);
    }

    public static ModeleEtVue crée(String template, MediaType mediaType) {
        ModeleEtVue résultat = new ModeleEtVue();
        résultat.type=mediaType;
        résultat.template = template;
        return résultat;
    }

    private ModeleEtVue() {
    }

    public String getTemplate() {
        return template;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public MediaType getType() {
        return type;
    }

    public ModeleEtVue avec(String clef, Object valeur) {
        data.put(clef, valeur);
        return this;
    }

    private String template;
    private Map<String, Object> data = Maps.newConcurrentMap();
    private MediaType type;
}
