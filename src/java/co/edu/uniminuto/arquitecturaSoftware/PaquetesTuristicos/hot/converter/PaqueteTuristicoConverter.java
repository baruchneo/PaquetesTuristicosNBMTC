package co.edu.uniminuto.arquitecturaSoftware.PaquetesTuristicos.hot.converter;

import co.edu.uniminuto.arquitecturaSoftware.PaquetesTuristicos.model.PaqueteTuristico;
import co.edu.uniminuto.arquitecturaSoftware.PaquetesTuristicos.hot.sessions.PaqueteTuristicoFacade;
import co.edu.uniminuto.arquitecturaSoftware.PaquetesTuristicos.hot.backing.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "paqueteTuristicoConverter")
public class PaqueteTuristicoConverter implements Converter {

    @Inject
    private PaqueteTuristicoFacade ejbFacade;

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
        if (object instanceof PaqueteTuristico) {
            PaqueteTuristico o = (PaqueteTuristico) object;
            return getStringKey(o.getIdPaqueteTuristico());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), PaqueteTuristico.class.getName()});
            return null;
        }
    }

}
