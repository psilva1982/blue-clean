package blue.converter;

import javax.faces.convert.FacesConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import blue.model.Cidade;
import blue.repository.Cidades;
import blue.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=Cidade.class)
public class CidadeConverter implements Converter {

	private Cidades cidades;
	
	public CidadeConverter() {
		this.cidades = CDIServiceLocator.getBean(Cidades.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		Cidade retorno = null;
		if(value != null) {
			try {
				retorno = this.cidades.getOne(new Long(value));	
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
			
			Long codigo = ((Cidade) objeto).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());
					
			return retorno;
		
		}catch (Exception e) {
			
			Long codigo = Long.valueOf(objeto.toString());		
			return codigo.toString();
		} 
	}
}
