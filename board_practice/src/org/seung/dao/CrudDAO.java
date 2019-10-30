package org.seung.dao;

public interface CrudDAO<V, K> {
	
	public boolean insert(V vo);
	
	public V select(K key);
	
	public boolean update(V vo);
	
	public boolean delete(K key);

}
