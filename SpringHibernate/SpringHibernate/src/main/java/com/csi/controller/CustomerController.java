package com.csi.controller;

import com.csi.model.Customer;
import com.csi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/hello")
    public String sayHello(){

        return "Welcome To Fintech CSI Pune";
    }

    @PostMapping("/savebulkdata")
    public String bigdata(@RequestBody List<Customer> customer){

        customerService.savebulkdata(customer);
        return "data saved successfully!!";
    }

    @PostMapping("/savedata")
    public String savedata(@RequestBody Customer customer){


         customerService.savedata(customer);
         return "data succesfully inserted";
    }

    @GetMapping("/getdata")
    public List<Customer> getlldata(){

       return customerService.getalldata();

    }
    @PutMapping("/updatedata/{custId}")
    public String updatedata(@PathVariable int custId, @RequestBody Customer customer){

       customerService.updatedata(custId, customer);
        return "data inserted succesfully";
    }
 @DeleteMapping("/deletedata/{custId}")
    public String deletdata(@PathVariable double custId) {

     customerService.deletedata(custId);
     return "data deleted succesfully";
 }
        @DeleteMapping("/deletealldata")
                public  String delealldata(){

            customerService.deletealldata();
           return "data deleted succesfully";

 }    @GetMapping("/getdatebyname/{custName}")
    public List<Customer> getdatabyname(@PathVariable String custName){

        return customerService.getdatabyname(custName);


    }
}
