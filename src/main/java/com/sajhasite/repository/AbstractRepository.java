package com.sajhasite.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sajhasite.domain.entity.AbstractEntity;

public abstract class AbstractRepository<T> {
	
	@Autowired
    private SessionFactory sessionFactory;
	
	protected final Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public void save(T entity) {
		getSession().save(entity);
	}
	
	public void save(AbstractEntity entity) {
		getSession().save(entity);
	}
	
	public void update(T entity) {
		getSession().update(entity);
	}
	
	public void saveOrUpdate(T entity) {
		getSession().saveOrUpdate(entity);
	}
	
	public void get(Class<T> entityClass, Serializable primaryKey) {
		getSession().get(entityClass, primaryKey);
	}

	public void load(Class<T> entityClass, Serializable primaryKey) {
		getSession().load(entityClass, primaryKey);
	}
	
	@SuppressWarnings("unchecked")
	public T merge(T entity) {
		return (T) getSession().merge(entity);
	}	
	
	@SuppressWarnings("unchecked")
	protected final <E> List<E> executeNamedQuery(String queryName) {
		Query namedQuery = getSession().getNamedQuery(queryName);
		return namedQuery.list();
	}
	
	@SuppressWarnings("unchecked")
	protected final <E> List<E> executeNamedQuery(String queryName, String paramName, Object argument) {
		Query namedQuery = getSession().getNamedQuery(queryName);		
		namedQuery.setParameter(paramName, argument);
		return namedQuery.list();
	}
	
	@SuppressWarnings("unchecked")
	protected final <E> E executeNamedQueryUniqueResult(String queryName, String paramName, Object argument) {
		Query namedQuery = getSession().getNamedQuery(queryName);		
		namedQuery.setParameter(paramName, argument);
		return (E) namedQuery.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	protected final <E> List<E> executeNamedQuery(String queryName, String[] paramNames, Object[] arguments) {
		Query namedQuery = getSession().getNamedQuery(queryName);
		for(int i = 0; i < paramNames.length; i++) {
			namedQuery.setParameter(paramNames[i], arguments[i]);
		}
		return namedQuery.list();
	}
	
	@SuppressWarnings("unchecked")
	protected final <E> List<E> executeNamedQuery(String queryName, List<String> paramNames, List<Object> arguments) {
		Query namedQuery = getSession().getNamedQuery(queryName);
		for(int i = 0; i < paramNames.size(); i++) {
			namedQuery.setParameter(paramNames.get(i), arguments.get(i));
		}
		return namedQuery.list();
	}
	
	@SuppressWarnings("unchecked")
	protected final <E> List<E> executeNamedQuery(String queryName, Map<String, Object> paramNameArgMap) {
		Query namedQuery = getSession().getNamedQuery(queryName);
		for (Map.Entry<String, Object> paramNameArg : paramNameArgMap.entrySet()) {
			namedQuery.setParameter(paramNameArg.getKey(), paramNameArg.getValue());
		}
		return namedQuery.list();
	}
}
