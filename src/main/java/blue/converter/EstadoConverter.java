package blue.converter;

import javax.faces.convert.FacesConverter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import blue.model.Estado;

@FacesConverter(forClass=Estado.class)
public class EstadoConverter implements Converter {
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		Estado retorno = null;
		if(value != null) {
			retorno = new Estado();
			retorno.setCodigo(new Long(value));
		}
				
		return retorno;
	}

	@Override
	public String getAsString(FacesContext contexto, UIComponent componente, Object objeto) {
				
		try {
			
			Long codigo = ((Estado) objeto).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());
			
			
			return retorno;
		
		}catch (Exception e) {
			return ""; 	
		} 
	}
}
