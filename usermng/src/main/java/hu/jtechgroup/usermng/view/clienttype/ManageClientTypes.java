package hu.jtechgroup.usermng.view.clienttype;

import hu.jtechgroup.usermng.domain.ClientType;
import hu.jtechgroup.usermng.jsf.ClientTypeLazyDataModel;
import hu.jtechgroup.usermng.services.UserManagementService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.faces.event.ActionEvent;

import org.primefaces.model.LazyDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Kliens tipusokat kezelo bean
 *
 */
@Component("manageClientTypes")
@Scope("session")
public class ManageClientTypes implements Serializable {

	private LazyDataModel<ClientType> types;
	private UserManagementService services;
	private String code;

	private ClientType type;

	
	@Autowired
	public ManageClientTypes(UserManagementService services) {
		this.services = services;
		types = new ClientTypeLazyDataModel(services);
	}

	public LazyDataModel<ClientType> getClientTypes() {
		return types;
	}

	public void setClientTypes(LazyDataModel<ClientType> types) {
		this.types = types;
	}
	


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public ClientType getType() {
		return type;
	}

	public void setType(ClientType type) {
		this.type = type;
	}

	public List<String> getClientTypeByTitle(String code) {
		List<ClientType> foundClientTypes = services.findAllClientType();
		List<String> titles = new ArrayList<String>();

		for (ClientType c : foundClientTypes) {
			titles.add(c.getCode());
		}

		return titles;
	}

	public void search(ActionEvent actionEvent) {
		types.load(0, 10, null, true, new HashMap<String, String>() {
			{
				put("title", getCode());
			}
		});
	}
}