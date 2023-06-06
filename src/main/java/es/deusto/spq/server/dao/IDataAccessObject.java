package es.deusto.spq.server.dao;

import java.util.List;

/**
 * INTERFACE
 * @author Maitane
 *
 * @param INTERFACE FOR DATA ACCESS
 */
public interface IDataAccessObject<DomainObject> {
	public void save(DomainObject object);
	public void delete(DomainObject object);
	public List<DomainObject> getAll();
	public DomainObject find(String param);
	
	
	
}
