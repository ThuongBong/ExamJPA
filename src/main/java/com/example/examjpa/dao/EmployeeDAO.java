package com.example.examjpa.dao;

import com.example.examjpa.entity.EmployeeEntity;
import com.example.examjpa.util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class EmployeeDAO {
    EntityManager em;
    EntityTransaction tran;
    public EmployeeDAO() {
        em = PersistenceUtil.getEntityManagerFactory().createEntityManager();
        tran = em.getTransaction();
    }

    public void insertEmployee(EmployeeEntity employeeEntity) {
        try {
            tran.begin();
            em.persist(employeeEntity);
            tran.commit();

        }catch (Exception e){
            System.out.println(e.getMessage());
            tran.rollback();
        }
    }

    public EmployeeEntity getEmployeeById(int id) {
        try {
            em.getTransaction().begin();
            EmployeeEntity user = em.find(EmployeeEntity.class, id);
            em.getTransaction().commit();
            return user;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public List<EmployeeEntity> getAllEmployees() {
        TypedQuery<EmployeeEntity> query = em.createQuery("SELECT e FROM EmployeeEntity e", EmployeeEntity.class);
        List<EmployeeEntity> resultList = query.getResultList();
        return resultList;
    }

}
