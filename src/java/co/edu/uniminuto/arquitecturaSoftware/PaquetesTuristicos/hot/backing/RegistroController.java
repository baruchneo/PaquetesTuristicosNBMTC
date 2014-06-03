package co.edu.uniminuto.arquitecturaSoftware.PaquetesTuristicos.hot.backing;

import co.edu.uniminuto.arquitecturaSoftware.PaquetesTuristicos.model.Registro;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "registroController")
@ViewScoped
public class RegistroController extends AbstractController<Registro> {

    @Inject
    private TipoRegistroController idTipoRegistroController;
    @Inject
    private ServicioController idServicioController;
    @Inject
    private PaqueteTuristicoController idPaqueteTuristicoController;
    @Inject
    private MensajesController idMensajeController;
    @Inject
    private CompraServiciosPaquetesController idCompraServPaqtController;

    public RegistroController() {
        // Inform the Abstract parent controller of the concrete Registro?cap_first Entity
        super(Registro.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idTipoRegistroController.setSelected(null);
        idServicioController.setSelected(null);
        idPaqueteTuristicoController.setSelected(null);
        idMensajeController.setSelected(null);
        idCompraServPaqtController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the TipoRegistro controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdTipoRegistro(ActionEvent event) {
        if (this.getSelected() != null && idTipoRegistroController.getSelected() == null) {
            idTipoRegistroController.setSelected(this.getSelected().getIdTipoRegistro());
        }
    }

    /**
     * Sets the "selected" attribute of the Servicio controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdServicio(ActionEvent event) {
        if (this.getSelected() != null && idServicioController.getSelected() == null) {
            idServicioController.setSelected(this.getSelected().getIdServicio());
        }
    }

    /**
     * Sets the "selected" attribute of the PaqueteTuristico controller in order
     * to display its data in a dialog. This is reusing existing the existing
     * View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdPaqueteTuristico(ActionEvent event) {
        if (this.getSelected() != null && idPaqueteTuristicoController.getSelected() == null) {
            idPaqueteTuristicoController.setSelected(this.getSelected().getIdPaqueteTuristico());
        }
    }

    /**
     * Sets the "selected" attribute of the Mensajes controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdMensaje(ActionEvent event) {
        if (this.getSelected() != null && idMensajeController.getSelected() == null) {
            idMensajeController.setSelected(this.getSelected().getIdMensaje());
        }
    }

    /**
     * Sets the "selected" attribute of the CompraServiciosPaquetes controller
     * in order to display its data in a dialog. This is reusing existing the
     * existing View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdCompraServPaqt(ActionEvent event) {
        if (this.getSelected() != null && idCompraServPaqtController.getSelected() == null) {
            idCompraServPaqtController.setSelected(this.getSelected().getIdCompraServPaqt());
        }
    }
}
