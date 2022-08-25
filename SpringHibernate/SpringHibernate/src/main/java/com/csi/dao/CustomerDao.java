package com.csi.dao;

import com.csi.model.Customer;

import java.util.List;

public interface CustomerDao {

 public void savebulkdata(List<Customer> customer);

 public void savedata(Customer customer);

 public   List<Customer> getalldata();

 public void updatedata(int custId,Customer customer);

 public void deletedata(double custId);

 public void deletealldata();

 public List<Customer> getdatabyname(String empName);

}
