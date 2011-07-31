package hu.jtechgroup.usermng.dao;

import org.springframework.stereotype.Repository;

import hu.jtechgroup.usermng.domain.Group;

/**
 * Group Entity kezeles
 *
 */
@Repository
public class GroupDAO extends GenericDAOWithJPA<Group, String> implements GenericDAO<Group, String> {

}
