package com.yaron.server.dao;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;



@Transactional
public abstract class GenericDaoImpl<T, ID extends Serializable> implements GenericDao<T,ID> {

	private Class<T> persistentClass;

	@PersistenceContext
    private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public GenericDaoImpl() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}


	@Override
    public T findById(ID id) {
		return (T) entityManager.find(persistentClass, id);
	}

	@Override
    @SuppressWarnings("unchecked")
	public List<T> findAll() {
		return entityManager.createQuery("FROM " + persistentClass.getName() ).getResultList();
	}
	
	@Override
    public long countAll() {
		return (Long) entityManager.createQuery("COUNT(*) FROM " + persistentClass ).getSingleResult();
	}

	@Override
    public void create(T entity) {
		entityManager.persist(entity);
	}

	@Override
    public void delete(T entity) {
		entityManager.remove(entity);
	}

	@Override
    public T merge(T entity) {
		return entityManager.merge(entity);

	}

	@Override
    public void clear() {
		entityManager.clear();
	}

    @Override
    public void flush() {
		entityManager.flush();
	}

    @Override
    @SuppressWarnings("unchecked")
	public List<T> findByNamedQuery(String namedQueryString, Object... values) {
		return getNamedQuery(namedQueryString, values).getResultList();
	}

	@Override
    @SuppressWarnings("unchecked")
	public T findUniqueResultByNamedQuery(final String namedQueryString, final Object... values) {
		return (T) getNamedQuery(namedQueryString, values).getSingleResult();
	}



	protected Query getNamedQuery(String namedQueryString, Object... values) {
        Query query = entityManager.createNamedQuery(namedQueryString);
        for (int i = 0; i < values.length; i++)
			query.setParameter(i, values[i]);
		return query;
	}



	@Override
    public void executeUpdateByNamedQuery(String query, Object... values) {
		getNamedQuery(query, values).executeUpdate();
	}

    protected Class<T> getPersistentClass() {
        return persistentClass;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
