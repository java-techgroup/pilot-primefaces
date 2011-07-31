package hu.jtechgroup.usermng.services;

import hu.jtechgroup.usermng.dao.AddressDAO;
import hu.jtechgroup.usermng.dao.ClientDAO;
import hu.jtechgroup.usermng.dao.ClientTypeDAO;
import hu.jtechgroup.usermng.dao.GroupDAO;
import hu.jtechgroup.usermng.domain.Address;
import hu.jtechgroup.usermng.domain.Client;
import hu.jtechgroup.usermng.domain.ClientType;
import hu.jtechgroup.usermng.domain.Group;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service osztaly, amelyben minden usermanagement szolgaltatast osszegyujtunk.
 * (ez nem egy 'vegleges' megoldas, de egyszerubb igy kezelni)
 *
 */
@Service("usermngService")
public class UserManagementService {

	@Autowired
	private ClientTypeDAO clientTypeDAO;

	@Autowired
	private ClientDAO clientDAO;

	@Autowired
	private AddressDAO addressDAO;

	@Autowired
	private GroupDAO groupDAO;
	
	/*
	 * ClientType kezeles
	 */
	
	@Transactional
	public void createNew(ClientType clientType) {
		clientTypeDAO.persist(clientType);
	}

	@Transactional
	public void update(ClientType clientType) {
		clientTypeDAO.update(clientType);
	}

	@Transactional
	public void remove(ClientType clientType) {
		clientTypeDAO.delete(clientType);
	}

	@Transactional(readOnly = true)
	public ClientType findClientTypeById(String id) {
		return clientTypeDAO.loadById(id);
	}

	@Transactional(readOnly = true)
	public List<ClientType> findAllClientType() {
		return clientTypeDAO.loadAll();
	}

	@Transactional(readOnly = true)
	public List<ClientType> loadLazyClientTypes(int first, int pageSize, String sortField, boolean sortOrder, Map<String, String> filters) {
		return clientTypeDAO.loadLazy(first, pageSize, sortField, sortOrder ? "asc" : "desc", filters);
	}

	
	/*
	 * Client kezeles
	 */
	
	@Transactional
	public void createNew(Client client) {
		clientDAO.persist(client);
	}

	@Transactional
	public void update(Client client) {
		clientDAO.update(client);
	}

	@Transactional
	public void remove(Client client) {
		clientDAO.delete(client);
	}

	@Transactional(readOnly = true)
	public List<Client> findAllClient() {
		return clientDAO.loadAll();
	}

	@Transactional(readOnly = true)
	public Client findClientById(String id) {
		return clientDAO.loadById(id);
	}

	@Transactional(readOnly = true)
	public List<Client> loadLazyClients(int first, int pageSize, String sortField, boolean sortOrder, Map<String, String> filters) {
		return clientDAO.loadLazy(first, pageSize, sortField, sortOrder ? "asc" : "desc", filters);
	}

	
	/*
	 * Address kezeles
	 */
	
	@Transactional
	public void createNew(Address address) {
		addressDAO.persist(address);
	}

	@Transactional
	public void update(Address address) {
		addressDAO.update(address);
	}

	@Transactional
	public void remove(Address address) {
		addressDAO.delete(address);
	}

	@Transactional(readOnly = true)
	public Address findAddressById(String id) {
		return addressDAO.loadById(id);
	}

	@Transactional(readOnly = true)
	public List<Address> findAllAddress() {
		return addressDAO.loadAll();
	}

	@Transactional(readOnly = true)
	public List<Address> loadLazyAddresses(int first, int pageSize, String sortField, boolean sortOrder, Map<String, String> filters) {
		return addressDAO.loadLazy(first, pageSize, sortField, sortOrder ? "asc" : "desc", filters);
	}

	
	/*
	 * Group kezeles
	 */
	
	@Transactional
	public void createNew(Group group) {
		groupDAO.persist(group);
	}

	@Transactional
	public void update(Group group) {
		groupDAO.update(group);
	}

	@Transactional
	public void remove(Group group) {
		groupDAO.delete(group);
	}

	@Transactional(readOnly = true)
	public Group findGroupById(String code) {
		return groupDAO.loadById(code);
	}

	@Transactional(readOnly = true)
	public List<Group> findAllGroup() {
		return groupDAO.loadAll();
	}

	@Transactional(readOnly = true)
	public List<Group> loadLazyGroups(int first, int pageSize, String sortField, boolean sortOrder, Map<String, String> filters) {
		return groupDAO.loadLazy(first, pageSize, sortField, sortOrder ? "asc" : "desc", filters);
	}

	
	public ClientTypeDAO getClientTypeDAO() {
		return clientTypeDAO;
	}

	public void setClientTypeDAO(ClientTypeDAO clientTypeDAO) {
		this.clientTypeDAO = clientTypeDAO;
	}

	public ClientDAO getClientDAO() {
		return clientDAO;
	}

	public void setClientDAO(ClientDAO clientDAO) {
		this.clientDAO = clientDAO;
	}

	public AddressDAO getAddressDAO() {
		return addressDAO;
	}

	public void setAddressDAO(AddressDAO addressDAO) {
		this.addressDAO = addressDAO;
	}

	public GroupDAO getGroupDAO() {
		return groupDAO;
	}

	public void setGroupDAO(GroupDAO groupDAO) {
		this.groupDAO = groupDAO;
	}
	
}