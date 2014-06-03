package co.edu.uniminuto.arquitecturaSoftware.PaquetesTuristicos.hot.backing;

import co.edu.uniminuto.arquitecturaSoftware.PaquetesTuristicos.model.TipoRegistro;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "tipoRegistroController")
@ViewScoped
public class TipoRegistroController extends AbstractController<TipoRegistro> {

    @Inject
    private RegistroController registroCollectionController;

    public TipoRegistroController() {
        // Inform the Abstract parent controller of the concrete TipoRegistro?cap_first Entity
        super(TipoRegistro.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Registro entities that
     * are retrieved from TipoRegistro?cap_first and returns the navigation
     * outcome.
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
