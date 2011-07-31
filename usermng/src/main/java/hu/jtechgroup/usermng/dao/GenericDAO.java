package hu.jtechgroup.usermng.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Altalanos DAO osztaly (Tipus es ID parameterekkel) 
 *
 * @param <T> - az entitas tipus, amelyet kezelne az adott DAO osztaly
 * @param <ID> - az adott entitas azonositojank tipusa
 */
public interface GenericDAO<T, ID extends Serializable> {
	  
	T loadById(ID id);
	
	void persist(T entity);
	
	void update(T entity);
	
	void delete(T entity);
	
	List<T> loadAll();

}
