package co.edu.uniminuto.arquitecturaSoftware.PaquetesTuristicos.hot.converter;

import co.edu.uniminuto.arquitecturaSoftware.PaquetesTuristicos.model.TipoServicio;
import co.edu.uniminuto.arquitecturaSoftware.PaquetesTuristicos.hot.sessions.TipoServicioFacade;
import co.edu.uniminuto.arquitecturaSoftware.PaquetesTuristicos.hot.backing.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "tipoServicioConverter")
public class TipoServicioConverter implements Converter {

    @Inject
    private TipoServicioFacade ejbFacade;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.ejbFacade.find(getKey(value));
    }

    java.lang.Integer getKey(String value) {
        java.lang.Integer key;
        key = Integer.valueOf(value);
        return key;
    }

    String getStringKey(java.lang.Integer value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value);
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof TipoServicio) {
            TipoServicio o = (TipoServicio) object;
            return getStringKey(o.getIdTipoServicio());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), TipoServicio.class.getName()});
            return null;
        }
    }

}
