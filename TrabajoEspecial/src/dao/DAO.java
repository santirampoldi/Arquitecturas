package dao;

import java.io.Serializable;
import java.util.List;

public interface DAO<Entity , ID extends Serializable> {
	public Entity findById(ID id);
	public Entity update(ID id, Entity newEntityValues);
	public Entity persist(Entity entity);
	public boolean delete(ID id);
	public List<Entity> findAll();
}