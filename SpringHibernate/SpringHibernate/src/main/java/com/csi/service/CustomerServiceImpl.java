package com.csi.service;

import com.csi.dao.CustomerDao;
import com.csi.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements  CustomerService{

    @Autowired
    CustomerDao customerDao;

    @Override
    public void savebulkdata( List<Customer>  customer) {

         customerDao.savebulkdata( customer);

    }

    @Override
    public void savedata(Customer customer) {

        customerDao.savedata(customer);

    }

    @Override
    public List<Customer> getalldata() {

        return customerDao.getalldata();
    }

    @Override
    public void updatedata(int custId, Customer customer) {
        customerDao.updatedata(custId, customer);
    }

    @Override
    public void deletedata(double custId) {

   customerDao.deletedata(custId);
    }

    @Override
    public void deletealldata() {
        customerDao.deletealldata();
    }

    @Override
    public List<Customer> getdatabyname(String empName) {
        return customerDao.getdatabyname(empName);
    }
}
