package hu.jtechgroup.usermng.jsf;


import hu.jtechgroup.usermng.domain.ClientType;
import hu.jtechgroup.usermng.services.UserManagementService;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;

/**
 *
 * @author levent
 */
public class ClientTypeLazyDataModel extends LazyDataModel<ClientType> {

    private UserManagementService service;

    public ClientTypeLazyDataModel(UserManagementService service) {
    	this.service = service;
    }
    
    public UserManagementService getService() {
        return service;
    }

    public void setService(UserManagementService service) {
        this.service = service;
    }

	@Override
	public List<ClientType> load(int first, int pageSize, String sortField, boolean sortOrder, Map<String, String> filters) {
        setRowCount(10);
        setWrappedData(getService().loadLazyClientTypes(first, pageSize, sortField, sortOrder, filters));
        return (List)getWrappedData();
	}
}
