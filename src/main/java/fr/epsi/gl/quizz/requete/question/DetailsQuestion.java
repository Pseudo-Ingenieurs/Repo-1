package fr.epsi.gl.quizz.requete.question;

import com.google.common.collect.Lists;
import org.jongo.marshall.jackson.oid.Id;

import java.io.Serializable;
import java.util.List;

public class DetailsQuestion implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 6808755413156456741L;

	public String getLibellé() {
        return libellé;
    }

    public void setLibellé(String libellé) {
        this.libellé = libellé;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<DetailsReponse> getRéponses() {
        return réponses;
    }

    public void setRéponses(List<DetailsReponse> réponses) {
        this.réponses = réponses;
    }

    private String libellé;
    @Id
    private String id;

    private List<DetailsReponse> réponses = Lists.newArrayList();
}
