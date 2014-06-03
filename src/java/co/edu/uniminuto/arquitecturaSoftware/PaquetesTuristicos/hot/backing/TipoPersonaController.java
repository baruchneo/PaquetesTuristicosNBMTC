package co.edu.uniminuto.arquitecturaSoftware.PaquetesTuristicos.hot.backing;

import co.edu.uniminuto.arquitecturaSoftware.PaquetesTuristicos.model.TipoPersona;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "tipoPersonaController")
@ViewScoped
public class TipoPersonaController extends AbstractController<TipoPersona> {

    @Inject
    private PersonaController personaCollectionController;

    public TipoPersonaController() {
        // Inform the Abstract parent controller of the concrete TipoPersona?cap_first Entity
        super(TipoPersona.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Persona entities that are
     * retrieved from TipoPersona?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Persona page
     */
    public String navigatePersonaCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Persona_items", this.getSelected().getPersonaCollection());
        }
        return "/generic/view/persona/index";
    }

}
