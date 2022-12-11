package lt.dalius.springdemo.controller;

import lt.dalius.springdemo.repository.model.Customer;
import lt.dalius.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
        model.addAttribute("country", customer.getCountry());
        return "firstpage";
    }
}
