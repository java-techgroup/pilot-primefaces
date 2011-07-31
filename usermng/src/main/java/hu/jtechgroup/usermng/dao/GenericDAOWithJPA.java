package hu.jtechgroup.usermng.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * A GenericDAO olyan kiegeszitese, amely mar definialtan JPA-s Entitasokkal
 * dolgozik.
 * 
 * @see GenericDAO
 */
public abstract class GenericDAOWithJPA<T, ID extends Serializable> implements GenericDAO<T, ID> {

	// a kezelt Entity
	private Class<T> persistentClass;

	// az EntityManager, amelyen keresztul az entitast kezelni lehet (ebbol kell leszarmaztatni)
	@PersistenceContext
	protected EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public GenericDAOWithJPA() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public T loadById(ID id) {
		return entityManager.find(persistentClass, id);
	}

	public void persist(T entity) {
		entityManager.persist(entity);
	}

	public void update(T entity) {
		entityManager.merge(entity);
	}

	public void delete(T entity) {
		entityManager.remove(entity);
	}

	@SuppressWarnings("unchecked")
	public List<T> loadAll() {
		return entityManager.createQuery("Select t from " + persistentClass.getSimpleName() + " t").getResultList();
	}
	
	@SuppressWarnings("unchecked")
    public List<T> loadLazy(int first, int pageSize, String sortField, String sortOrder, Map<String, String> filters){
    	// where feltetel osszerakasa
        String where = "";
        for (Map.Entry<String, String> e : filters.entrySet()) {
            where += (where.length()>0 ? " AND " : "") + e.getKey() + " like '" + e.getValue() + "%'";
        }
        
        // query osszerakasa
        Query lazy = entityManager.createQuery(
        		"SELECT m FROM " + persistentClass.getSimpleName() + " m" +										// alap query 
        		(where.length() > 0 ? " where " +  where : "") +							 					// where feltetel (opcionalis)
        		(sortField != null && sortOrder != null ? " order by " + sortField + " " + sortOrder : "")		// rendezesi resz (opcionalis)
        );
        lazy.setFirstResult(first);
        lazy.setMaxResults(pageSize);
        
        return lazy.getResultList();
    }
}
