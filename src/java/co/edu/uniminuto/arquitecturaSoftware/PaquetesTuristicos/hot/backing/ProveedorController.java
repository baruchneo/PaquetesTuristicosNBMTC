package co.edu.uniminuto.arquitecturaSoftware.PaquetesTuristicos.hot.backing;

import co.edu.uniminuto.arquitecturaSoftware.PaquetesTuristicos.model.Proveedor;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "proveedorController")
@ViewScoped
public class ProveedorController extends AbstractController<Proveedor> {

    @Inject
    private CompraServiciosPaquetesController compraServiciosPaquetesCollectionController;
    @Inject
    private PersonaController idPersonaController;

    public ProveedorController() {
        // Inform the Abstract parent controller of the concrete Proveedor?cap_first Entity
        super(Proveedor.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idPersonaController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of CompraServiciosPaquetes
     * entities that are retrieved from Proveedor?cap_first and returns the
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
