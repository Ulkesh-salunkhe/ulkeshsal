package com.csi.dao;

import com.csi.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerDaoImpl implements CustomerDao{

    private static SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();

    @Override
    public void savebulkdata(List<Customer> customer) {

        Session session = factory.openSession();

        for (Customer customer1 :customer ){
            Transaction transaction = session.beginTransaction();

            session.save(customer1);
            transaction.commit();
        }

    }

    @Override
    public void savedata(Customer customer) {

        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        session.save(customer);

        transaction.commit();

    }

    @Override
    public List<Customer> getalldata() {
        Session session = factory.openSession();

        List<Customer> customers = session.createQuery("from Customer").list();

        return customers;
    }

    @Override
    public void updatedata(int custId, Customer customer) {

        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        Customer customer1 =(Customer) session.get(Customer.class,custId);

       customer1.setCustName(customer.getCustName());
        customer1.setCustContactNumber(customer.getCustContactNumber());
        customer1.setCustAccountBalance(customer.getCustAccountBalance());
        customer1.setCustAddress(customer.getCustAddress());
        customer1.setCustDOB(customer.getCustDOB());

        session.update(customer1);
        transaction.commit();

    }

    @Override
    public void deletedata(double custId) {
        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        Customer customer1 =(Customer) session.get(Customer.class,custId);

        session.delete(customer1);
        transaction.commit();
    }

    @Override
    public void deletealldata() {

        Session session = factory.openSession();



        for(Customer customer : getalldata()){
            Transaction transaction = session.beginTransaction();
            session.delete(customer);
            transaction.commit();

        }

    }

    @Override
    public List<Customer> getdatabyname(String empName) {

        List<Customer> customerList = new ArrayList<>();
        for(Customer customer : getalldata()){
            if(customer.getCustName().equals(empName)){
               customerList.add(customer);

            }
        } return customerList;



    }
}
