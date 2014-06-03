package co.edu.uniminuto.arquitecturaSoftware.PaquetesTuristicos.hot.backing;

import co.edu.uniminuto.arquitecturaSoftware.PaquetesTuristicos.model.Persona;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "personaController")
@ViewScoped
public class PersonaController extends AbstractController<Persona> {

    @Inject
    private MensajesController mensajesCollectionController;
    @Inject
    private ServicioController servicioCollectionController;
    @Inject
    private CompraServiciosPaquetesController compraServiciosPaquetesCollectionController;
    @Inject
    private ProveedorController proveedorCollectionController;
    @Inject
    private PaqueteTuristicoController paqueteTuristicoCollectionController;
    @Inject
    private TipoPersonaController idTipoPersonaController;

    public PersonaController() {
        // Inform the Abstract parent controller of the concrete Persona?cap_first Entity
        super(Persona.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idTipoPersonaController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Mensajes entities that
     * are retrieved from Persona?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Mensajes page
     */
    public String navigateMensajesCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Mensajes_items", this.getSelected().getMensajesCollection());
        }
        return "/generic/view/mensajes/index";
    }

    /**
     * Sets the "items" attribute with a collection of Servicio entities that
     * are retrieved from Persona?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Servicio page
     */
    public String navigateServicioCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Servicio_items", this.getSelected().getServicioCollection());
        }
        return "/generic/view/servicio/index";
    }

    /**
     * Sets the "items" attribute with a collection of CompraServiciosPaquetes
     * entities that are retrieved from Persona?cap_first and returns the
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
     * Sets the "items" attribute with a collection of Proveedor entities that
     * are retrieved from Persona?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Proveedor page
     */
    public String navigateProveedorCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Proveedor_items", this.getSelected().getProveedorCollection());
        }
        return "/generic/view/proveedor/index";
    }

    /**
     * Sets the "items" attribute with a collection of PaqueteTuristico entities
     * that are retrieved from Persona?cap_first and returns the navigation
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
     * Sets the "selected" attribute of the TipoPersona controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdTipoPersona(ActionEvent event) {
        if (this.getSelected() != null && idTipoPersonaController.getSelected() == null) {
            idTipoPersonaController.setSelected(this.getSelected().getIdTipoPersona());
        }
    }
}
