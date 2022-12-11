package lt.dalius.springdemo.repository;

import lt.dalius.springdemo.repository.model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    Optional<Customer> findByCustomerNumber(int id);
    Optional<Customer> findByCustomerName(String name);
    Iterable<Customer> findByCustomerNameLike(String name);
    // SELECT * FROM customers WHERE customerName Like @name 'a%'
}
