package Converter;

import Controllers.SalaController;
import DomainEntity.Sala;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "salaConverter")
public class SalaConverter  implements Converter  {
    @Override
    public Object getAsObject(FacesContext context, UIComponent component,
            String value) {
        if (value == null) {
            return null;
        }
        SalaController bean = context.getApplication()
                .evaluateExpressionGet(context, "#{salaController}",
                        SalaController.class);
        Sala sala = bean.findSalaByNumero(value);
        return sala;
    }
 
    @Override
    public String getAsString(FacesContext context, UIComponent component,
            Object value) {
        String string = null;
        if (value instanceof Sala) {
            string = Integer.toString(((Sala) value).getNumero());
        }
        return string;
    }
}
