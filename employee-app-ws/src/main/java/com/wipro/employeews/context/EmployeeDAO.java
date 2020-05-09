package com.wipro.employeews.context;

import com.wipro.employeews.config.HibernateUtil;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;

public class EmployeeDAO {

    Session session;

    public void openConnecton() {
        this.session = HibernateUtil.getSessionFactory().openSession();
    }

    public void closeConnection() {
        if (Objects.nonNull(session)) {
            session.close();
        }
    }

    List<Employee> findAll() {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Employee> root = cq.from(Employee.class);
        cq.select(root);
        return session.createQuery(cq).getResultList();
    }

    List<Employee> findByEmpLocation(String empLocation) {
        return listEmployeeByParams("empLocation", empLocation);
    }

    List<Employee> findByEmpBand(String empBand) {
        return listEmployeeByParams("empBand", empBand);
    }

    void save(Employee employee) {
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
    }

    void update(Employee employee) {
        session.beginTransaction();
        session.saveOrUpdate(employee);
        session.getTransaction().commit();
    }

    Optional<Employee> findById(String empId) {
        List<Employee> list = listEmployeeByParams("empId", empId);
        if (!list.isEmpty()) {
            return Optional.of(list.get(0));
        }
        return Optional.empty();
    }

    private List<Employee> listEmployeeByParams(String field, Object value) {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Employee> root = cq.from(Employee.class);
        cq.select(root);
        cq.where(cb.equal(root.get(field), value));
        List<Employee> employees = session.createQuery(cq).getResultList();
        return Objects.nonNull(employees) ? employees : Collections.EMPTY_LIST;
    }

}
