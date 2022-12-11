package lt.dalius.springdemo.controller;

import lt.dalius.springdemo.repository.CustomerRepository;
import lt.dalius.springdemo.repository.model.Customer;
import lt.dalius.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerRepository customerRepository;

    // http://localhost:8080/test
    @GetMapping(path = "/test")
    public @ResponseBody String getTestString(){
        return "Here is some text for test";
    }

    // http://localhost:8080/customers
    @GetMapping(path = "/customers")
    public @ResponseBody List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }


    // http://localhost:8080/customer/112
    @GetMapping(path = "/customer/{id}")
    public @ResponseBody Customer getCustomerById(@PathVariable int id){
        return customerService.getCustomerById(id);
    }

    // http://localhost:8080/customer/by/112
    @GetMapping(path = "/customer/by/{id}")
    public @ResponseBody Customer getCustomerByCustomerNumber(@PathVariable int id){
        return customerService.getCustomerByCustomerNumber(id);
    }

    // http://localhost:8080/customer/name/Motor%20Mint%20Distributors%20Inc.
    @GetMapping(path = "/customer/name/{name}")
    public @ResponseBody Customer getCustomerByCustomerName(@PathVariable String name){
        return customerService.getCustomerName(name);
    }

    // http://localhost:8080/customer/like/a
    @GetMapping(path = "/customer/like/{name}")
    public @ResponseBody List<Customer> getCustomerByCustomerNameLike(@PathVariable String name){
        return customerService.getCustomerNameLike(name);
    }

    // http://localhost:8080/customer/like?name=a
    @GetMapping(path = "/customer/like")
    public @ResponseBody List<Customer> getCustomerByCustomerNameLikeParam(@RequestParam String name){
        return customerService.getCustomerNameLike(name);
    }
}
