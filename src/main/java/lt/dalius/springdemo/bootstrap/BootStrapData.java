package lt.dalius.springdemo.bootstrap;

import lt.dalius.springdemo.repository.CustomerRepository;
import lt.dalius.springdemo.repository.model.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BootStrapData implements CommandLineRunner {

    private CustomerRepository customerRepository;

    public BootStrapData(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {

//        customerRepository.findAll().forEach(System.out::println);
        List<Customer> customers = (List<Customer>) customerRepository.findAll();
        customers.forEach(System.out::println);

        System.out.println("=========================================");

        Customer customer = customerRepository.findById(112).get();
        System.out.println(customer);
    }
}
