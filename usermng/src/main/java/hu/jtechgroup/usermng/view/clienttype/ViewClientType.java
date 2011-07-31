package hu.jtechgroup.usermng.view.clienttype;

import hu.jtechgroup.usermng.domain.ClientType;
import hu.jtechgroup.usermng.services.UserManagementService;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("viewClientType")
@Scope("request")
public class ViewClientType implements Serializable{

	private ClientType clientType;
	
	@Autowired
	private UserManagementService services;
	
	@PostConstruct
	public void onLoad() {
		String clientTypeId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("code");
		clientType = services.findClientTypeById(clientTypeId);
	}
	
	public ClientType getClientType() {
		return clientType;
	}

	public void setClientType(ClientType clientType) {
		this.clientType = clientType;
	}
	
	public String update() {
		services.update(clientType);
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "ClientType is updated successfully", "OK");
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		return null;
	}
	
	public String remove() {
		services.remove(clientType);
		return "listClientTypes";
	}
}
