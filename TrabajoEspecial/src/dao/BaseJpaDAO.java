package dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

public class BaseJpaDAO<Entity, ID extends Serializable> implements DAO<Entity, ID>{
	EntityManager entityManager;
	Class<Entity> entityClass;
	Class<ID> idClass;

	public BaseJpaDAO(Class<Entity> entityClass, Class<ID> idClass) {
		this.entityClass = entityClass;
		this.idClass = idClass;
	}

	@Override
	public Entity findById(ID id) {
		Entity entity = entityManager.find(entityClass, id);
		return entity;
	}

	@Override
	public Entity persist(Entity entity) {
		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.getTransaction().commit();
		return entity;
	}

	@Override
	public boolean delete(ID id) {

		return false;
	}

	@Override
	public List<Entity> findAll() {

		return null;
	}

	@Override
	public Entity update(ID id, Entity newEntityValues) {

		return null;
	}
}
