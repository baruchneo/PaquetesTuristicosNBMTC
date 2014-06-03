package co.edu.uniminuto.arquitecturaSoftware.PaquetesTuristicos.hot.backing;

import co.edu.uniminuto.arquitecturaSoftware.PaquetesTuristicos.model.TipoServicio;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "tipoServicioController")
@ViewScoped
public class TipoServicioController extends AbstractController<TipoServicio> {

    @Inject
    private ServicioController servicioCollectionController;

    public TipoServicioController() {
        // Inform the Abstract parent controller of the concrete TipoServicio?cap_first Entity
        super(TipoServicio.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Servicio entities that
     * are retrieved from TipoServicio?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Servicio page
     */
    public String navigateServicioCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Servicio_items", this.getSelected().getServicioCollection());
        }
        return "/generic/view/servicio/index";
    }

}
