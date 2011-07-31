package hu.jtechgroup.usermng.dao;

import org.springframework.stereotype.Repository;

import hu.jtechgroup.usermng.domain.Address;

/**
 * Address Entity kezeles
 *
 */
@Repository
public class AddressDAO extends GenericDAOWithJPA<Address, String> implements GenericDAO<Address, String> {

}
