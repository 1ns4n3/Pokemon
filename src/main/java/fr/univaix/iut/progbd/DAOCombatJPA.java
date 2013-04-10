package fr.univaix.iut.progbd;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class DAOCombatJPA implements DAOCombat {

    private EntityManager entityManager;

    public DAOCombatJPA(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public boolean delete(Combat obj) {
        try {
            EntityTransaction tx = entityManager.getTransaction();
            tx.begin();
            entityManager.remove(obj);
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Combat> findAll() {
        TypedQuery<Combat> query = entityManager.createNamedQuery(Combat.FIND_ALL, Combat.class);
        return query.getResultList();
    }

    @Override
    public Combat getById(String id) {
        return entityManager.find(Combat.class, id);
    }

    @Override
    public Combat insert(Combat obj) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(obj);
        tx.commit();
        return entityManager.find(Combat.class, obj.getNumC());
    }

    @Override
    public boolean update(Combat obj) {
        try {
            EntityTransaction tx = entityManager.getTransaction();
            tx.begin();
            entityManager.merge(obj);
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

	@Override
	public List<Combat> findByType(Type type) {
		// TODO Auto-generated method stub
		return null;
	}
}