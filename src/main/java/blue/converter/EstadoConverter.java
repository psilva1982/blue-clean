package blue.converter;

import javax.faces.convert.FacesConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import blue.model.Estado;
import blue.repository.Estados;
import blue.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=Estado.class)
public class EstadoConverter implements Converter {

	private Estados estados;
	
	public EstadoConverter() {
		this.estados = CDIServiceLocator.getBean(Estados.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		Estado retorno = null;
		if(value != null) {
			try {
				retorno = this.estados.getOne(new Long(value));	
			}catch (Exception e) {
				
			}
		}
				
		return retorno;
	}

	@Override
	public String getAsString(FacesContext contexto, UIComponent componente, Object objeto) {
		
		if(objeto == null) {
			return null;
		}
		
		try {
			
			Long codigo = ((Estado) objeto).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());
			
			System.out.println("Executando aqui >>>>> ");
			
			return retorno;
		
		}catch (Exception e) {
			
			Long codigo = Long.valueOf(objeto.toString());		
			return codigo.toString();
		} 
	}
}
