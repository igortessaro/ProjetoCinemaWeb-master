package Converter;

import Controllers.SalaController;
import Controllers.SecaoController;
import Domain.Filme;
import Domain.Sala;
import DomainEntity.Secao;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "secaoConverter")
public class SecaoConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext context, UIComponent component,
            String value) {
        if (value == null) {
            return null;
        }
        SecaoController bean = context.getApplication()
                .evaluateExpressionGet(context, "#{secaoController}",
                        SecaoController.class);
        Secao secao = bean.findSecaoByDecricao(value);
        return secao;
    }
 
    @Override
    public String getAsString(FacesContext context, UIComponent component,
            Object value) {
        String string = null;
        if (value instanceof Secao) {
            string = ((Secao) value).toString();
        }
        return string;
    }
}
