package co.edu.uniminuto.arquitecturaSoftware.PaquetesTuristicos.hot.backing;

import co.edu.uniminuto.arquitecturaSoftware.PaquetesTuristicos.model.CompraServiciosPaquetes;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "compraServiciosPaquetesController")
@ViewScoped
public class CompraServiciosPaquetesController extends AbstractController<CompraServiciosPaquetes> {

    @Inject
    private PaqueteTuristicoController paqueteTuristicoCollectionController;
    @Inject
    private ServicioController servicioCollectionController;
    @Inject
    private RegistroController registroCollectionController;
    @Inject
    private ProveedorController idProveedorController;
    @Inject
    private PersonaController idPersonaController;

    public CompraServiciosPaquetesController() {
        // Inform the Abstract parent controller of the concrete CompraServiciosPaquetes?cap_first Entity
        super(CompraServiciosPaquetes.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idProveedorController.setSelected(null);
        idPersonaController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of PaqueteTuristico entities
     * that are retrieved from CompraServiciosPaquetes?cap_first and returns the
     * navigation outcome.
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
     * Sets the "items" attribute with a collection of Servicio entities that
     * are retrieved from CompraServiciosPaquetes?cap_first and returns the
     * navigation outcome.
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
     * Sets the "items" attribute with a collection of Registro entities that
     * are retrieved from CompraServiciosPaquetes?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for Registro page
     */
    public String navigateRegistroCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Registro_items", this.getSelected().getRegistroCollection());
        }
        return "/generic/view/registro/index";
    }

    /**
     * Sets the "selected" attribute of the Proveedor controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdProveedor(ActionEvent event) {
        if (this.getSelected() != null && idProveedorController.getSelected() == null) {
            idProveedorController.setSelected(this.getSelected().getIdProveedor());
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
}
