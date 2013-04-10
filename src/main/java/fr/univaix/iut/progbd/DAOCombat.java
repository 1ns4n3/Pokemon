package fr.univaix.iut.progbd;


import java.util.List;

public interface DAOCombat extends DAO<Combat, String> {
    public List<Combat> findByType(Type type);
}