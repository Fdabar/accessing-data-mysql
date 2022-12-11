package lt.dalius.springdemo.controller;

import lt.dalius.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
}
