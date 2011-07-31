package hu.jtechgroup.usermng.view.clienttype;

import hu.jtechgroup.usermng.domain.ClientType;
import hu.jtechgroup.usermng.services.UserManagementService;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("createClientType")
@Scope("request")
public class CreateClientType implements Serializable {

	private ClientType clientType = new ClientType();

	@Autowired
	private UserManagementService services;

	public ClientType getClientType() {
		return clientType;
	}

	public void setClientType(ClientType clientType) {
		this.clientType = clientType;
	}

	public void save(ActionEvent actionEvent) {
		services.createNew(clientType);
		FacesMessage facesMessage = new FacesMessage( FacesMessage.SEVERITY_INFO, "Info", "ClientType is saved" );
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		clientType = new ClientType();
	}
}