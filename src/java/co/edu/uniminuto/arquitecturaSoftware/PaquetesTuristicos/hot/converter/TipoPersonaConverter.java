package co.edu.uniminuto.arquitecturaSoftware.PaquetesTuristicos.hot.converter;

import co.edu.uniminuto.arquitecturaSoftware.PaquetesTuristicos.model.TipoPersona;
import co.edu.uniminuto.arquitecturaSoftware.PaquetesTuristicos.hot.sessions.TipoPersonaFacade;
import co.edu.uniminuto.arquitecturaSoftware.PaquetesTuristicos.hot.backing.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "tipoPersonaConverter")
public class TipoPersonaConverter implements Converter {

    @Inject
    private TipoPersonaFacade ejbFacade;

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
        if (object instanceof TipoPersona) {
            TipoPersona o = (TipoPersona) object;
            return getStringKey(o.getIdTipoPersona());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), TipoPersona.class.getName()});
            return null;
        }
    }

}
