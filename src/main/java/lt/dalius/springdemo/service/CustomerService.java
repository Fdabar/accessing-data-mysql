package lt.dalius.springdemo.service;

import lt.dalius.springdemo.repository.CustomerRepository;
import lt.dalius.springdemo.repository.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer getCustomerById(int id){
        if(customerRepository.findById(id).isEmpty())
            return new Customer();
        return customerRepository.findById(id).get();
    }

    public List<Customer> getAllCustomers(){
        return (List<Customer>) customerRepository.findAll();
    }

    public Customer getCustomerByCustomerNumber(int id){
        if(customerRepository.findByCustomerNumber(id).isEmpty())
            return new Customer();
        return customerRepository.findByCustomerNumber(id).get();
    }

    public Customer getCustomerName(String name){
        if(customerRepository.findByCustomerName(name).isEmpty())
            return new Customer();
        return customerRepository.findByCustomerName(name).get();
    }

    public List<Customer> getCustomerNameLike(String name){
        return (List<Customer>) customerRepository.findByCustomerNameLike(
                String.format("%%%s%%", name)   // % + name + %
        );
    }


}
