package hu.jtechgroup.usermng.dao;

import org.springframework.stereotype.Repository;

import hu.jtechgroup.usermng.domain.Client;

/**
 * Client Entity kezeles
 *
 */
@Repository
public class ClientDAO extends GenericDAOWithJPA<Client, String> implements GenericDAO<Client, String> {

}
