package com.example.examjpa.dao;

import com.example.examjpa.entity.Employee;
import com.example.examjpa.util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.sql.Connection;
import java.util.List;

public class EmployeeDAO {
    EntityManager em;
    EntityTransaction tran;
    public EmployeeDAO() {
        em = PersistenceUtil.getEntityManagerFactory().createEntityManager();
        tran = em.getTransaction();
    }

    public void insertEmployee(Employee employee) {
        try {
            tran.begin();
            em.persist(employee);
            tran.commit();

        }catch (Exception e){
            System.out.println(e.getMessage());
            tran.rollback();
        }
    }

    public Employee getEmployeeById(int id) {
        try {
            em.getTransaction().begin();
            Employee user = em.find(Employee.class, id);
            em.getTransaction().commit();
            return user;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public List<Employee> getAllEmployees() {
        TypedQuery<Employee> query = em.createQuery("SELECT u FROM Employee u", Employee.class);
        List<Employee> resultList = query.getResultList();
        return resultList;
    }

}
