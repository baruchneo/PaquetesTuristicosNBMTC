package co.edu.uniminuto.arquitecturaSoftware.PaquetesTuristicos.hot.backing;

import co.edu.uniminuto.arquitecturaSoftware.PaquetesTuristicos.model.Servicio;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "servicioController")
@ViewScoped
public class ServicioController extends AbstractController<Servicio> {

    @Inject
    private PaqueteTuristicoController paqueteTuristicoCollectionController;
    @Inject
    private CompraServiciosPaquetesController compraServiciosPaquetesCollectionController;
    @Inject
    private TipoServicioController idTipoServicioController;
    @Inject
    private PersonaController idPersonaController;
    @Inject
    private RegistroController registroCollectionController;

    public ServicioController() {
        // Inform the Abstract parent controller of the concrete Servicio?cap_first Entity
        super(Servicio.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idTipoServicioController.setSelected(null);
        idPersonaController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of PaqueteTuristico entities
     * that are retrieved from Servicio?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for PaqueteTuristico page
     */
    public String navigatePaqueteTuristicoCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("PaqueteTuristico_items", this.getSelected().getPaqueteTuristicoCollection());
        }
        return "/generic/view/paqueteTuristico/index";
    }

    /**
     * Sets the "items" attribute with a collection of CompraServiciosPaquetes
     * entities that are retrieved from Servicio?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for CompraServiciosPaquetes page
     */
    public String navigateCompraServiciosPaquetesCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("CompraServiciosPaquetes_items", this.getSelected().getCompraServiciosPaquetesCollection());
        }
        return "/generic/view/compraServiciosPaquetes/index";
    }

    /**
     * Sets the "selected" attribute of the TipoServicio controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdTipoServicio(ActionEvent event) {
        if (this.getSelected() != null && idTipoServicioController.getSelected() == null) {
            idTipoServicioController.setSelected(this.getSelected().getIdTipoServicio());
        }
    }

    /**
     * Sets the "selected" attribute of the Persona controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdPersona(ActionEvent event) {
        if (this.getSelected() != null && idPersonaController.getSelected() == null) {
            idPersonaController.setSelected(this.getSelected().getIdPersona());
        }
    }

    /**
     * Sets the "items" attribute with a collection of Registro entities that
     * are retrieved from Servicio?cap_first and returns the navigation outcome.
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
