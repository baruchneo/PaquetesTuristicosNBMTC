package co.edu.uniminuto.arquitecturaSoftware.PaquetesTuristicos.hot.backing;

import co.edu.uniminuto.arquitecturaSoftware.PaquetesTuristicos.model.Mensajes;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "mensajesController")
@ViewScoped
public class MensajesController extends AbstractController<Mensajes> {

    @Inject
    private PersonaController personaCollectionController;
    @Inject
    private RegistroController registroCollectionController;

    public MensajesController() {
        // Inform the Abstract parent controller of the concrete Mensajes?cap_first Entity
        super(Mensajes.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Persona entities that are
     * retrieved from Mensajes?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Persona page
     */
    public String navigatePersonaCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Persona_items", this.getSelected().getPersonaCollection());
        }
        return "/generic/view/persona/index";
    }

    /**
     * Sets the "items" attribute with a collection of Registro entities that
     * are retrieved from Mensajes?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Registro page
     */
    public String navigateRegistroCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Registro_items", this.getSelected().getRegistroCollection());
        }
        return "/generic/view/registro/index";
    }

}
