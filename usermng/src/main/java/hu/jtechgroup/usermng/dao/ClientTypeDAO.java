package hu.jtechgroup.usermng.dao;

import hu.jtechgroup.usermng.domain.ClientType;

import org.springframework.stereotype.Repository;

/**
 * ClientType Entity kezeles
 *
 */
@Repository
public class ClientTypeDAO extends GenericDAOWithJPA<ClientType, String> implements GenericDAO<ClientType, String> {

	public void doSomething() {
		System.out.println("DO NOTHING");
	}
	
}
