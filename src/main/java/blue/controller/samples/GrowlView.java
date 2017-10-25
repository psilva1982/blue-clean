package blue.controller.samples;

import java.io.Serializable;



import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
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
