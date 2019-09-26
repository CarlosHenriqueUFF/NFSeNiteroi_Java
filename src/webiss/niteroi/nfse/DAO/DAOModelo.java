/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webiss.niteroi.nfse.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import webiss.niteroi.nfse.util.EntityManagerUtil;

/**
 *
 * @author Carlos Henrique Carvalho da Silva <carlos_henrique@id.uff.br>
 * @param <T>
 */
public class DAOModelo<T> {

    protected EntityManager entityManager;

    public DAOModelo() {
        this.entityManager = EntityManagerUtil.getEntityManager();
    }

    public String insert(T object) {
        if (object != null) {
            entityManager.getTransaction().begin();
            try {
            entityManager.persist(object);
            entityManager.getTransaction().commit();
            } catch (Exception ex){
                entityManager.getTransaction().rollback();
            } finally {
                entityManager.close();
            }
            return null;
        }
        return "Erro ao inserir, objeto Nulo.";
    }
    
    public T insertReturn(T object) {
        if (object != null) {
            entityManager.getTransaction().begin();
            try {
                entityManager.persist(object);
                //entityManager.flush();
                entityManager.getTransaction().commit();
            } catch (Exception ex){
                object = null;
                entityManager.getTransaction().rollback();
            } finally {
                entityManager.close();
            }
            return object;
        }
        return null;
    }

    public String update(T object) {
        if (object != null) {
            entityManager.getTransaction().begin();
            try {
                entityManager.merge(object);
                entityManager.getTransaction().commit();
            } catch (Exception ex){
                if (entityManager.getTransaction().isActive()){
                    entityManager.getTransaction().rollback();
                }
            } finally {
                entityManager.close();
            }
            return null;
        }
        return "Erro ao atualizar, objeto Nulo.";
    }

    public T updateReturn(T object) {
        if (object != null) {
            entityManager.getTransaction().begin();
            try {
                entityManager.merge(object);
                entityManager.getTransaction().commit();
            } catch (Exception ex){
                if (entityManager.getTransaction().isActive()){
                    entityManager.getTransaction().rollback();
                }
                object = null;
            } finally {
                entityManager.close();
            }
            return object;
        }
        return null;
    }
    
    public T getByID(String modelClassName, Integer id) {
        Query query = this.entityManager.createQuery(""
                + "select a"
                + "  from " + modelClassName + " a "
                + " where a.id = " + id);
        Object object;
        object = query.getSingleResult();
        this.entityManager.close();
        return (T) object;
    }

    public T getByNamedQuery(String namedQueryName) {
        Query query = this.entityManager.createNamedQuery(namedQueryName).setMaxResults(1);
        Object object;
        object = query.getSingleResult();
        return (T) object;

    }

    public <T> List<T> getListByNamedQuery(String namedQueryName) throws IllegalAccessException {
        Query query = this.entityManager.createNamedQuery(namedQueryName);
        List objectList;
        objectList = query.getResultList();
        this.entityManager.close();
        return objectList;
    }
}
