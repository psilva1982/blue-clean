package blue.controller.samples;

import java.io.Serializable;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import blue.repository.Estados;
import blue.service.CadastroEstadoService;

@Component
@Scope("request")
public class GrowlView implements Serializable {
    
	private static final long serialVersionUID = 1L;
	
	public void infoMessage() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Successful", "Blue Clean is beautiful"));
     
    }
 
    public void warnMessage() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Successful", "Blue Clean is beautiful"));
    }

    public void errorMessage() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Successful", "Blue Clean is beautiful"));
    }
    
}
