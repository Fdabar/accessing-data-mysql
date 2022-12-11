package lt.dalius.springdemo.controller;

import lt.dalius.springdemo.repository.model.Customer;
import lt.dalius.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
// http://localhost:8080/customer
@RequestMapping(path = "/customer")
public class CustomerTemplatesController {

    @Autowired
    private CustomerService customerService;

    // http://localhost:8080/customer/test
    @GetMapping(path = "/test")
    public String getTestString(){
        return "test/html_test";
    }

    // http://localhost:8080/customer/firstpage/112
    @GetMapping(path = "/firstpage/{custId}")
    public String getCustomerForFirstPage(@PathVariable int custId, Model model){
        Customer customer = customerService.getCustomerByCustomerNumber(custId);
        model.addAttribute("company_name", customer.getCustomerName());
        model.addAttribute("contact_last_name", customer.getContactLastName());
        model.addAttribute("contact_first_name", customer.getContactFirstName());
        model.addAttribute("city", customer.getCity());
        model.addAttribute("country", customer.getCountry());
        model.addAttribute("creditLimit", customer.getCreditLimit());
        return "firstpage";
    }

    // http://localhost:8080/customer/template/112
    @GetMapping(path = "/template/{custId}")
    public String getCustomer(@PathVariable int custId, Model model){
        Customer customer = customerService.getCustomerByCustomerNumber(custId);
        model.addAttribute("key_customer", customer);
        return "/customer/customer_th";
    }

    // http://localhost:8080/customer/template/all
    @GetMapping(path = "/template/all")
    public String getCustomer(Model model){
        List<Customer> customers = customerService.getAllCustomers();
        model.addAttribute("listas", customers);
        return "/customer/customers_th";
    }
}
