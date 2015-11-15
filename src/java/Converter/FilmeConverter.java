package Converter;

import Controllers.FilmeController;
import DomainEntity.Filme;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "filmeConverter")
public class FilmeConverter implements Converter  {
    @Override
    public Object getAsObject(FacesContext context, UIComponent component,
            String value) {
        if (value == null) {
            return null;
        }
        FilmeController bean = context.getApplication()
                .evaluateExpressionGet(context, "#{filmeController}",
                        FilmeController.class);
        Filme filme = bean.findFilmeByNome(value);
        return filme;
    }
 
    @Override
    public String getAsString(FacesContext context, UIComponent component,
            Object value) {
        String string = null;
        if (value instanceof Filme) {
            string = ((Filme) value).getNome();
        }
        return string;
    }
}
