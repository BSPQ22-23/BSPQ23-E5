package es.deusto.spq.server.dao;

import java.util.List;

/**
 * Base for DAO methods
 * @param <DomainObject>
 */
public interface IDataAccessObject<DomainObject> {
	public void save(DomainObject object);
	public void delete(DomainObject object);
	public List<DomainObject> getAll();
	public DomainObject find(String param);
	
	
}
